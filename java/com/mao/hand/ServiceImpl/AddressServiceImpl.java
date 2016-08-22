package com.mao.hand.ServiceImpl;

import java.util.List;

import com.mao.hand.Beans.Address;
import com.mao.hand.DaoImpl.AddressDaoImpl;
import com.mao.hand.Service.AddressService;

public class AddressServiceImpl implements AddressService {
	AddressDaoImpl addressDaoImpl;
	public void setAddressDaoImpl(AddressDaoImpl addressDaoImpl) {
		this.addressDaoImpl = addressDaoImpl;
	}
	public List<Address> getAllAddress() {
		return addressDaoImpl.getAllAddress();
	}

}
