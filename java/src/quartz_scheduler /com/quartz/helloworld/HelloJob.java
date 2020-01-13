package com.quartz.helloworld;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 * @see https://mkyong.com/java/quartz-2-scheduler-tutorial/
 *
 */
public class HelloJob implements Job {
	// public HelloJob(boolean throwable) {
	//
	// }
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		boolean throwable = dataMap.getBoolean("throwable");
		System.out.println("Hello Quartz!");
		System.out.println("throwable:" + throwable);
	}

}