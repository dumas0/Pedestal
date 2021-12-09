package com.dumas.pedestal.framework.springboot.web.config;

import com.dumas.pedestal.framework.springboot.web.apicontrol.ApiVersioningRequestMappingHandlerMapping;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * TODO
 *
 * @author andaren
 * @version V1.0
 * @since 2020-05-12 16:59
 */
@Configuration
public class WebMvcRegistrationsConfig implements WebMvcRegistrations {
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {

        return new ApiVersioningRequestMappingHandlerMapping();
    }
}
