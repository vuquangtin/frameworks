package com.quartz.helloworld;

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
public class SimpleJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("doing simple job.");
		try {
			JobKey key = context.getJobDetail().getKey();

			JobDataMap dataMap = context.getJobDetail().getJobDataMap();

			String jobSays = dataMap.getString("jobSays");
			float myFloatValue = dataMap.getFloat("myFloatValue");
			System.out.println("Instance " + key + " of DumbJob says: "
					+ jobSays + ", and val is: " + myFloatValue);
			System.err.println("Instance " + key + " of DumbJob says: "
					+ jobSays + ", and val is: " + myFloatValue);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}