package com.mao.hand.Dao;

import java.util.List;

import com.mao.hand.Beans.Address;

public interface AddressDao {
	public abstract List<Address> getAllAddress();
	public abstract void updateAddress();
	public abstract void InsertAddress();
	public abstract void deleteAddress();
	
}
