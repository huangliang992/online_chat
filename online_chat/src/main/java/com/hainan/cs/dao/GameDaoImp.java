package com.hainan.cs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.hainan.cs.bean.GameRecord;

public class GameDaoImp implements GameDao {
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public void insert(GameRecord gr) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(gr);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<GameRecord> query() {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		String str = "from GameRecord gr";
		Query query = session.createQuery(str);
		List<GameRecord> glist = query.list();
		session.close();
		return glist;
	}
}
