package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Supplier;

@Repository(value="supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean deleteSupplier(Supplier supplier) {
		
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	
	public Supplier getSupplierById(int SupplierId) {
		return (Supplier)sessionFactory.getCurrentSession().get(Supplier.class, SupplierId);
		
	}

	
	public List<Supplier> getAllSupplier() {
		
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

}
