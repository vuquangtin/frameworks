package com.quartz.smssendmt.service;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
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
public class Main {

	public static void main(String[] args) throws Exception {
		JobDetail job = JobBuilder.newJob(SendSMSJob.class).withIdentity("SendSms", "SendSms").build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("SendSms", "SendSms")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();

		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

}
