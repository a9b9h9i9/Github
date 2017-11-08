package com.niit.jtest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.dao.SupplierDAO;
import com.niit.model.Product;
import com.niit.model.Supplier;



public class SupplierJUnitTest {

	private static SupplierDAO supplierDAO;
	private static AnnotationConfigApplicationContext context;
	private static Supplier supplier;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.");
		context.refresh();
		
		supplier =(Supplier)context.getBean("supplier");
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	//@Ignore
	@Test
	public void add_Supply_success()
	{
		supplier.setSupplierId(3);
		supplier.setSupplierName("Firm35");
		supplier.setSupplierAddress("New Delhi");
		supplier.setSupplierContact(8890199348L);
		assertEquals(true, supplierDAO.addSupplier(supplier));
	}
	@Ignore
	@Test
	public  void get_supplier_by_id()
	{
		supplier= supplierDAO.getSupplierById(2);
		assertNotNull(supplier);
		assertEquals("Firm2", supplier.getSupplierName());		
	}
	@Ignore
	@Test
	public void update_supplier()
	{
		supplier=supplierDAO.getSupplierById(2);
		supplier.setSupplierAddress("Gurugram");
		assertEquals(true, supplierDAO.updateSupplier(supplier));
	}
	@Ignore
	@Test
	public void delete_supplier()
	{
		supplier=supplierDAO.getSupplierById(5);
		assertEquals(true, supplierDAO.deleteSupplier(supplier));
	}
	
	@Test
	public void get_all_supplier_success(){
		List<Supplier> list = supplierDAO.getAllSupplier();
		assertEquals(3, list.size());
		for(Supplier sup : list)
		{
			System.out.println(sup.getSupplierId()+" : "+sup.getSupplierName()+" : "+sup.getSupplierAddress());
		}
		
		
	}
	
}
