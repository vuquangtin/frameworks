package com.quartz.all;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.java.frameworks.base.TemplateMethod;
import com.quartz.helloworld.DumbJob;
import com.quartz.helloworld.SimpleJob;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class JobDataMapExample extends TemplateMethod {

	public static void main(String[] args) {
		new JobDataMapExample().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		String name = "SimpleTwo";
		System.out.println("SimpleTwo");
		// define the job and tie it to our DumbJob class
		JobDetail job = JobBuilder.newJob(DumbJob.class)
				.withIdentity("myJob", "group1")
				// name "myJob", group "group1"
				.usingJobData("jobSays", "Hello World!")
				.usingJobData("myFloatValue", 3.141f).build();
		// 0 0/1 * 1/1 * ? *
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity(name)
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
				.build();
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		logger.debug("implementionTwo");

	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

}
