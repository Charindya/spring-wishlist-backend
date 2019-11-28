package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.ListItem;
import com.example.demo.service.ListItemService;

@RestController
public class ListItemController {
	
	@Autowired
	ListItemService listItemService;
	
	@RequestMapping("/listItem")
	public ListItem getListItem(@RequestParam int id) {
		return listItemService.getListItem(id);

	}
	
	@RequestMapping("/listItems")
	public Iterable<ListItem> getListItems() {
		return listItemService.getListItems();
	}
	
	@PostMapping("/{listId}/listItem")
	public int addListItem(@RequestBody ListItem listItem, @PathVariable int listId){
		return listItemService.addListItem(listItem, listId);
	}
	
	@PutMapping("/{listId}/listItem")
	public int updateListItem(@RequestBody ListItem listItem, @PathVariable int listId) {
		return listItemService.updateListItem(listItem, listId);
	}
	@DeleteMapping("/listItem")
	public void deleteListItem(@RequestParam int id) {
		listItemService.deleteListItem(id);
	}
	
	
	
}
