package com.quartz.helloworld;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class CronSchedule {

	public static void main(String[] args) throws SchedulerException {
		JobDetail job = JobBuilder.newJob(SimpleJob.class)
				.withIdentity("SimpleJob").build();
		// "0 0 12 * * ?" Fire at 12pm (noon) every day
		// "0/2 * * * * ?" Fire at every 2 seconds every day
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("SimpleJob")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
				.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}
}