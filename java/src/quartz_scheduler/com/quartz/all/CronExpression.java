package com.quartz.all;

/**
 * <h1>Cron Expression</h1>
 * 
 * Let's understand the cron expression; it consists of six fields:<br/>
 * <i>
 * 
 * second minute hour day-of-month month day-of-week year command </i> <br/>
 * From these, <year> field is optional.
 * 
 * <h2>Specials Characters in Expression</h2>
 * <ul>
 * <li>
 * (all) – it is used to specify that event should happen for every time unit.
 * For example, “*” in the <minute> field – means “for every minute”</li>
 * <li>? (any) – it is utilized in the <day-of-month> and <day-of -week> fields
 * to denote the arbitrary value – neglect the field value. For example, if we
 * want to fire a script at “5th of every month” irrespective of what the day of
 * the week falls on that date, then we specify a “?” in the <day-of-week> field
 * </li>
 * <li>– (range) – it is used to determine the value range. For example, “10-11”
 * in <hour> field means “10th and 11th hours”</li>
 * <li>, (values) – it is used to specify multiple values. For example, “MON,
 * WED, FRI” in <day-of-week> field means on the days “Monday, Wednesday, and
 * Friday”</li>
 * <li>/ (increments) – it is used to specify the incremental values. For
 * example, a “5/15” in the <minute> field, means at “5, 20, 35 and 50 minutes
 * of an hour”</li>
 * <li>L (last) – it has different meanings when used in various fields. For
 * example, if it's applied in the <day-of-month> field, then it means last day
 * of the month, i.e. “31st for January” and so on as per the calendar month. It
 * can be used with an offset value, like “L-3“, which denotes the “third to
 * last day of the calendar month”. In the <day-of-week>, it specifies the “last
 * day of a week”. It can also be used with another value in <day-of-week>, like
 * “6L“, which denotes the “last Friday”</li>
 * <li>W (weekday) – it is used to specify the weekday (Monday to Friday)
 * nearest to a given day of the month. For example, if we specify “10W” in the
 * <day-of-month> field, then it means the “weekday near to 10th of that month”.
 * So if “10th” is a Saturday, then the job will be triggered on “9th”, and if
 * “10th” is a Sunday, then it will trigger on “11th”. If you specify “1W” in
 * the <day-of-month> and if “1st” is Saturday, then the job will be triggered
 * on “3rd” which is Monday, and it will not jump back to the previous month</li>
 * <li># – it is used to specify the “N-th” occurrence of a weekday of the
 * month, for example, “3rd Friday of the month” can be indicated as “6#3“</li>
 * </ul>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class CronExpression {

}
