package com.niit.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.stereotype.Component;

import javax.persistence.*;
@Entity
@Component // it changes into bean which can be used by getBean method
@Table
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int CategoryId;
	
	private String Categoryname;
	private String Description;
	private String type;
	
	
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public String getCategoryname() {
		return Categoryname;
	}
	public void setCategoryname(String categoryname) {
		Categoryname = categoryname;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
