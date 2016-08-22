package com.mao.hand.Dao;

import java.util.List;

import com.mao.hand.Beans.Store;

public interface StoreDao {
	public abstract List<Store> getAllStore();
	public abstract void updateStore();
	public abstract void InsertStore();
	public abstract void deleteStore();
}
