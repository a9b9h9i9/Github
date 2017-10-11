package com.niit.dao;

import java.util.*;

import com.niit.model.Category;

public interface CategoryDAO {
	
	public boolean add_Category(Category category);
	public boolean update_Category(Category category);
	public boolean delete_Category(Category category);
	public Category getCategoryByID(int categoryId);
	public List<Category> getAllCategory();
	

}
