package com.hainan.cs.dao;

import java.util.List;

import com.hainan.cs.bean.EducationRecord;

public interface EducationDao {

	void isnert(EducationRecord er);

	List<EducationRecord> queryEducationRecord();

}
