package cn.sirbox.service.impl;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.sirbox.dao.CityMapper;
import cn.sirbox.dao.ProvinceMapper;
import cn.sirbox.dao.ReleaseinfoMapper;
import cn.sirbox.model.City;
import cn.sirbox.model.CityExample;
import cn.sirbox.model.Province;
import cn.sirbox.model.ProvinceExample;
import cn.sirbox.model.Releaseinfo;
import cn.sirbox.model.ReleaseinfoExample;
import cn.sirbox.model.ReleaseinfoExample.Criteria;
import cn.sirbox.model.page;
import cn.sirbox.service.ReleaseinfoService;
import cn.sirbox.utils.ExcelUtils;

@Service
public class ReleaseinfoServiceimpl implements ReleaseinfoService {

	@Autowired
	private ReleaseinfoMapper releaseinfoMapper;
	
	@Autowired
	private ProvinceMapper provinceMapper;
	
	@Autowired
	private CityMapper cityMapper;
	
	// 查询所有发布信息
	public List<Releaseinfo> findAll(String thispage) throws Exception {
		
		page page = new page();
		page.setThispage(Integer.parseInt(thispage));
		PageHelper.startPage(page.getStartPos(), page.getPagenumber());
		return releaseinfoMapper.selectByExample(new ReleaseinfoExample());
	}

	// 新增发布信息
	public void add(Releaseinfo releaseinfo) throws Exception {

		// 获取系统当前时间设置为发布信息的创建时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		releaseinfo.setCreateTime(sdf.format(new Date()));
		releaseinfo.setState(1);//新增发布时设置状态为1
		releaseinfoMapper.insertSelective(releaseinfo);

	}

	// 更新发布信息
	public void update(Releaseinfo releaseinfo) throws Exception {

		releaseinfoMapper.updateByPrimaryKeySelective(releaseinfo);
	}
	
	// 删除发布信息
	public void delete(Integer id) throws Exception {

		releaseinfoMapper.deleteByPrimaryKey(id);

	}

	// 批量审批
	public void update(Integer[] id, String str) throws Exception {
		
		// 2:审批通过 3：审批不通过
		int state =3;
		if(str.equals("2")){
			state = 2;
		}
		Map<String ,Object> map = new HashMap<String ,Object>();
		map.put("state", state);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < id.length; i++) {
			list.add(id[i]);
		}
		map.put("ids", list);
		releaseinfoMapper.updateByPrimaryKeys(map);

	}

	// 根据id查询发布信息
	public Releaseinfo findById(Integer id) throws Exception {

		return releaseinfoMapper.selectByPrimaryKey(id);
	}
/*
	public List<Releaseinfo> findByName(String itemBusiness) throws Exception {

		Releaseinfo releaseinfo = new Releaseinfo();
		releaseinfo.setItemBusiness(itemBusiness);
		return releaseinfoMapper.selectByExample(releaseinfo);
	}

	public List<Releaseinfo> findByState(Integer states) throws Exception {

		Releaseinfo releaseinfo = new Releaseinfo();
		releaseinfo.setState(states);
		return releaseinfoMapper.selectByExample(releaseinfo);

	}
*/
	public void exportFile(String ids, HttpServletResponse response) {
		
		Map<String ,Object> map = new HashMap<String ,Object>();
		List<Integer> list = new ArrayList<Integer>();
		if(ids!=null&&ids.length()>0){
			ids = ids.substring(0, ids.length()-1);
			String[] id=ids.split("\\,");
			for (int i = 0; i < id.length; i++) {
				list.add(Integer.parseInt(id[i]));
			}
			map.put("ids", list);
		}else{
			map.put("ids", "");
		}
		List<Releaseinfo> objs = releaseinfoMapper.exportData(map);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		OutputStream os = null;
		try {
			String fileName = "发布信息表" + df.format(new Date()) + ".xlsx";// 文件名称
			os = response.getOutputStream();// 得到输出流outputStream是用来向客户端输入任何数据的
			response.reset();// 清除首部的空白行
			response.setHeader("Content-disposition", "attachment; filename = " + URLEncoder.encode(fileName, "UTF-8"));
			response.setContentType("application/octet-streem");
			ExcelUtils.getInstance().export2Excel(os, objs, Releaseinfo.class, true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != os) {
				try {
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public List<City> getCity(String provincecode) {
		
		CityExample example = new CityExample();
		example.createCriteria().andProvincecodeEqualTo(provincecode);
		return cityMapper.selectByExample(example);
	}

	@Override
	public List<Province> getProvince() {
		ProvinceExample example = new ProvinceExample();
		return provinceMapper.selectByExample(example);
		
	}

	@Override
	public List<Releaseinfo> selectByCondition(String thispage,
			String projectBusiness, String issuer, String createTime,
			String projectType, String state) {
		page page = new page();
		page.setThispage(Integer.parseInt(thispage));
		PageHelper.startPage(page.getStartPos(), page.getPagenumber());
		Map<String, Object> map = new HashMap<String, Object>();
		//按照行业查询
		map.put("projectBusiness", projectBusiness);
		//按照发布者查询
		map.put("issuer", issuer);
		//按照时间排序
		map.put("createTime", createTime);
		//项目类型排序
		map.put("projectType", projectType);
		//按照状态排序
		map.put("state", state);
		return releaseinfoMapper.selectByCondition(map);
				
		
	}

	@Override
	public Integer verification(HttpServletRequest request) {
		
		return null;
	}
}
