package com.quartz.helloworld;

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
public class HelloJob2 implements Job
{
	public void execute(JobExecutionContext context)
	throws JobExecutionException {
		
		System.out.println("Hello Quartz! 123");	
		
		//Throw exception for testing
		throw new JobExecutionException("Testing Exception");
	}
	
}
