package com.github.welblade.labpicpayclonebackendapi

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@Configuration
@EnableAsync
class ExecucaoAssincronaConfiguracao {
    @Bean(name = ["asyncExecutor"])
    fun getAsyncExecutor(): Executor {
        return ThreadPoolTaskExecutor().apply {
            corePoolSize = 3
            maxPoolSize = 3
            setQueueCapacity(100)
            setThreadNamePrefix("AsyncThread-")
            initialize()
        }
    }
}