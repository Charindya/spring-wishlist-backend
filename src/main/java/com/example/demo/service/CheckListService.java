package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.dao.CheckListRepo;
import com.example.demo.model.CheckList;

@Service
public class CheckListService {

	@Autowired
	CheckListRepo repo;
	
	public CheckList getList(int id) {
		Optional<CheckList> list = repo.findById(id);
		if(list.isPresent()) {
			return list.get();
		}
		return null;

	}
	
	public Iterable<CheckList> getLists() {
		return repo.findAll();
	}
	
	public int addList(CheckList list){
		repo.save(list);
		return list.getId();

	}
	
	public int updateList(@RequestBody CheckList list, @PathVariable int id) {
		if(this.getList(list.getId())!= null) {
			repo.save(list);
			return list.getId();
		} else {
			throw new RuntimeException("This list does not exist!");
		}
	}

	public void deleteList(int id) {
		repo.delete(repo.findById(id).orElseThrow(() -> new RuntimeException("This list does not exist. Please select an existing user to delete.")));
	}
	
	
}
