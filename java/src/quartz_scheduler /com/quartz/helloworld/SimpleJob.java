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
public class SimpleJob implements Job {

	public void execute(JobExecutionContext jec) throws JobExecutionException {
		System.out.println("doing simple job.");
	}
}