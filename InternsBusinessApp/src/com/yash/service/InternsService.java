package com.yash.service;

import java.util.List;

import com.yash.entities.Intern;
import com.yash.entities.Level;

public interface InternsService {

	List<Intern> getAllInterns();
	Intern getInternsById(int id) throws Exception;
	String insert(Intern intern) throws Exception;
	String delete(int id) throws Exception;
	String updateLevel(int id,Level level) throws Exception;
	
}
