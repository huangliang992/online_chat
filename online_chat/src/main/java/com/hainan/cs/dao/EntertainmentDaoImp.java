package com.hainan.cs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hainan.cs.bean.EntertainmentRecord;

public class EntertainmentDaoImp implements EntertainmentDao{
	SessionFactory sessionfactory;
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	@Override
	public void insert(EntertainmentRecord er){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(er);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public List<EntertainmentRecord> query(){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from EntertainmentRecord er";
		Query query=session.createQuery(str);
		List<EntertainmentRecord> elist=query.list();
		session.close();
		return elist;
	}
}
