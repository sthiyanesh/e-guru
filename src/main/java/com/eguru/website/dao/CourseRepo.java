package com.eguru.website.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eguru.website.classobject.course;

public interface CourseRepo extends CrudRepository<course, Integer> {

	List<course> findByGuruid(int guruid);
}
