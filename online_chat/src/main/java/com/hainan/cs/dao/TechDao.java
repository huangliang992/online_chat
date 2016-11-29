package com.hainan.cs.dao;

import java.util.List;

import com.hainan.cs.bean.TechRecord;

public interface TechDao {

	void insert(TechRecord tr);

	List<TechRecord> query();

}
