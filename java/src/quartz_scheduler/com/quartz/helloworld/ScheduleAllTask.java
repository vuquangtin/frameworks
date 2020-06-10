package com.quartz.helloworld;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
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
public class ScheduleAllTask {
	private static final String LIKE_TASK_IDENTITY = "LikeTaskQuartz";
	private static final String ACTIVITY_TASK_IDENTITY = "ActivityTaskQuartz";
	private static final String CREDIT_TASK_IDENTITY = "CreditTaskQuartz";
	private static final String EXPIRE_APPLY_TASK_IDENTITY = "ExpireApplyTaskQuartz";

	public static void main(String[] args) throws SchedulerException {
		JobKey feedWSClient = new JobKey("myNewJob", "myJobGroup");
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
				.withIdentity("job1").storeDurably().build();
		// every 2 hours
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
				.cronSchedule("0 0 */2 ? * *");
		//Date startTime1 = DateBuilder.evenHourDateAfterNow();
		// start every 5 min (used for test)
		//"0/2 * * * * ?" Fire at every 2 seconds every day
		// CronScheduleBuilder scheduleBuilder =
		// CronScheduleBuilder.cronSchedule("0 */2 * ? * *");
		//2h "0 0 */2 ? * *"
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("SimpleJob")
				.startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule("0/12 * * * * ?"))
				.build();
		CronTrigger cronTrigger = TriggerBuilder.newTrigger()
				.withIdentity(LIKE_TASK_IDENTITY).withSchedule(scheduleBuilder)
				.build();
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
		// Register this job to the scheduler
		// scheduler.addJob(jobDetail, true);
		// scheduler.triggerJob(feedWSClient);

	}
}
