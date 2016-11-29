package com.hainan.cs.dao;

import java.util.List;

import com.hainan.cs.bean.GameRecord;

public interface GameDao {

	void insert(GameRecord gr);

	List<GameRecord> query();

}
