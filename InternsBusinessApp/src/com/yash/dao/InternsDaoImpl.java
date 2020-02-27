package com.yash.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yash.entities.Intern;
import com.yash.entities.Level;
import com.yash.exception.InternHandlingException;

public class InternsDaoImpl implements InternsDao {

	List<Intern> internList=new ArrayList<Intern>(Arrays.asList(new Intern(1, "Pranaw", "Kaushal", 23, Level.BEGINNER),
			new Intern(2, "Reshma", "Shelar", 23, Level.BEGINNER)));
	
	

	@Override
	public List<Intern> getAllInterns() {
		return internList;
	}

	@Override
	public Intern getInternsById(int id) throws Exception {
		for(Intern intern:internList)
		{
			if(intern.getId()==id)
			{
				return intern;
			}
		}
		throw new InternHandlingException("id not present");
	}

	@Override
	public String insert(Intern intern) throws Exception{
		if(intern.getLevel()==null)
			throw new InternHandlingException("Wrong level you have enetered");
		internList.add(intern);
		return "intern added with id "+intern.getId();
	}

	@Override
	public String delete(int id) throws Exception {
		Intern intern=getInternsById(id);
		internList.remove(intern);
		return "intern deleted with id "+id;
	}

	@Override
	public String updateLevel(int id, Level level) throws Exception {
		Intern intern=getInternsById(id);
		for(Intern o:internList)
		{
			if(o.equals(intern))
			{
				o.setLevel(level);
			}
		}
		return "intern updated with id "+id;
	}

	

}
