package com.mao.hand.Dao;

import java.util.List;

import com.mao.hand.Beans.City;

public interface CityDao {
	public abstract List<City> getAllCity();
	public abstract void updateCity();
	public abstract void InsertCity();
	public abstract void deleteCity();
}
