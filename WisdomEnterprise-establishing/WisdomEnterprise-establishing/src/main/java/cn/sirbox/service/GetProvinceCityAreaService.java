package cn.sirbox.service;

import java.util.List;

import cn.sirbox.model.Area;
import cn.sirbox.model.City;
import cn.sirbox.model.Province;


public interface GetProvinceCityAreaService {
	
	//获取省份
	public List<Province> getProvince();
	//获取城市
	public List<City> getCity(String provinceName);
	//获取区
	public List<Area> getArea(String name);
	
	
}
