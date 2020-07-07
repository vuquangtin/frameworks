package com.quartz.examples;
import org.quartz.Job;
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
public class MyJobOne implements Job {
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		JobKey jobKey = context.getJobDetail().getKey();
		try {
			// divide by zero
			int res = 10 / 0;
		} catch (ArithmeticException ex) {
			System.out.println(jobKey + ": error occured.");
			JobExecutionException jee = new JobExecutionException(ex);
			// jee.setRefireImmediately(false);
			jee.refireImmediately();
			throw jee;
		}
	}
}