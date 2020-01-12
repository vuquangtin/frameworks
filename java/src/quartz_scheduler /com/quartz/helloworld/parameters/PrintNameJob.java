package com.quartz.helloworld.parameters;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class PrintNameJob implements Job {
	public static final String NAME = "name";
	public static final String COUNT = "count";
	private String flag = "new object";

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		// fetch parameters from JobDataMap
		String name = dataMap.getString(NAME);
		int count = dataMap.getInt(COUNT);
		JobKey jobKey = context.getJobDetail().getKey();
		System.out.println(jobKey + ": " + name + "-" + count + ": flag=" + flag);
		count++;
		// add next counter to JobDataMap
		dataMap.put(COUNT, count);
		flag = "object changed";
	}
}
