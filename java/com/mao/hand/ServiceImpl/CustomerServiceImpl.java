package com.mao.hand.ServiceImpl;

import java.util.List;

import com.mao.hand.Beans.Customer;
import com.mao.hand.DaoImpl.CustomerDaoImpl;
import com.mao.hand.Service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	CustomerDaoImpl customerDaoImpl ;
	public void setCustomerDaoImpl(CustomerDaoImpl customerDaoImpl) {
		this.customerDaoImpl = customerDaoImpl;
	}
	public void SaveCustomer(Customer customer) {
	 customerDaoImpl.InsertCustomer(customer);
	}

	public List<Customer> SelectCustomer() {
		return customerDaoImpl.getAllCustomer();
	}
	public void SelectLastInsert() {	
		   Customer ct =  customerDaoImpl.SelectLastInsert();
	    	System.out.println("已保存的数据如下:");
	    	System.out.println("ID :"+ct.getCustomer_id());
	    	System.out.println("FirstName :"+ct.getFirst_name());
	    	System.out.println("Last_name :"+ct.getLast_name());
	    	System.out.println("Email :"+ct.getEmail());
	    	System.out.println("Address :"+ ct.getAddress_id());
	}
	public void DeleteCustomer(Customer customer) {
		customerDaoImpl.deleteCustomer( customer);
	}
	public void UpdateCustomer(Customer customer) {
		customerDaoImpl.updateCustomer(customer);
		
	}

}
