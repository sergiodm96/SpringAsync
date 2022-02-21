package com.sergio.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ConfigurationAsync {

	
	@Bean(name = "asyncExecutor")
	public Executor asyncExecutor() {
	
		ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
		
		//Minimum of threads you'll use in this application.
		executor.setCorePoolSize(3);
		
		//Maximum of threads that are going to be created when all of CorePool are already in use.
		executor.setMaxPoolSize(5);
		
		//Maximum of thread that can be created but they're waiting to be activated.
		executor.setQueueCapacity(0);
		
		//You can name that service.
		executor.setThreadNamePrefix("AsyncThread-");
		
		executor.initialize();
		
		return executor;
	}
	
}
