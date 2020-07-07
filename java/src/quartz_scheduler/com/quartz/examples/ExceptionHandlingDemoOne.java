package com.quartz.examples;

import java.util.Calendar;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
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
public class ExceptionHandlingDemoOne {
	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		JobDetail jobDetail = JobBuilder.newJob(MyJobOne.class)
				.withIdentity("job1", "mygroup").build();
		SimpleTrigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("trigger1", "mygroup")
				.startAt(
						new Date(
								Calendar.getInstance().getTimeInMillis() + 2000))
				.withSchedule(
						SimpleScheduleBuilder.simpleSchedule()
								.withIntervalInSeconds(2).withRepeatCount(2))
				.build();
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
		try {
			// wait for 10 seconds to finish the job
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		scheduler.shutdown(true);
	}
}