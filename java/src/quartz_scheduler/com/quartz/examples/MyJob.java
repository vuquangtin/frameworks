package com.quartz.examples;

import org.quartz.Job;
import org.quartz.JobDetail;
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
public class MyJob implements Job {
	private static int count;

	public void execute(JobExecutionContext jobContext)
			throws JobExecutionException {
		System.out
				.println("--------------------------------------------------------------------");
		System.out.println("MyJob start: " + jobContext.getFireTime());
		JobDetail jobDetail = jobContext.getJobDetail();
		System.out.println("Example name is: "
				+ jobDetail.getJobDataMap().getString("example"));
		System.out.println("MyJob end: " + jobContext.getJobRunTime()
				+ ", key: " + jobDetail.getKey());
		System.out.println("MyJob next scheduled time: "
				+ jobContext.getNextFireTime());
		System.out
				.println("--------------------------------------------------------------------");

		ILatch latch = (ILatch) jobDetail.getJobDataMap().get("latch");
		latch.countDown();
		count++;
		System.out.println("Job count " + count);
		if (count == 2) {
			throw new RuntimeException("Some RuntimeException!");
		}
		if (count == 4) {
			throw new JobExecutionException("Some JobExecutionException!");
		}
	}

}