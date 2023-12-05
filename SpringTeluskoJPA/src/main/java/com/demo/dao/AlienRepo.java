package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>{
	
	List<Alien> findByAidGreaterThan(int aid);
	@Query(value="select * from alien where aid=?1 order by aid", nativeQuery = true)
	List<Alien> findByAidSorted(int aid);

}