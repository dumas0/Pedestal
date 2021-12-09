package com.dumas.pedestal.framework.springboot.web.apicontrol;

import com.dumas.pedestal.framework.springboot.web.apicontrol.annotation.ApiVersion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * API版本映射
 *
 * @author andaren
 * @version V1.0
 * @since 2020-05-12 16:56
 */
@Slf4j
public class ApiVersioningRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    public ApiVersioningRequestMappingHandlerMapping() {
        log.info("ApiVersioningRequestMappingHandlerMapping Init...");
    }

    @Override
    protected RequestCondition<ApiVersionCondition> getCustomTypeCondition(Class<?> handlerType) {

        ApiVersion apiVersion = AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);
        return createCondition(apiVersion);
    }

    @Override
    protected RequestCondition<ApiVersionCondition> getCustomMethodCondition(Method method) {
        ApiVersion apiVersion = AnnotationUtils.findAnnotation(method, ApiVersion.class);
        return createCondition(apiVersion);
    }

    private RequestCondition<ApiVersionCondition> createCondition(ApiVersion apiVersion) {
        return apiVersion == null ? null : new ApiVersionCondition(apiVersion.value());
    }
}
