package org.lanye.dream_eatery.content.kitchen.blockentity;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.lanye.dream_eatery.bootstrap.block.ModBlocks;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * 果酱锅：放置时由 {@link org.lanye.dream_eatery.content.kitchen.block.JamPotBlock#setPlacedBy}
 * 写入 {@code PendingEnter} 并<strong>显式</strong>广播 {@link ClientboundBlockEntityDataPacket}；
 * 客户端在 {@link #handleUpdateTag} 或放置预测路径见到后再播 {@code animation.jam_pot.enter}
 * （T019：勿当帧 {@code triggerAnim} 发包赌时机；亦勿只靠 {@code sendBlockUpdated}，其不会带上本标记）。
 *
 * <p>标记<strong>不</strong>写入存档，避免区块重载再播。
 */
public class JamPotBlockEntity extends BlockEntity implements GeoBlockEntity {

    public static final String MAIN_CONTROLLER = "main";
    private static final String TRIGGER_ENTER = "enter";
    private static final String NBT_PENDING_ENTER = "PendingEnter";

    private static final String ENTER_ANIM_NAME = "animation.jam_pot.enter";

    private static final RawAnimation ENTER_ONCE =
            RawAnimation.begin().then(ENTER_ANIM_NAME, Animation.LoopType.PLAY_ONCE);

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    /** 仅服务端、仅用于组装下一次 update 包；写入包后立刻清掉。 */
    private boolean pendingEnter;

    /** 客户端：本次放置已请求过入场，避免预测路径与 update 包各播一次。 */
    private boolean clientEnterRequested;

    public JamPotBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.JAM_POT.blockEntityType().get(), pos, state);
    }

    /**
     * 服务端：放置后请求入场动画。只同步标记，不当帧 {@link #triggerAnim}（T019）。
     * 必须显式发送 BE 数据包；仅 {@code sendBlockUpdated} 不会把 {@code PendingEnter} 送到客户端。
     */
    public void onServerRequestEnterAnim() {
        if (!(this.level instanceof ServerLevel server)) {
            return;
        }
        this.pendingEnter = true;
        ClientboundBlockEntityDataPacket packet = ClientboundBlockEntityDataPacket.create(this);
        this.pendingEnter = false;

        double x = this.worldPosition.getX() + 0.5;
        double y = this.worldPosition.getY() + 0.5;
        double z = this.worldPosition.getZ() + 0.5;
        for (ServerPlayer player : server.players()) {
            if (player.distanceToSqr(x, y, z) <= 4096.0) {
                player.connection.send(packet);
            }
        }
    }

    /** 客户端：放置预测时 BE 已存在，直接播入场（与旁观者的 update 包路径共用去重）。 */
    public void onClientPlayEnterAnim() {
        if (this.level == null || !this.level.isClientSide || this.clientEnterRequested) {
            return;
        }
        this.clientEnterRequested = true;
        triggerAnim(MAIN_CONTROLLER, TRIGGER_ENTER);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = super.getUpdateTag(registries);
        if (this.pendingEnter) {
            tag.putBoolean(NBT_PENDING_ENTER, true);
        }
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag, HolderLookup.Provider registries) {
        super.handleUpdateTag(tag, registries);
        if (this.level != null
                && this.level.isClientSide
                && tag.getBoolean(NBT_PENDING_ENTER)) {
            onClientPlayEnterAnim();
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
                new AnimationController<>(this, MAIN_CONTROLLER, 0, state -> PlayState.STOP)
                        .triggerableAnim(TRIGGER_ENTER, ENTER_ONCE));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
