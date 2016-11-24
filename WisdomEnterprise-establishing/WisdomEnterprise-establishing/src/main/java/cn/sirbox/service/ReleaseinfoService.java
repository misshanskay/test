package cn.sirbox.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sirbox.model.City;
import cn.sirbox.model.Province;
import cn.sirbox.model.Releaseinfo;

public interface ReleaseinfoService {
		
		//查询所有的发布信息
		public List<Releaseinfo> findAll(String thispage) throws Exception;
		
		//新增发布信息
		public void add(Releaseinfo releaseinfo) throws Exception;
		
		//更新发布信息
		public void update(Releaseinfo releaseinfo)throws Exception;
		
				//删除发布信息
		public void delete(Integer id) throws Exception;
		/*
		//查看已发布信息
		public Releaseinfo getReleaseinfo(Integer id) throws Exception;
		*/
		//审核发布信息
		public void update(Integer[] id ,String str) throws Exception;
		
	/*	
		//根据条件查询发布信息
		public List<Releaseinfo> findByName(String name) throws Exception;
		
		//根据审核状态查询发布信息
		public List<Releaseinfo> findByState(Integer states) throws Exception;
		*/
		//根据id查询发布信息
		public Releaseinfo findById(Integer id) throws Exception;

		public List<City> getCity(String provincecode);

		public List<Province> getProvince();

		
		//导出发布信息excel
		public void exportFile(String ids, HttpServletResponse response)throws Exception;

		public List<Releaseinfo> selectByCondition(String thispage,
				String projectBusiness, String issuer, String createTime,
				String projectType, String state);

		public Integer verification(HttpServletRequest request);
}
