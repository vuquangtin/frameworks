package com.quartz.helloworld;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
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
public class SimpleTriggerExample {
	public static void main(String[] args) throws Exception {

		// Quartz 1.6.3
		// JobDetail job = new JobDetail();
		// job.setName("dummyJobName");
		// job.setJobClass(HelloJob.class);

		JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("dummyJobName", "group1").build();

		// Quartz 1.6.3
		// SimpleTrigger trigger = new SimpleTrigger();
		// trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
		// trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		// trigger.setRepeatInterval(30000);

		// Trigger the job to run on the next round minute
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();

		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}
}
