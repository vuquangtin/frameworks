package com.quartz.helloworld;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class CronTriggerExample2 {
	public static void main(String[] args) throws Exception {

		JobKey jobKey = new JobKey("dummyJobName", "group1");
		JobDetail job = JobBuilder.newJob(HelloJob2.class).withIdentity(jobKey).build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();

		// Listener attached to jobKey
		scheduler.getListenerManager().addJobListener(new HelloJobListener(), KeyMatcher.keyEquals(jobKey));

		// Listener attached to group named "group 1" only.
		// scheduler.getListenerManager().addJobListener(
		// new HelloJobListener(), GroupMatcher.jobGroupEquals("group1")
		// );

		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}
}
