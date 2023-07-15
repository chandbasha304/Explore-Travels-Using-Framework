package com.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CheckingData {
	@Autowired
	JdbcTemplate dataretrieve;
	
	
	
	
	public boolean dataFromDatabase(String name,String Password)
	
	{
		
		List<Map<String, Object>> query = dataretrieve.queryForList("select * from traveller where userMail=? and userPassword=?",name,Password)
			;
	if(query.size()==1)
	{
		return true;
	}
	else
	{
		return false;
	}
		
		
	}
	
	
	
	

}
