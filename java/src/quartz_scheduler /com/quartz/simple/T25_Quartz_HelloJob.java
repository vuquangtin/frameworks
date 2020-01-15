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

public class T25_Quartz_HelloJob implements Job {

	// private static Logger _log =
	// LoggerFactory.getLogger(T25_Quartz_HelloJob.class);

	public T25_Quartz_HelloJob() {
	}

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		// _log.info("Hello World! - " + new Date());
		System.out.println("---------start----------");
		System.out.println("Hello world!" + new Date());
		System.out.println("---------end----------");
	}

}