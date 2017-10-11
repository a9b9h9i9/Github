package com.niit.dao;

import java.util.List;
import com.niit.model.Product;

public interface ProductDAO {

	public boolean add_Product(Product product);
	public boolean update_Product(Product product);
	public boolean delete_Product(Product product);
	public Product getProductByID(int ProductId);
	public List<Product> getAllProduct();
	
}
