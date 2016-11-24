package cn.sirbox.service;
/**
 * 公告发布的接口类
 * @author  hwc
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.sirbox.model.Notice;



public interface NoticeService {
	
	//查询所有的公告
	public List<Notice> findAll(String thispage) throws Exception;
	
	//根据id删除公告
	public void delete(Integer id) throws Exception;
	
	//根据id更新公告
	public void update(Notice notice) throws Exception;
	
	//新增公告
	public void add(Notice notice,HttpServletRequest request) throws Exception;
	
	//根据条件查询
	public List<Notice> findByCondition(Notice notice,String thispage) throws Exception;
	
	//根据id查询公告
	public Notice findById(Integer id) throws Exception;
		
	//获取当前最大排序号
	public Notice findMaxOrderNum() throws Exception;
	
	//获取总的记录数
	public Integer getNoticeCount();
}
