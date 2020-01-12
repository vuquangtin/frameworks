package com.quartz.smssendmt.model;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class TblSMSQueueHome extends GenericHibernateDAO<TblSMSQueue, Long> {

	/**
	 * log tool.
	 */
	private static Logger log = Logger.getLogger(HibernateUtils.class);

	public static List<TblSMSQueue> getListSMS() {

		try {
			TblSMSQueueHome home = new TblSMSQueueHome();
			Criterion criterion = Restrictions.eq("status", 0);
			return home.findByCriteria(criterion);

			// return home.findAll();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public static void update(List<TblSMSQueue> obj) {
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			for (int i = 0; i < obj.size(); i++) {
				session.saveOrUpdate(obj.get(i));
			}
			session.flush();
			transaction.commit();
		} catch (RuntimeException re) {
			transaction.rollback();
			throw re;
		}
	}

}