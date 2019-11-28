package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name= "checklist")
public class CheckList {


	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String checkListName;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy ="list")
	private List<ListItem> listItems;
	
	
	
	public int getId() {
		return id;
	}
	
	public void setEmail(int id) {
		this.id = id;
	}
	
	public List<ListItem> getListItems() {
		return listItems;
	}

	public void setListItems(List<ListItem> listItems) {
		this.listItems = listItems;
	}

	public String getCheckListName() {
		return checkListName;
	}
	
	public void setCheckListName(String checkListName) {
		this.checkListName = checkListName;
	}
}
