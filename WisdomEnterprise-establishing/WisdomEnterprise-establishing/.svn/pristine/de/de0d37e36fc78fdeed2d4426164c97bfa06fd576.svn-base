package cn.sirbox.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sirbox.model.Area;
import cn.sirbox.model.City;
import cn.sirbox.service.GetProvinceCityAreaService;

@RequestMapping("/getcityandarea")
@Controller
public class GetCityAndAreaController {
	
	@Autowired
	private GetProvinceCityAreaService getProvinceCityAreaService;
	
	@RequestMapping("/querycity")
	public void queryCity(String provinceName, HttpServletResponse response)
			throws IOException {

		List<City> clist = getProvinceCityAreaService.getCity(provinceName);
		response.getWriter().print(JSONArray.fromObject(clist).toString());
	}
	
	@RequestMapping("/queryarea")
	public void queryArea(String name, HttpServletResponse response) throws IOException{
		
		List<Area> alist = getProvinceCityAreaService.getArea(name);
		response.getWriter().print(JSONArray.fromObject(alist).toString());
	}
	
}
