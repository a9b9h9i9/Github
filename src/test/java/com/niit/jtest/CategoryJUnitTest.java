package com.niit.jtest;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;




public class CategoryJUnitTest {
	private static CategoryDAO categoryDAO;
	private static AnnotationConfigApplicationContext context;
	private static Category category;
	
	
	
	@BeforeClass
	public  static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.");
		context.refresh();
	
	   category= (Category)context.getBean("category");
	   categoryDAO =(CategoryDAO)context.getBean("categoryDAO");
	}
	//@Ignore
	@Test
	public void add_category_success()
	{
	
		category.setCategoryId(12);
		category.setCategoryname("Turbo");
		category.setDescription("Extras");
		category.setType("Transmission");
		assertEquals(true,categoryDAO.add_Category(category));
		
	}
	@Ignore
	@Test
	public void get_Category_by_id()
	{
		//category.setCategoryId(1);
		 category= categoryDAO.getCategoryByID(1);
		assertNotNull(category);
		assertEquals("Engine", category.getCategoryname());
	}
	
	@Ignore
	@Test
	public void update_category_success(){
		category= categoryDAO.getCategoryByID(4);
		category.setCategoryname("Nitro");
		category.setDescription("Speed");
		category.setType("Acceleration");
		assertEquals(true, categoryDAO.update_Category(category));
		
	}
	@Ignore
	@Test
	public void delete_user_success(){
		category= categoryDAO.getCategoryByID(9);
		assertEquals(true, categoryDAO.delete_Category(category));
		
	}
	@Ignore
	@Test
	public void get_all_users_success(){
		List<Category> list = categoryDAO.getAllCategory();
		assertEquals(4, list.size());
		
	}

}
