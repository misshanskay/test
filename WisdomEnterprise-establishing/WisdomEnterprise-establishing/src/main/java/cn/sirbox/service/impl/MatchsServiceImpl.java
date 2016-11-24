package cn.sirbox.service.impl;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import cn.sirbox.dao.MatchsMapper;
import cn.sirbox.model.Matchs;
import cn.sirbox.model.MatchsExample;
import cn.sirbox.model.MatchsExample.Criteria;
import cn.sirbox.model.page;
import cn.sirbox.service.MatchsService;
import cn.sirbox.utils.ExcelUtils;
@Service
public class MatchsServiceImpl implements MatchsService{
	
	@Autowired
	private MatchsMapper matchsMapper;
	
	public List<Matchs> findAll(String thispage) {
		
		page page = new page();
		page.setThispage(Integer.parseInt(thispage));
		PageHelper.startPage(page.getStartPos(), page.getPagenumber());
		return matchsMapper.selectByExample();
	}

	public List<Matchs> query(Matchs matchs,String thispage) {
		
		page page = new page();
		page.setThispage(Integer.parseInt(thispage));
		PageHelper.startPage(page.getStartPos(), page.getPagenumber());
		MatchsExample example = new MatchsExample();
		Criteria criteria = example.createCriteria();
		if(matchs.getProjectArea()!=null&&!"".equals(matchs.getProjectArea())){
			criteria.andProjectAreaLike(matchs.getProjectArea());
		}
		if(matchs.getCity()!=null&&!"".equals(matchs.getCity())){
			criteria.andCityLike(matchs.getCity());
		}
		if(matchs.getFundBudget()!=null&&matchs.getFundBudget().indexOf("")==-1){
			String[] fundBudget = matchs.getFundBudget().split("\\,");
			criteria.andFundBudgetBetween(fundBudget[0],fundBudget[1]);
		}
		if(matchs.getProjectFinancingMode()!=null&&!"".equals(matchs.getProjectFinancingMode())){
			criteria.andProjectFinancingModeLike("%"+matchs.getProjectFinancingMode()+"%");
		}
		if(matchs.getProjectBusiness()!=null&&!"".equals(matchs.getProjectBusiness())){
			criteria.andProjectBusinessLike("%"+matchs.getProjectBusiness()+"%");
		}
		if(matchs.getCooperationMode()!=null&&!"".equals(matchs.getCooperationMode())){
			criteria.andCooperationModeEqualTo(matchs.getCooperationMode());
		}
		if(matchs.getProjectName()!=null&&!"".equals(matchs.getProjectName())){
			criteria.andProjectNameLike("%"+matchs.getProjectName()+"%");
		}
		return matchsMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void delete(Integer id) {
		
		matchsMapper.deleteByPrimaryKey(id);
	}
	
	//查看信息
	@Override
	public Matchs check(Integer id) {
		
		return matchsMapper.selectByPrimaryKey(id);
	}
	
	//生成一个已支付订单，并从账户中扣款
	@Override
	public Matchs deductMoney(Integer id) {
		
		return matchsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(Matchs matchs) {
		
		matchsMapper.updateByPrimaryKeySelective(matchs);
	}

	@Override
	public void exportFile(String ids, HttpServletResponse response) {
		
		Map<String ,Object> map = new HashMap<String ,Object>();
		List<Integer> list = new ArrayList<Integer>();
		if(ids!=null&&!"".equals(ids)){
			ids = ids.substring(0,ids.length()-1);
			String[] id = ids.split("\\,");
			for(int i=0;i<id.length;i++){
				list.add(Integer.parseInt(id[i]));
			}
			map.put("ids", list);
		}else{
			map.put("ids", "");
		}
		List<Matchs> objs = matchsMapper.selectByIdOrAll(map);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		OutputStream os = null;
		try {
			String fileName = "发布信息表" + df.format(new Date()) + ".xlsx";// 文件名称
			os = response.getOutputStream();// 得到输出流outputStream是用来向客户端输入任何数据的
			response.reset();// 清除首部的空白行
			response.setHeader("Content-disposition", "attachment; filename = " + URLEncoder.encode(fileName, "UTF-8"));
			response.setContentType("application/octet-streem");
			ExcelUtils.getInstance().export2Excel(os, objs, Matchs.class, true);
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
	public void edit(Matchs matchs) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		map.put("id", matchs.getId());
		matchsMapper.updateById(map);
		
	}
}
