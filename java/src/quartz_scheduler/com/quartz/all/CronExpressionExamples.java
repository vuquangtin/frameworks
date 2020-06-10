package com.quartz.all;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.java.frameworks.base.ExtendTemplateMethod;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class CronExpressionExamples extends ExtendTemplateMethod {
	public static void main(String[] args) {
		new CronExpressionExamples().runTemplateMethod(args);
		logger.debug("runTemplateMethod");
	}

	public class SimpleEleven implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	/***
	 * Let us see some examples of cron expression by using the fields and
	 * specials characters combinations:
	 * 
	 * At 12:00 pm (noon) every day during the year 2020:
	 * 
	 * 0 0 12 * * ? 2020
	 */
	@Override
	public void implementionEleven(String[] args) throws Exception {
		JobDetail job = JobBuilder.newJob(SimpleEleven.class)
				.withIdentity("SimpleEleven").build();
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("SimpleEleven")
				.withSchedule(
						CronScheduleBuilder.cronSchedule("0 0 12 * * ? 2020"))
				.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

	public class SimpleTwelve implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	/***
	 * Every 5 minutes starting at 1 pm and ending on 1:55 pm and then starting
	 * at 6 pm and ending at 6:55 pm, every day:
	 * 
	 * 0 0/5 13,18 * * ?
	 */
	@Override
	public void implementionTwelve(String[] args) throws Exception {
		JobDetail job = JobBuilder.newJob(SimpleTwelve.class)
				.withIdentity("SimpleTwelve").build();
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("SimpleTwelve")
				.withSchedule(
						CronScheduleBuilder.cronSchedule("0 0/5 13,18 * * ?"))
				.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

	public class SimpleThirteen implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	/***
	 * Every minute starting at 1 pm and ending on 1:05 pm, every day:
	 * 
	 * 0 0-5 13 * * ?
	 */
	@Override
	public void implementionThirteen(String[] args) throws Exception {
		JobDetail job = JobBuilder.newJob(SimpleThirteen.class)
				.withIdentity("SimpleThirteen").build();
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("SimpleThirteen")
				.withSchedule(
						CronScheduleBuilder.cronSchedule("0 0-5 13 * * ?"))
				.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

	public class SimpleFourteen implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	/***
	 * At 1:15 pm and 1:45 pm every Tuesday in the month of June:
	 * 
	 * 0 15,45 13 ? 6 Tue
	 */
	@Override
	public void implementionFourteen(String[] args) throws Exception {
		JobDetail job = JobBuilder.newJob(SimpleFourteen.class)
				.withIdentity("SimpleFourteen").build();
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("SimpleFourteen")
				.withSchedule(
						CronScheduleBuilder.cronSchedule("0 15,45 13 ? 6 Tue"))
				.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

	public class SimpleFifteen implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	/***
	 * At 9:30 am every Monday, Tuesday, Wednesday, Thursday, and Friday:
	 * 
	 * 0 30 9 ? * MON-FRI
	 */
	@Override
	public void implementionFifteen(String[] args) throws Exception {
		JobDetail job = JobBuilder.newJob(SimpleFifteen.class)
				.withIdentity("SimpleFifteen").build();
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("SimpleFifteen")
				.withSchedule(
						CronScheduleBuilder.cronSchedule("0 30 9 ? * MON-FRI"))
				.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

	public class SimpleSixteen implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	/***
	 * At 9:30 am on 15th day of every month:
	 * 
	 * 0 30 9 15 * ?
	 */
	@Override
	public void implementionSixteen(String[] args) throws Exception {
		JobDetail job = JobBuilder.newJob(SimpleSixteen.class)
				.withIdentity("SimpleSixteen").build();
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("SimpleSixteen")
				.withSchedule(CronScheduleBuilder.cronSchedule("0 30 9 15 * ?"))
				.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

	public class SimpleSeventeen implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	/***
	 * At 6 pm on the last day of every month:
	 * 
	 * 0 0 18 L * ?
	 */
	@Override
	public void implementionSeventeen(String[] args) throws Exception {
		JobDetail job = JobBuilder.newJob(SimpleSeventeen.class)
				.withIdentity("SimpleSeventeen").build();
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("SimpleSeventeen")
				.withSchedule(CronScheduleBuilder.cronSchedule("0 0 18 L * ?"))
				.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}

	public class SimpleEighteen implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	/***
	 * At 6 pm on the 3rd to last day of every month:
	 * 
	 * 0 0 18 L-3 * ?
	 */
	@Override
	public void implementionEighteen(String[] args) throws Exception {
		JobDetail job = JobBuilder.newJob(SimpleEighteen.class)
				.withIdentity("SimpleEighteen").build();
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("SimpleEighteen")
				.withSchedule(
						CronScheduleBuilder.cronSchedule("0 0 18 L-3 * ?"))
				.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

	public class SimpleNineteen implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	/***
	 * At 10:30 am on the last Thursday of every month:
	 * 
	 * 0 30 10 ? * 5L
	 */
	@Override
	public void implementionNineteen(String[] args) throws Exception {
		String name = "SimpleNineteen";
		JobDetail job = JobBuilder.newJob(SimpleNineteen.class)
				.withIdentity(name).build();
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity(name)
				.withSchedule(
						CronScheduleBuilder.cronSchedule("0 30 10 ? * 5L"))
				.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

	public class SimpleTwenty implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	/***
	 * At 6 pm on the last Friday of every month during the years 2015, 2016 and
	 * 2017..2022:
	 * 
	 * 0 0 18 ? * 6L 2015-2022
	 */
	@Override
	public void implementionTwenty(String[] args) throws Exception {
		String name = "SimpleTwenty";
		JobDetail job = JobBuilder.newJob(SimpleTwenty.class)
				.withIdentity(name).build();
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity(name)
				.withSchedule(
						CronScheduleBuilder
								.cronSchedule("0 0 18 ? * 6L 2015-2022"))
				.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

	public class SimpleOne implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	/***
	 * At 10 am on the third Monday of every month:
	 * 
	 * 0 0 10 ? * 2#3
	 */
	@Override
	public void implementionOne(String[] args) throws Exception {
		String name = "SimpleOne";
		JobDetail job = JobBuilder.newJob(SimpleOne.class).withIdentity(name)
				.build();
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity(name)
				.withSchedule(
						CronScheduleBuilder.cronSchedule("0 0 10 ? * 2#3"))
				.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

	public class SimpleTwo implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	/***
	 * At 12 am midnight on every day for five days starting on the 10th day of
	 * the month:
	 * 
	 * 0 0 0 10/5 * ?
	 */
	@Override
	public void implementionTwo(String[] args) throws Exception {
		String name = "SimpleTwo";
		JobDetail job = JobBuilder.newJob(SimpleTwo.class).withIdentity(name)
				.build();
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity(name)
				.withSchedule(
						CronScheduleBuilder.cronSchedule("0 0 0 10/5 * ?"))
				.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

	public class SimpleThree implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		String name = "implementionThree";

		JobDetail job = JobBuilder.newJob(SimpleTwo.class).withIdentity(name)
				.build();
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity(name)
				.withSchedule(
						CronScheduleBuilder.cronSchedule("0 0 0 10/5 * ?"))
				.build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

	public class SimpleFour implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	public class SimpleFive implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	public class SimpleSix implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	public class SimpleSeven implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	public class SimpleEight implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	public class SimpleNine implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	public class SimpleTen implements Job {

		public void execute(JobExecutionContext jec)
				throws JobExecutionException {
			System.out.println("doing simple job.");
		}
	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}
}
