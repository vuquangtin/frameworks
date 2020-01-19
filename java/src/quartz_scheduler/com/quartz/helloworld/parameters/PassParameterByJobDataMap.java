package com.quartz.helloworld.parameters;

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
 * JobDataMap org.quartz.JobDataMap is used to put and get values for a job
 * instance. If the job is annotated with @PersistJobDataAfterExecution, then
 * after job execution job states are re-persisted. JobDataMap is used to pass
 * parameters to scheduled job. Using JobDetail instance we get the instance of
 * JobDataMap and then add the values which needs to pass to scheduled job.
 * JobDataMap jobDataMap= jobDetail.getJobDataMap()
 * jobDataMap.put(PrintNameJob.NAME, "RAM"); Within a job, to access the
 * JobDataMap values, we can do as follows. JobDataMap dataMap =
 * context.getJobDetail().getJobDataMap(); String name =
 * dataMap.getString(NAME); Get the JobDetail instance by JobExecutionContext
 * and get the instance of JobDataMap using JobDetail instance.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class PassParameterByJobDataMap {
	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		// create first JobDetail and Trigger
		JobDetail jobDetail = JobBuilder.newJob(PrintNameJob.class).withIdentity("ramjob", "ourgroup").build();
		SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("ramtrigger", "ourgroup")
				.startAt(new Date(Calendar.getInstance().getTimeInMillis() + 5000))
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(3))
				.build();
		// add passing parameters to JobDataMap for first JobDetail
		jobDetail.getJobDataMap().put(PrintNameJob.NAME, "RAM");
		jobDetail.getJobDataMap().put(PrintNameJob.COUNT, 11);
		scheduler.scheduleJob(jobDetail, trigger);
		// create second JobDetail and Trigger
		jobDetail = JobBuilder.newJob(PrintNameJob.class).withIdentity("rahimjob", "ourgroup").build();
		trigger = TriggerBuilder.newTrigger().withIdentity("rahimtrigger", "ourgroup")
				.startAt(new Date(Calendar.getInstance().getTimeInMillis() + 5000))
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(3))
				.build();
		// add passing parameters to JobDataMap for second JobDetail
		jobDetail.getJobDataMap().put(PrintNameJob.NAME, "RAHIM");
		jobDetail.getJobDataMap().put(PrintNameJob.COUNT, 21);
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
		try {
			// wait for 30 seconds to finish the job
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// shutdown scheduler gracefully
		scheduler.shutdown(true);
	}
}