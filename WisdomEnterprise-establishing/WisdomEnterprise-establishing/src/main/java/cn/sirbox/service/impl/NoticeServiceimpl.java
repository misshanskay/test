package cn.sirbox.service.impl;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 公告发布的实现类
 * @author  hwc
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.sirbox.dao.NoticeMapper;
import cn.sirbox.model.Notice;
import cn.sirbox.model.NoticeExample;
import cn.sirbox.model.NoticeExample.Criteria;
import cn.sirbox.model.UserU;
import cn.sirbox.model.page;
import cn.sirbox.service.NoticeService;
@Service
public class NoticeServiceimpl implements NoticeService{
	
	@Autowired
	private NoticeMapper noticeMapper;
	//查询所有
	public List<Notice> findAll(String thispage) throws Exception {
		
		page page = new page();
		page.setThispage(Integer.parseInt(thispage));
		PageHelper.startPage(page.getStartPos(), page.getPagenumber());
		return noticeMapper.selectByPrimaryKeys();
	}
	
	//根据id删除公告
	public void delete(Integer id) throws Exception {
		
		noticeMapper.deleteByPrimaryKey(id);
	}
	
	//更新公告
	public void update(Notice notice) throws Exception {
		
		noticeMapper.updateByPrimaryKeySelective(notice);
	}
	
	//新增公告
	@SuppressWarnings("unused")
	public void add(Notice notice,HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		UserU userU = (UserU) session.getAttribute("userU");
		notice.setMemberName(userU.getUname());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		notice.setCreateTime(sdf.format(new Date()));
		Notice notices = new Notice();
		notices = noticeMapper.getOrderNum();
		if(notices!=null){
			notice.setOrderNum((notices.getOrderNum()+1));
		}else{
			notice.setOrderNum(1);
		}
		noticeMapper.insertSelective(notice);
	}
	
	//根据条件查询公告
	public List<Notice> findByCondition(Notice notice,String thispage) throws Exception {
		
		if(notice!=null){
			if(notice.getTitle()!=null&&!"".equals(notice.getTitle())){
				notice.setTitle("%"+notice.getTitle()+"%");
			}

			if(notice.getContent()!=null&&!"".equals(notice.getContent())){
				notice.setContent("%"+notice.getContent()+"%");
			}			
		}
		return noticeMapper.selectByExample(notice);
		
	}
	
	//根据id查询公告
	public Notice findById(Integer id) throws Exception {
		
		return noticeMapper.selectByPrimaryKey(id);
	}
	
	//获取当前做大排序号
	public Notice findMaxOrderNum() throws Exception {
		
		return noticeMapper.getOrderNum();
	}
	
	//获取总的记录数
	public Integer getNoticeCount() {
		
		return noticeMapper.getNoticeCount();
	}

}
