package com.mao.hand.Dao;

import java.util.List;

import com.mao.hand.Beans.Customer;

public interface CustomerDao {
	public abstract List<Customer> getAllCustomer();
	public abstract void updateCustomer(Customer customer);
	public abstract void InsertCustomer(Customer customer);
	public abstract void deleteCustomer(Customer customer);
}
