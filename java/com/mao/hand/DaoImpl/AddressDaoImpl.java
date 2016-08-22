package com.mao.hand.DaoImpl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.mao.hand.Beans.Address;
import com.mao.hand.Dao.AddressDao;

public class AddressDaoImpl extends SqlSessionDaoSupport implements AddressDao {



	public List<Address> getAllAddress() {
		List<Address> list = getSqlSession().selectList("findAllAddress");
		return list;
	}

	public void updateAddress() {
		
	}

	public void InsertAddress() {
		// TODO Auto-generated method stub

	}

	public void deleteAddress() {
		// TODO Auto-generated method stub

	}

}
