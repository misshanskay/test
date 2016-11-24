package cn.sirbox.dao;

import cn.sirbox.model.Matchs;
import cn.sirbox.model.MatchsExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MatchsMapper {
    int countByExample(MatchsExample example);

    int deleteByExample(MatchsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Matchs record);

    int insertSelective(Matchs record);

    List<Matchs> selectByExampleWithBLOBs(MatchsExample example);

    List<Matchs> selectByExample();

    Matchs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Matchs record, @Param("example") MatchsExample example);

    int updateByExampleWithBLOBs(@Param("record") Matchs record, @Param("example") MatchsExample example);

    int updateByExample(@Param("record") Matchs record, @Param("example") MatchsExample example);

    int updateByPrimaryKeySelective(Matchs record);

    int updateByPrimaryKeyWithBLOBs(Matchs record);

    int updateByPrimaryKey(Matchs record);
    
    List<Matchs> selectByIdOrAll(Map map);

	void updateById(Map map);
}