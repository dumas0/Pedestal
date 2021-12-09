package com.dumas.pedestal.tool.orm.generator.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Mybatis plus配置
 *
 * @author andaren
 * @version V1.0
 * @since 2021-01-06 16:40
 */
@Component
@Configuration
public class MybatisPlusConfiguraton {
    @Bean
    public PaginationInnerInterceptor paginationInterceptor() {
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
//         paginationInterceptor.setLimit(500);
        return paginationInterceptor;
    }

}
