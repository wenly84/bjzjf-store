# 前后端分离项目本地环境配置介绍

## 一、环境核心说明

本项目采用**前后端分离架构**，前端负责页面渲染与交互逻辑，后端提供 API 接口服务，同时依赖 MySQL 数据库与 Redis 缓存服务支撑业务运行。为实现本地开发环境与团队共享开发环境的服务隔离，需通过修改本地`hosts`文件映射自定义域名，避免直接使用 IP + 端口访问导致的配置混乱，确保不同环境下后端服务访问的一致性与灵活性。

## 二、Hosts 配置解读

### 1. 配置内容（Windows 路径：`C:\Windows\System32\drivers\etc\hosts`；Linux/Mac 路径：`/etc/hosts`）



```
\# 项目后端服务域名映射（区分环境）
# 本地环境
127.0.0.1 local.mysql.bjzjf-store  # 本机mysql（个人开发环境，仅本机可访问）
127.0.0.1 local.redis.bjzjf-store  # 本机redis（个人开发环境，仅本机可访问）
127.0.0.1 local.bjzjf-store.com    # 本地后端服务（个人开发环境，仅本机可访问）

# 开发环境
192.168.0.* dev.mysql.bjzjf-store  # (*代表和你一起联调的同事机器)
192.168.0.* dev.redis.bjzjf-store  # 开发联调redis
192.168.0.* dev.bjzjf-store.com    # 开发联调后端服务

# 测试环境
192.168.0.127 mysql.bjzjf-store
192.168.0.127 redis.bjzjf-store
192.168.0.127 bjzjf-store.com
```

### 2. 配置作用



* `127.0.0.1`：本地回环地址，映射到该 IP 的域名指向本机服务（若 `dev.bjzjf-store.com` 为团队内网服务，需将 IP 改为内网服务器地址，此处默认本地模拟场景）。

* **环境区分前缀**：通过 `local`（个人本地后端）、`dev`（团队开发环境后端）的前缀明确环境属性，避免开发时混淆环境，减少因环境差异导致的接口联调问题。

## 三、各服务角色与访问方式



| 服务类型      | 域名                                                   | 环境属性   | 访问场景              | 典型端口（参考）                |
| --------- | ---------------------------------------------------- | ------ | ----------------- | ----------------------- |
| 后端服务      | local.bjzjf-store.com | 个人本地环境 | 本地开发调试、单接口测试      | 1984（Java） |
| 后端服务      | dev.bjzjf-store.com     | 团队开发环境 | 多人间联调、功能集成测试      | 1984（与本地端口保持一致，便于切换）    |
| MySQL 数据库 | local.mysql.bjzjf-store                                     | 本地中间件  | 本地后端服务数据存储        | 3306                    |
| Redis 缓存  | local.redis.bjzjf-store                                     | 本地中间件  | 本地后端服务缓存支撑（如会话存储） | 6379                    |

### 前端服务补充说明

前端服务默认通过 `localhost` 或 `127.0.0.1` 访问（如 `http://localhost:81`，根据前端框架默认端口调整），需在前端配置文件（如 `env.development`）中指定后端接口基础地址，示例：



* 本地开发时：`VITE_BASE_URL = ``http://local.bjzjf-store.com:1984`

* 团队联调时：`VITE_BASE_URL = ``http://dev.bjzjf-store.com:1984`

## 四、本地环境搭建步骤



1. **安装依赖软件**：

* 后端开发环境：根据技术栈安装，如 Java 项目需 JDK17 + Maven-3.6.3）。

* 中间件：安装 MySQL 与 Redis，启动服务并确认端口未被占用（可通过 `netstat -ano | findstr "3306"` 检查端口占用）。

1. **修改 Hosts 文件**：

* 按上述配置内容添加域名映射（Windows 需右键记事本以 “管理员身份” 打开文件，Linux/Mac 需执行 `vi /etc/hosts` 编辑）。

* 验证配置：终端执行 `ping ``local.bjzjf-store.com` 和 `ping ``dev.bjzjf-store.com`，若返回 `127.0.0.1` 的响应（或团队内网 IP 响应），说明映射生效。

1. **启动与测试服务**：

* 本地后端服务：通过 IDE 运行项目主类（如 SpringBoot 主启动类），访问 `http://local.bjzjf-store.com:1984`（检查接口），返回 `200 OK` 即启动成功。

* 团队开发环境后端：若为内网服务，确保本机已接入团队内网，访问 `http://dev.bjzjf-store.com:1984` 验证连通性。

* 中间件测试：通过工具连接（如 Navicat 连接 `mysql.bjzjf-store:3306`，Redis Desktop Manager 连接 `redis.bjzjf-store:6379`），确认可正常操作数据。

## 五、注意事项



1. **环境切换技巧**：

* 无需修改代码，仅需调整前端接口基础地址或后端配置文件中的环境标识（如 `spring.profiles.active=dev`），即可在本地与团队开发环境间切换。

* 若 `dev.bjzjf-store.com` 为团队内网服务器，需将 `hosts` 中的 `127.0.0.1` 改为内网服务器 IP（如 `192.168.0.246`` ``dev.bjzjf-store.com`），并确保内网通畅。

1. **端口冲突处理**：

* 若启动后端服务时提示 “端口被占用”（如 1984 被占用），需修改后端配置文件中的端口（如 `server.port=1985`），同时同步更新前端接口基础地址的端口（如 `http://local.bjzjf-store.com:1985`）。

1. **团队配置同步**：

* 所有成员需统一 `hosts` 中的域名（如 `local.bjzjf-store.com` 不可自定义为其他名称），避免因域名差异导致联调失败。

* 团队开发环境的后端服务版本需保持一致，建议通过 Git 管理代码版本，联调前同步最新代码。

1. **安全与环境隔离**：

* 禁止将 `local/dev` 环境的配置（尤其是数据库密码、密钥）用于测试 / 生产环境，避免数据泄露风险。

* 本地开发环境的中间件（MySQL/Redis）建议使用独立账号，与生产环境账号权限区分。