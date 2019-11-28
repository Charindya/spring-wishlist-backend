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
import com.example.demo.model.CheckList;
import com.example.demo.service.CheckListService;

@RestController
public class ListController {
	
	@Autowired
	CheckListService checkListService;
	
//
//	@RequestMapping("/addAlien")
//	public String addAlien(Alien alien) {
//		repo.save(alien);
//		return "home.jsp";
//	}

	@RequestMapping("/list")
	public CheckList getList(@RequestParam int id) {
		return checkListService.getList(id);

	}
	
	@RequestMapping("/lists")
	public Iterable<CheckList> getLists() {
		return checkListService.getLists();
	}
	
	@PostMapping("/list")
	public int addList(@RequestBody CheckList list){
		return checkListService.addList(list);
	}
	
	@PutMapping("/list/{id}")
	public int updateListItem(@RequestBody CheckList list, @PathVariable int id) {
		return checkListService.updateList(list, id);
	}
	
	@DeleteMapping("/list")
	public void deleteListItem(@RequestParam int id) {
		checkListService.deleteList(id);
	}
	
	
	
}
