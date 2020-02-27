package com.yash.service;

import java.util.List;

import com.yash.dao.InternsDao;
import com.yash.dao.InternsDaoImpl;
import com.yash.entities.Intern;
import com.yash.entities.Level;

public class InternsServiceImpl implements InternsService {

	private InternsDao internsDao;

	public InternsServiceImpl() {
		internsDao = new InternsDaoImpl();
	}

	@Override
	public List<Intern> getAllInterns() {

		return internsDao.getAllInterns();
	}

	@Override
	public Intern getInternsById(int id) throws Exception {

		return internsDao.getInternsById(id);
	}

	@Override
	public String insert(Intern intern)throws Exception {

		return internsDao.insert(intern);
	}

	@Override
	public String delete(int id) throws Exception {

		return internsDao.delete(id);
	}

	@Override
	public String updateLevel(int id, Level level) throws Exception {

		return internsDao.updateLevel(id, level);
	}

}
