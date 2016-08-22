package com.mao.hand.Service;

import java.util.List;

import com.mao.hand.Beans.Customer;

public interface CustomerService {
	public abstract void  SaveCustomer(Customer customer);
	public abstract List<Customer> SelectCustomer();
	public abstract void SelectLastInsert();
	public abstract void DeleteCustomer(Customer customer);
	public abstract void UpdateCustomer(Customer customer);
}
