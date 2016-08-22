package com.mao.hand.DaoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.mao.hand.Beans.Customer;
import com.mao.hand.Dao.CustomerDao;

public class CustomerDaoImpl extends SqlSessionDaoSupport implements CustomerDao{

	public List<Customer> getAllCustomer() {
		
		return getSqlSession().selectList("findAllCustomer");
	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateCustomer",customer);
	}

	public void InsertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertIntoCustomer",customer);
	}
	
	public Customer SelectLastInsert(){
		return getSqlSession().selectOne("findLastInsert");
	}
	
	public void deleteCustomer(Customer customer) {
		SqlSession session = getSqlSession();
		session.delete("deletePaymentByCustomerId",customer);
		session.delete("deleteRentalByCustomerId", customer);
		session.delete("deleteCustomerById", customer);
	}

}
