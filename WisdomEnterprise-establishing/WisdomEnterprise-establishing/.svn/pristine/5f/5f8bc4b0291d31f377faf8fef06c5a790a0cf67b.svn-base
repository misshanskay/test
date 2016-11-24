package cn.sirbox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sirbox.dao.AreaMapper;
import cn.sirbox.dao.CityMapper;
import cn.sirbox.dao.ProvinceMapper;
import cn.sirbox.model.Area;
import cn.sirbox.model.City;
import cn.sirbox.model.Province;
import cn.sirbox.model.ProvinceExample;
import cn.sirbox.service.GetProvinceCityAreaService;
@Service
public class GetProvinceCityAreaServiceImpl implements GetProvinceCityAreaService{
	
	@Autowired
	private ProvinceMapper provinceMapper;
	
	@Autowired
	private CityMapper cityMapper;
	
	@Autowired
	private AreaMapper areaMapper;
	
	@Override
	public List<Province> getProvince() {
		
		ProvinceExample example = new ProvinceExample();
		
		return provinceMapper.selectByExample(example);
	}

	@Override
	public List<City> getCity(String provinceName) {
		
		String name = provinceName;
		return cityMapper.selectCityByProvinceCode(name);
	}

	@Override
	public List<Area> getArea(String name) {
		
		
		return areaMapper.selectAreaCityName(name);
	}

}
