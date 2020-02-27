package com.yash.controller;

import java.util.List;

import com.yash.entities.Intern;
import com.yash.entities.Level;
import com.yash.service.InternsService;
import com.yash.service.InternsServiceImpl;

public class InternsController {

	private InternsService internsService;

	public InternsController() {
		internsService = new InternsServiceImpl();

	}

	public List<Intern> getAllInterns() {
		return internsService.getAllInterns();
	}

	public Intern getInternsById(int id) throws Exception {
		return internsService.getInternsById(id);
	}

	public String insert(Intern intern) throws Exception {
		return internsService.insert(intern);
	}

	public String delete(int id) throws Exception {
		return internsService.delete(id);
	}

	public String updateByLevel(int id,Level level) throws Exception {
		return internsService.updateLevel(id, level);
	}

}
