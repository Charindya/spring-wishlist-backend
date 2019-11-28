package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.example.demo.model.ListItem;

public interface ListItemRepo extends CrudRepository<ListItem, Integer> {
	
}
