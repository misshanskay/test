package cn.sirbox.dao;

import cn.sirbox.model.Notice;
import cn.sirbox.model.NoticeExample;


import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {
	
    int getNoticeCount();

    int deleteByExample(NoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExampleWithBLOBs(NoticeExample example);

    List<Notice> selectByExample(Notice notice);

    Notice selectByPrimaryKey(Integer id);
    
    Notice getOrderNum();
    
    List<Notice> selectByPrimaryKeys();

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);
}