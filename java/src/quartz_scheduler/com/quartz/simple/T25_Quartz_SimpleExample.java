package com.quartz.simple;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class T25_Quartz_SimpleExample {

	public void run() throws Exception {
		Logger log = LoggerFactory.getLogger(T25_Quartz_SimpleExample.class);

		log.info("------- Initializing ----------------------");

		// First we must get a reference to a scheduler
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		log.info("------- Initialization Complete -----------");

		// computer a time that is on the next round minute
		Date runTime = evenMinuteDate(new Date());

		log.info("------- Scheduling Job  -------------------");

		// define the job and tie it to our HelloJob class
		JobDetail job = newJob(T25_Quartz_HelloJob.class).withIdentity("job1",
				"group1").build();

		// Trigger the job to run on the next round minute
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
				.startAt(runTime).build();

		// Tell quartz to schedule the job using our trigger
		sched.scheduleJob(job, trigger);
		log.info(job.getKey() + " will run at: " + runTime);

		// Start up the scheduler (nothing can actually run until the
		// scheduler has been started)
		sched.start();

		log.info("------- Started Scheduler -----------------");

		// wait long enough so that the scheduler as an opportunity to
		// run the job!
		log.info("------- Waiting 65 seconds... -------------");
		try {
			// wait 65 seconds to show job
			Thread.sleep(65L * 1000L);
			// executing...
		} catch (Exception e) {
			//
		}

		// shut down the scheduler
		log.info("------- Shutting Down ---------------------");
		sched.shutdown(true);
		log.info("------- Shutdown Complete -----------------");
	}

	public static void main(String[] args) throws Exception {

		T25_Quartz_SimpleExample example = new T25_Quartz_SimpleExample();
		example.run();

	}

}