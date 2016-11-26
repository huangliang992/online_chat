package com.hainan.cs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hainan.cs.bean.EducationRecord;

public class EducationDaoImp implements EducationDao{
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	@Override
	public void isnert(EducationRecord er){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(er);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public List<EducationRecord> queryEducationRecord(){
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String str="from EducationRecord er";
		Query query=session.createQuery(str);
		List<EducationRecord> elist=query.list();
		session.close();
		return elist;
	}
}
