package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.CheckList;

public interface CheckListRepo extends CrudRepository<CheckList, Integer> {

	
}
