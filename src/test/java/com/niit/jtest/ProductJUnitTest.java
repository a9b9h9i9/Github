package com.niit.jtest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;


public class ProductJUnitTest {
	private static ProductDAO productDAO;
	private static AnnotationConfigApplicationContext context;
	private static Product product;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.");
		context.refresh();
		
		product =(Product)context.getBean("product");
		productDAO=(ProductDAO)context.getBean("productDAO");
	
	}
    @Ignore
	@Test
	public void add_product_success()
	{
		product.setProductId(1);
		product.setProductName("First");
		product.setDescription("New");
		product.setType("RT");
		product.setProductPrice(4000);
		product.setProductStock(20);
		product.setProductWeight(20);
		assertEquals(true,productDAO.add_Product(product));
	}
	@Ignore
	@Test
	public  void get_product_by_id()
	{
		product= productDAO.getProductByID(1);
		assertNotNull(product);
		assertEquals("First", product.getProductName());		
	}
	@Ignore
	@Test
	public void update_product()
	{
		product=productDAO.getProductByID(1);
		product.setDescription("Used");
		assertEquals(true, productDAO.update_Product(product));
	}
	@Ignore
	@Test
	public void delete_product()
	{
		product= productDAO.getProductByID(4);
		assertEquals(true,productDAO.delete_Product(product));
	}
	//@Ignore
	@Test
	public void get_all_product_success(){
		List<Product> list = productDAO.getAllProduct();
		assertEquals(9, list.size());
		for(Product pro : list)
		{
			System.out.println(pro.getProductId()+":"+pro.getProductName()+":"+pro.getProductPrice());
		}
		
	}
	
	
}
