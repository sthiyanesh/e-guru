package com.eguru.website.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eguru.website.classobject.guru;

public interface GuruRepo extends CrudRepository<guru, Integer>{
	
	List<guru> findByEmailid(String emailid);
	
	List<guru> findByUsername(String username);
	
}
