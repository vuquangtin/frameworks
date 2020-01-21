package com.quartz.simple;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class SimpleQuartzJob implements Job {

	public SimpleQuartzJob() {
	}

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("In SimpleQuartzJob - executing its JOB at "
				+ new Date() + " by "
				+ context.getTrigger().getJobKey().getName());
	}
}