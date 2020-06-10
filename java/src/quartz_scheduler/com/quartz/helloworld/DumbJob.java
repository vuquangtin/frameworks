package com.quartz.helloworld;

import org.apache.log4j.Logger;
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
public class DumbJob implements Job {
	protected static Logger logger = Logger.getLogger(DumbJob.class.getName());

	public DumbJob() {
	}

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		logger.debug("DumbJob .");
		try {
			JobKey key = context.getJobDetail().getKey();

			JobDataMap dataMap = context.getJobDetail().getJobDataMap();

			String jobSays = dataMap.getString("jobSays");
			float myFloatValue = dataMap.getFloat("myFloatValue");
			logger.debug("Instance " + key + " of DumbJob says: " + jobSays
					+ ", and val is: " + myFloatValue);
			logger.debug("Instance " + key + " of DumbJob says: " + jobSays
					+ ", and val is: " + myFloatValue);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}