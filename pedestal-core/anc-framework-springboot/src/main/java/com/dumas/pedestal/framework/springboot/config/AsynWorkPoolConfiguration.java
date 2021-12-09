package com.dumas.pedestal.framework.springboot.config;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * 异步任务线程池配置
 *
 * @author andaren
 * @version V1.0
 * @since 2019-08-19 18:45
 */
@Configuration
public class AsynWorkPoolConfiguration {

    @Bean(name = "asynWorkExecutorService")
    @ConditionalOnMissingBean(name = "asynWorkExecutorService")
    public ExecutorService asynWorkExecutorService() {
        ExecutorService executorService = new ThreadPoolExecutor(
                3,
                20,
                4,
                TimeUnit.SECONDS,
                linkedBlockingQueue(),
                terzillaAsynWorkThreadFactory()
        );

        return executorService;
    }

    private LinkedBlockingQueue linkedBlockingQueue() {
        return new LinkedBlockingQueue<>();
    }

    private ThreadFactory terzillaAsynWorkThreadFactory() {
        return new BasicThreadFactory.Builder()
                .namingPattern("pool-pedestal-asyn-worker-thread")
                .daemon(false)
                .priority(Thread.NORM_PRIORITY)
                .build();
    }

}
