package com.hainan.cs.dao;

import java.util.List;

import com.hainan.cs.bean.EntertainmentRecord;

public interface EntertainmentDao {

	void insert(EntertainmentRecord er);

	List<EntertainmentRecord> query();

}
