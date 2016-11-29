package com.hainan.cs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hainan.cs.bean.TechRecord;

public class TechDaoImp implements TechDao{
	private SessionFactory sessionfactory;
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	@Override
	  public void insert(TechRecord tr){
		  Session session=sessionfactory.openSession();
		  session.beginTransaction();
		  session.save(tr);
		  session.getTransaction().commit();
		  session.close();
	  }
	  @Override
	  public List<TechRecord> query(){
		  Session session=sessionfactory.openSession();
		  session.beginTransaction();
		  String str="from TechRecord tr";
		  Query query=session.createQuery(str);
		  List<TechRecord> tlist=query.list();
		  session.close();
		  return tlist;
	  }
}
