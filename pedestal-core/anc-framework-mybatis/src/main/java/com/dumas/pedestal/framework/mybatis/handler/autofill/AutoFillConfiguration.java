package com.dumas.pedestal.framework.mybatis.handler.autofill;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动填充配置
 *
 * @author az.ye
 * @version V1.0
 * @since 2021-06-21 22:39
 */
@Configuration
public class AutoFillConfiguration {

    @Bean
    @ConditionalOnMissingBean(IFillUsernameHandler.class)
    public IFillUsernameHandler iFillUsernameHandler() {
        return new DefaultFillUsernameHandler();
    }

    @Bean
    @ConditionalOnMissingBean(MetaObjectHandler.class)
    public MetaObjectHandler metaObjectHandler() {
        return new AutoFillHandler();
    }
}
