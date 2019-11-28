package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.dao.CheckListRepo;
import com.example.demo.dao.ListItemRepo;
import com.example.demo.model.CheckList;
import com.example.demo.model.ListItem;

@Service
public class ListItemService {

	@Autowired
	ListItemRepo repo;
	
	@Autowired
	CheckListRepo checkListRepo;
	
	public ListItem getListItem(int id) {
		Optional<ListItem> listItem = repo.findById(id);
		if(listItem.isPresent()) {
			return listItem.get();
		}
		return null;
	}
	
	public Iterable<ListItem> getListItems() {
		return repo.findAll();
	}
	
	public int addListItem(ListItem listItem, int listId){
		if(this.getListItem(listItem.getId())== null) {
			Optional<CheckList> list = checkListRepo.findById(listId);
			listItem.setList(list.get());
			repo.save(listItem);
			return listItem.getId();
		} else {
			throw new RuntimeException("Redit!");
		}
	}
	
	public int updateListItem(@RequestBody ListItem listItem, int listId) {
		if(this.getListItem(listItem.getId())!= null) {
			Optional<CheckList> list = checkListRepo.findById(listId);
			listItem.setList(list.get());
			repo.save(listItem);
			return listItem.getId();
		} else {
			throw new RuntimeException("This user does not exist!");
		}
	}

	public void deleteListItem(int id) {
		repo.delete(repo.findById(id).orElseThrow(() -> new RuntimeException("This item does not exist. Please select an existing user to delete.")));
	}
	
	
}
