package org.lanye.dream_eatery.content.kitchen.blockentity;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
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
 * 写入 {@code PendingEnter} 同步标记；客户端在 {@link #handleUpdateTag} 见到标记后再播
 * {@code animation.jam_pot.enter}（T019，避免当帧 {@code triggerAnim} 包早于客户端 BE）。
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

    /** 仅服务端、仅用于组装下一次 update 包；发包后立刻清掉。 */
    private boolean pendingEnter;

    public JamPotBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.JAM_POT.blockEntityType().get(), pos, state);
    }

    /**
     * 服务端：放置后请求入场动画。只同步标记，不当帧 {@link #triggerAnim}（T019）。
     */
    public void onServerRequestEnterAnim() {
        if (!(this.level instanceof ServerLevel)) {
            return;
        }
        this.pendingEnter = true;
        BlockState state = getBlockState();
        this.level.sendBlockUpdated(this.worldPosition, state, state, Block.UPDATE_CLIENTS);
        this.pendingEnter = false;
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
            triggerAnim(MAIN_CONTROLLER, TRIGGER_ENTER);
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
