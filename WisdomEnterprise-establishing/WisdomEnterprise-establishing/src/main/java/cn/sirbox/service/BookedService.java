package cn.sirbox.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import cn.sirbox.model.Booked;
import cn.sirbox.model.BookedQueryVo;

public interface BookedService {

	List<Booked> findAll(String thispage);

	void exportFile(String ids,HttpServletResponse response);

	int addOrReduce(String userName ,Booked booked);
	
	void add(String title,Integer uid,Integer type,float deal,float blance);

	List<Booked> expense(String thispage, BookedQueryVo bookedQueryVo);

	Map<String, Object> find(String username, String startTime, String endTime,
			String way);

	int checkNumber(String number);

	List<Booked> getPayManage(String thispage);
	//获取每月入款总金额
    List<String> getCount(Integer year, Integer month, Integer month1);


    List<String> getCount1(Integer year, Integer month, Integer month1);

	void update(Booked booked, String userName);
	
	List<Booked> financeQuery(String thispage, String username,
			String startTime, String endTime, String supplier,
			String orderNumber);

}
