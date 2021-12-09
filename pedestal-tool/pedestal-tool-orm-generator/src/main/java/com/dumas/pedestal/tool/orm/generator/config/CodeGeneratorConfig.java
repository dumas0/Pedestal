package com.dumas.pedestal.tool.orm.generator.config;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
 * <p>
 * 约定：
 * 1. 数据库实体  以 DO 为后缀，且 包名为 entity
 * 2. 数据查询   以 DAO 为后缀, 且包名为 mapper
 *
 * @author az.ye
 */
public class CodeGeneratorConfig {
    /**
     * 数据库配置
     *
     * @return
     */
    public static DataSourceConfig configDB() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://27.0.0.1:3306/user?autoRconnect=true&useUnicode=true&characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowMultiQueries=true");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        return dsc;
    }

    /**
     * 生成的文件父包名
     * 如：
     * com.dumas.pedestal.ms.logical.orm.{模块名}.entity
     * com.dumas.pedestal.ms.logical.orm.{模块名}.mapper
     * com.dumas.pedestal.ms.logical.orm.{模块名}.service
     *
     * @return
     */
    public static String ormPacName() {
        return "com.dumas.pedestal.ms.usercenter.orm"; // 用户中心
    }

    /**
     * 使用方法
     * 1. 配置数据库
     *
     * @param args
     * @see com.dumas.pedestal.tool.orm.generator.config.CodeGeneratorConfig#configDB()
     * 2. 修改生成文件包名
     * @see com.dumas.pedestal.tool.orm.generator.config.CodeGeneratorConfig#ormPacName()
     * 3. 按照提示输入
     * 3.1 先输入模块名称，如： user
     * 3.2 如果生成多张表的，表明之间用英文逗号间隔, 如：user,user_role,user_ref_xxx
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        String projectPath = System.getProperty("user.dir") + "/cg-tool/cg-tool-orm-generator";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("dumasz.github.io");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解

        /**
         * https://baomidou.com/config/generator-config.html#entityname
         * 实体或者DAO类名命名规则配置
         */
        gc.setEntityName("%sDO");
        gc.setMapperName("%sDAO");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = configDB();
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        // 父包名
        pc.setParent(ormPacName());
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/" + tripDOName(tableInfo.getEntityName()) + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //            strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        //            strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        /**
         * 是否去除表前缀
         */
//        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 生成Mapper.xml文件时过滤DO后缀
     *
     * @param entityName
     * @return
     */
    private static String tripDOName(String entityName) {
        return entityName.split("DO")[0];
    }

}
