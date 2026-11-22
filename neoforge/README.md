# NeoForge 构建入口（与无后缀仓共用资源）

- `workspace-1.21.1` 的 `projectDir` 指向本目录。
- 资源：`../src/main/resources`。
- Java：`overlay/java` 优先；主仓独有文件经 `prepare-neoforge-content-sources.gradle` 合并。
- 日常实装改 `../src/main/`。
