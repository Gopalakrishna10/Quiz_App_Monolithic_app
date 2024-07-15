package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Questions;
@Repository


public interface QuestionRepo extends JpaRepository<Questions, Integer>{


	List<Questions> category(String category);

	
	@Query(value=" select * from questions q where q.category=:category" ,nativeQuery = true)
	List<Questions> findByRamcategory(String category);
}