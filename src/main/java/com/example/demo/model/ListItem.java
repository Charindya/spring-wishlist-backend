package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name= "listitem")
public class ListItem {


	public CheckList getList() {
		return list;
	}

	public void setList(CheckList list) {
		this.list = list;
	}

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String description;
	
	@ManyToOne(fetch= FetchType.LAZY, optional=false)
	@JoinColumn(name="list_id", nullable=false)
	@JsonIgnore
	private CheckList list;
	
	
	public int getId() {
		return id;
	}
	
	public void setEmail(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setUsername(String description) {
		this.description = description;
	}
}
