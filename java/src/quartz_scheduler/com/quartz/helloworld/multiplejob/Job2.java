package com.quartz.helloworld.multiplejob;

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
public class Job2 implements Job{
	public void execute(JobExecutionContext context)
			throws JobExecutionException {	 
		System.out.println("Job2 is running.");		 
	}
}

