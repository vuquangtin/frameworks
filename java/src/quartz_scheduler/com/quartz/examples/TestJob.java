package com.quartz.examples;

import org.apache.log4j.Logger;
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
public class TestJob implements Job {

	private Logger log = Logger.getLogger(TestJob.class);

	@Override
	public void execute(JobExecutionContext jExeCtx)
			throws JobExecutionException {
		log.debug("TestJob run successfully...");
	}

}