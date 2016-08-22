package com.mao.hand.Dao;

import java.util.List;

import com.mao.hand.Beans.Country;

public interface CountryDao {
	public abstract List<Country> getAllCountry();
	public abstract void updateCountry();
	public abstract void InsertCountry();
	public abstract void deleteCountry();
}
