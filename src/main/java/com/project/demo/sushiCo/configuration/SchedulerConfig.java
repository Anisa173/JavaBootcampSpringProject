package com.project.demo.sushiCo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

public class SchedulerConfig implements SchedulingConfigurer {
@Value("${scheduler.thread.pool.size}")
private Integer SCHEDULER_THREAD_POOL;
/**Configures the scheduler to allow multiply pools.	
*@param scheduledTaskRegistrar */


@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
	ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
	threadPoolTaskScheduler.setPoolSize(SCHEDULER_THREAD_POOL);	
	threadPoolTaskScheduler.setThreadNamePrefix("scheduled-task-pool-");
	threadPoolTaskScheduler.initialize();
	taskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
	}






}
