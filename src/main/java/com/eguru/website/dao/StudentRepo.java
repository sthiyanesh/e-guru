package com.eguru.website.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eguru.website.classobject.student;

public interface StudentRepo extends CrudRepository<student, Integer> {
	
	List<student> findByEmailid(String emailid);
	
	List<student> findByUsername(String username);

}
