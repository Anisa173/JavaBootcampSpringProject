package com.project.demo.sushiCo.configuration;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;

@Component
public class ScheduledTask {
	@Scheduled(fixedRate = 6000)
	public void reportCurrentTime() {
		System.out.println("The next task's start will be after 3 seconds");
	}

	@Scheduled(fixedDelay = 2000, initialDelay = 8000)
	public void performTaskWithInitialDelay() {
		System.out.println("Task's delay should be 2 sek ");
	}

	@Scheduled(cron = " 0 30 11-23 ** TUE-SUN ")
	public void performDaylyTask() {
		System.out.println("The tasks will be executed from 11:30 until 23:30 everyday TUESDAY-SUNDAY!");
	}

	@Scheduled(cron = "0 0/15 * * * ?")
	@SchedulerLock(name = "TaskScheduler_scheduledTask", lockAtLeastFor = "PT5M", lockAtMostFor = "PT14M")
	public void scheduledTask() {
		System.out.println("Running ShedLock task");
	}
}
