package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int SupplierId;
	
	public String SupplierName;
	public String SupplierAddress;
	public Long SupplierContact;
	
	
	public int getSupplierId() {
		return SupplierId;
	}
	public void setSupplierId(int supplierId) {
		SupplierId = supplierId;
	}
	public String getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	public String getSupplierAddress() {
		return SupplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		SupplierAddress = supplierAddress;
	}
	public Long getSupplierContact() {
		return SupplierContact;
	}
	public void setSupplierContact(Long supplierContact) {
		SupplierContact = supplierContact;
	}

}
