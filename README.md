# Pedestal
A Pre-research platform for learning java basics.

## 目录结构
```
Pedestal
├─pedestal-core    -- 核心依赖层
│   ├─anc-common-model     -- 通用模型层
│   ├─anc-common-util     -- 工具层
│   ├─anc-framework-cache     -- 缓存框架层
│   ├─anc-framework-config-center     -- 注册中心层
│   ├─anc-framework-discovery     -- 发现中心层
│   ├─anc-framework-fegin     -- fegin 调度中心层
│   ├─anc-framework-logger     -- 日志层
│   ├─anc-framework-mongodb     -- mongodb 层
│   ├─anc-framework-mq     -- mq 消息层
│   ├─anc-framework-mybatis     -- mybatis 层
│   ├─anc-framework-springboot     -- springboot 层
│   ├─anc-framework-springboot-web     -- web 层
│   ├─anc-framework-swagger     -- 在线文档层
│   ├─anc-framework-validation     -- 参数校验层
│   ├─anc-parent     -- 全局包依赖管理
├─pedestal-infrastructure      -- 基础设施层
│   ├─pedestal-api-gateway     -- 网关
│   ├─pedestal-config-center     -- 配置中心
│   ├─pedestal-discovery     -- 发现中心
│   ├─pedestal-inf-jobs-scheduler     -- 任务调度中心
│   ├─pedestal-inf-oss     -- 对象存储中心
│   ├─pedestal-inf-push-center     -- 推送中心
│   ├─pedestal-inf-report-center     -- 上报中心
│   ├─pedestal-tracing     -- 链路追踪
├─pedestal-micro-service    -- 微服务模块
│   ├─pedestal-ms-demo    -- 示例服务
│   ├─pedestal-ms-alogrithm    -- 算法
│   ├─pedestal-ms-crawler   -- 爬虫服务
│   ├─pedestal-ms-patterns   -- 常用设计模式
├─pedestal-share    -- 共享模块
│   ├─share-api     -- 共享 api
│   ├─share-component   -- 共享组件
├─pedestal-tool     --工具模块
│   ├─pedestal-tool-orm-generator   -- mbp 生成工具
├─resource      -- 资源模块
└─docs      -- 文档模块
```

## 开发环境
- [x] Java 开发工具包 1.8+
- [x] IDE（Eclipse或IntelliJ IDEA）
- [x] 项目管理工具 Maven
- [x] 微服务注册中心/配置中心 Nacos
- [x] 分布式缓存服务 Redis
- [x] 消息中间件 RocketMq
- [x] 数据库服务 Mysql
- [x] 链路追踪工具 Zipkin
- [x] 搜索引擎服务 ElasticSearch

## 规约
**开发规范** 和 **分支管理约定** 见内部文档
[git-flow介绍](https://www.git-tower.com/learn/git/ebook/cn/command-line/advanced-topics/git-flow/)
[gitflow分支说明](http://www.ruanyifeng.com/blog/2012/07/git.html)
[gitflow分支总结](https://juejin.cn/post/6844903634006720526)