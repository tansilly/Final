package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.RateDomainModel;
import domain.StudentDomainModel;
import util.HibernateUtil;

public class RateDAL {


	public static double getRate(int GivenCreditScore) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		int employeeID = 0;
		try {
			tx = session.beginTransaction();
			session.save(GivenCreditScore);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return GivenCreditScore;
     }

	public static ArrayList<RateDomainModel> getRates() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		RateDomainModel rateGet = null;		
		ArrayList<RateDomainModel> rates = new ArrayList<RateDomainModel>();
		
		try {
			tx = session.beginTransaction();	
			
			List Rates = session.createQuery("FROM RateDomainModel").list();
			for (Iterator iterator = Rates.iterator(); iterator.hasNext();) {
				RateDomainModel rate = (RateDomainModel) iterator.next();
				rates.add(rate);

			}
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rates;
	}	
	
	public static RateDomainModel getRate(UUID rateID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		RateDomainModel rateGet = null;		
		
		try {
			tx = session.beginTransaction();	
									
			Query query = session.createQuery("from RateDomainModel where RateId = :id ");
			query.setParameter("id", rateID.toString());
			
			List<?> list = query.list();
			rateGet = (RateDomainModel)list.get(0);
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rateGet;
	}	
	
	public static void deleteRate(UUID rateID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		RateDomainModel rateGet = null;		
		
		try {
			tx = session.beginTransaction();	
									
			RateDomainModel rate = (RateDomainModel) session.get(RateDomainModel.class, rateID);
			session.delete(rate);
		
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}	
	
	public static RateDomainModel updateRate(RateDomainModel rate) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		RateDomainModel rateGet = null;		
		
		try {
			tx = session.beginTransaction();	
									
			session.update(rate);
	
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return rate;
	}	


}