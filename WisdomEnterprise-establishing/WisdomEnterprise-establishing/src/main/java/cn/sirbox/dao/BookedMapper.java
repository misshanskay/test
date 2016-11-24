package cn.sirbox.dao;

import cn.sirbox.model.Booked;
import cn.sirbox.model.BookedExample;
import cn.sirbox.model.BookedQueryVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BookedMapper {
    int countByExample(BookedExample example);

    int deleteByExample(BookedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Booked record);

    int insertSelective(Booked record);

    List<Booked> selectByExample(BookedExample example);

    Booked selectByPrimaryKey(Integer id);
    
    Booked selectByPrimaryKeys(Booked record);

    int updateByExampleSelective(@Param("record") Booked record, @Param("example") BookedExample example);

    int updateByExample(@Param("record") Booked record, @Param("example") BookedExample example);

    int updateByPrimaryKeySelective(Booked record);

    int updateByPrimaryKey(Booked record);

	List<Booked> selectByExamples(Map map);

	List<Booked> find(BookedQueryVo bookedQueryVo);

	Integer selectByNumber(String number);

	int updateByPrimaryKeySelectives(Booked booked);

	List<Booked> getPayManage(BookedExample bookedExample);

    Integer getCountDeposit(@Param("time")Date time, @Param("time2")Date time2);

    Integer getCountExpend(@Param("time")Date time, @Param("time2")Date time2);
}