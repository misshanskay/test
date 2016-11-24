package cn.sirbox.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.sirbox.dao.AccountMapper;
import cn.sirbox.dao.BookedMapper;
import cn.sirbox.dao.UserUMapper;
import cn.sirbox.model.Account;
import cn.sirbox.model.Booked;
import cn.sirbox.model.BookedExample;
import cn.sirbox.model.BookedQueryVo;
import cn.sirbox.model.UserU;
import cn.sirbox.model.UserUExample;
import cn.sirbox.model.BookedExample.Criteria;
import cn.sirbox.model.Enterprise;
import cn.sirbox.model.EnterpriseExample;
import cn.sirbox.model.page;
import cn.sirbox.service.BookedService;
import cn.sirbox.utils.ArrayUtil;
import cn.sirbox.utils.ExcelUtils;
@Service
public class BookedServiceImpl implements BookedService{
	
	@Autowired
	private BookedMapper bookedMapper;
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private UserUMapper userUMapper;
	
	//查询所有入账
	@Override
	public List<Booked> findAll(String thispage) {
		
		page page = new page();
		page.setThispage(Integer.parseInt(thispage));
		PageHelper.startPage(page.getStartPos(), page.getPagenumber());
		Map<String ,Object> map = new HashMap<String, Object>();
		map.put("ids", "");
		return bookedMapper.selectByExamples(map);
	}

	@Override
	public void exportFile(String ids, HttpServletResponse response) {
		
		Map map = new HashMap<String, Object>();
		if(ids!=null&&!"".equals("")){
			List<Integer> list = new ArrayList<Integer>();
			ids=ids.substring(0, ids.length()-1);
			String[] id = ids.split("\\,");
			for(int i=0;i<id.length;i++){
				list.add(Integer.parseInt(id[i]));
			}
			map.put("ids", list);
		}else{
			map.put("ids", "");
		}
		List<Booked> objs = bookedMapper.selectByExamples(map);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		OutputStream os = null;
		try {
			String fileName = "入款列表" + df.format(new Date()) + ".xlsx";// 文件名称
			os = response.getOutputStream();// 得到输出流outputStream是用来向客户端输入任何数据的
			response.reset();// 清除首部的空白行
			response.setHeader("Content-disposition", "attachment; filename = " + URLEncoder.encode(fileName, "UTF-8"));
			response.setContentType("application/octet-streem");
			os = response.getOutputStream();
			ExcelUtils.getInstance().export2Excel(os, objs, Booked.class, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//入款或扣款
	@Override
	public int addOrReduce(String userName,Booked booked) {
		
		int num=0;
		Integer type = booked.getType();
			Date date = new Date();
			Timestamp timestamp = new Timestamp(date.getTime());
			Account account = accountMapper.selectByPrimaryKeys(userName);
			booked.setUserId(account.getId());
			booked.setCreateTime(timestamp);
			float balance = account.getBalance();
			if(type==1){//表示入账
				booked.setState(1);
				booked.setBalance(balance+booked.getDeal());
				bookedMapper.updateByPrimaryKeySelectives(booked);
				account.setBalance(balance+booked.getDeal());
				accountMapper.updateByPrimaryKeySelective(account);
				num=1;
			}else if(type==3){//表示扣款
				booked.setState(3);
				booked.setBalance(balance-booked.getDeal());
				bookedMapper.updateByPrimaryKeySelectives(booked);
				account.setBalance(balance-booked.getDeal());
				accountMapper.updateByPrimaryKeySelective(account);
				num = 2;
			}
		return num;
	}
	
	protected  Account getUserId(String userName){
		
		return accountMapper.selectByPrimaryKeys(userName);
	
		
	}
	
	//会员查询
	@Override
	public List<Booked> expense(String thispage, BookedQueryVo bookedQueryVo) {
		
		BookedExample bookedExample = new BookedExample();
		BookedExample.Criteria criteria = bookedExample.createCriteria();
		criteria.andTypeEqualTo(2);
		if(bookedQueryVo!=null){
			if(!"".equals(bookedQueryVo.getUsername())){
				Account account = getUserId(bookedQueryVo.getUsername());
				criteria.andUserIdEqualTo(account.getId());
			}
			if(bookedQueryVo.getStartDeal()!=null){
				if(bookedQueryVo.getEndDeal()!=null){
					criteria.andDealBetween(bookedQueryVo.getStartDeal(), bookedQueryVo.getEndDeal());
				}
			}	
			if(!"".equals(bookedQueryVo.getProductType())){
				criteria.andProductTypeLike(bookedQueryVo.getProductType());
			}
		}		
		return bookedMapper.selectByExample(bookedExample);
	}

	@Override
	public void add(String title,Integer uid,Integer type,float deal,float balance) {
		
		Booked booked = new Booked();
		booked.setBalance(balance);
		booked.setUserId(uid);
		booked.setType(type);
		booked.setDeal(deal);
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		booked.setCreateTime(timestamp);
		booked.setState(1);
		UUID uuid = UUID.randomUUID();
	    String number= uuid.toString().toString();
	    number=number.substring(0,8)+number.substring(9,13)+number.substring(14,18)+number.substring(19,23)+number.substring(24);
	    booked.setNumber(number);
	    booked.setNote(number+title);
	    bookedMapper.insertSelective(booked);		
	}

	@Override
	public Map<String, Object> find(String username, String startTime,
			String endTime, String way) {
		Map<String, Object> map = new HashMap<String, Object>();
		BookedQueryVo bookedQueryVo = new  BookedQueryVo();
		if(username!=null&&!"".equals(username)){
			bookedQueryVo.setUsername(username);
		}
		
		if(startTime!=null&&!"".equals(startTime)){
			bookedQueryVo.setStartTime(Timestamp.valueOf(startTime));
		}
		
		if(endTime!=null&&!"".equals(endTime)){
			bookedQueryVo.setEndTime(Timestamp.valueOf(endTime));
		}
		
		if(way!=null&&!"".equals(way)){
			bookedQueryVo.setWay(way);
		}
		float count = 0;
		List<Booked> blist = bookedMapper.find(bookedQueryVo);
		String[] YH = new String[ArrayUtil.YH.length];
		for(int i=0;i<blist.size();i++){
			for(int j=0;j<YH.length;j++){
				if(blist.get(i).getWay().equals(YH[j])&&blist.get(i).getType()==1){
					map.put(YH[j], blist.get(i).getDeal());
					count += blist.get(i).getDeal();
				}
			}
			//返回总的入账金额
			map.put("count", count);
			if(blist.get(i).getWay()==null&&blist.get(i).getType()==2){
				map.put("expense", blist.get(i).getDeal());
			}
			if(blist.get(i).getBalance()!=null&&!"".equals(blist.get(i).getBalance())){
				map.put("balance", blist.get(i).getBalance());
			}
		}
		return map;
	}
	
	//查询订单是否存在 存在返回 1 不存在 返回 0
	@Override
	public int checkNumber(String number) {
		
		Integer num = bookedMapper.selectByNumber(number);
		if(num!=null){
			return 1;
		}else{
			return 0;
		}	
	}
	
	//跳转订单管理页面
	@Override
	public List<Booked> getPayManage(String thispage) {
		
		page page = new page();
		page.setThispage(Integer.parseInt(thispage));
		PageHelper.startPage(page.getStartPos(), page.getPagenumber());
		BookedExample bookedExample = new BookedExample();
		return bookedMapper.getPayManage(bookedExample);
	}

    @Override
    public List<String> getCount(Integer year, Integer month, Integer month1) {
        // TODO Auto-generated method stub
        List<String> list=new ArrayList<>();
        list.add("入款");
        for(int i=0;i<month;i++){
            
            GregorianCalendar gc1 = new GregorianCalendar(year,month1,1,00,00,00);
            GregorianCalendar gc2=null;
            if(month1==11){
                
                gc2 = new GregorianCalendar(year+1,0,1,00,00,00);
            }else{
                
                gc2 = new GregorianCalendar(year,month1+1,1,00,00,00);
            }
            
            Integer sum=bookedMapper.getCountDeposit(gc1.getTime(), gc2.getTime());
            if(sum==null){
                sum=0;
            }
            list.add(String.valueOf(sum));
            month1++;
            if(month1==12){
                month1=0;
                year=year+1;
            }
        }
        
        return list;
    }

    @Override
    public List<String> getCount1(Integer year, Integer month, Integer month1) {
        // TODO Auto-generated method stub
        List<String> list=new ArrayList<>();
        list.add("消费");
        for(int i=0;i<month;i++){
            
            GregorianCalendar gc1 = new GregorianCalendar(year,month1,1,00,00,00);
            GregorianCalendar gc2=null;
            if(month1==11){
                
                gc2 = new GregorianCalendar(year+1,0,1,00,00,00);
            }else{
                
                gc2 = new GregorianCalendar(year,month1+1,1,00,00,00);
            }
            
            Integer sum=bookedMapper.getCountExpend(gc1.getTime(), gc2.getTime());
            if(sum==null){
                sum=0;
            }
            list.add(String.valueOf(sum));
            month1++;
            if(month1==12){
                month1=0;
                year=year+1;
            }
        }
        
        return list;
    }

    
	
	//手工处理
	@Override
	public void update(Booked booked, String userName) {
		
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		booked.setCreateTime(timestamp);
		if(booked.getState()==2){
			bookedMapper.updateByPrimaryKeySelective(booked);
		}
		if(booked.getState()==1){
				Account account = accountMapper.selectByPrimaryKeys(userName);
				float balance = account.getBalance();
				booked.setState(1);
				booked.setBalance(balance+booked.getDeal());
				bookedMapper.updateByPrimaryKeySelective(booked);
				account.setBalance(balance+booked.getDeal());
				accountMapper.updateByPrimaryKeySelective(account);
			bookedMapper.updateByPrimaryKeySelective(booked);
		}
		
	}

	//财务查询
	@Override
	public List<Booked> financeQuery(String thispage, String username,
			String startTime, String endTime, String supplier,
			String orderNumber) {
		page page = new page();
		page.setThispage(Integer.parseInt(thispage));
		PageHelper.startPage(page.getStartPos(), page.getPagenumber());
		BookedExample bookedExample = new BookedExample();
		Criteria criteria = bookedExample.createCriteria();
		if(username!=null&&!"".equals(username)){
			Account account = accountMapper.selectByPrimaryKeys(username);
			criteria.andUserIdEqualTo(account.getId());
		}
		if(orderNumber!=null&&!"".equals(orderNumber)){
			criteria.andNumberEqualTo(orderNumber);
		}
		if(supplier!=null&&!"".equals(supplier)){
			criteria.andWayEqualTo(supplier);
		}
		if(startTime!=null&&!"".equals(startTime)){
			if(endTime!=null&&!"".equals(endTime)){
				criteria.andCreateTimeBetween(Timestamp.valueOf(startTime), Timestamp.valueOf(endTime));
			}
		}
	
		return bookedMapper.getPayManage(bookedExample);
	}
	
		
}
