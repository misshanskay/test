package cn.sirbox.dao;

import cn.sirbox.model.Releaseinfo;
import cn.sirbox.model.ReleaseinfoExample;

import java.util.List;
import java.util.Map;

public interface ReleaseinfoMapper {
	
	 int countByExample(ReleaseinfoExample example);

    int deleteByExample(ReleaseinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Releaseinfo record);

    int insertSelective(Releaseinfo record);

    List<Releaseinfo> selectByExampleWithBLOBs(ReleaseinfoExample example);

    List<Releaseinfo> selectByExample(ReleaseinfoExample example);

    Releaseinfo selectByPrimaryKey(Integer id);

    /* int updateByExampleSelective(@Param("record") ReleaseinfoWithBLOBs record, @Param("example") ReleaseinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") ReleaseinfoWithBLOBs record, @Param("example") ReleaseinfoExample example);

    int updateByExample(@Param("record") Releaseinfo record, @Param("example") ReleaseinfoExample example);
*/
    int updateByPrimaryKeySelective(Releaseinfo record);

  /*  int updateByPrimaryKeyWithBLOBs(ReleaseinfoWithBLOBs record);*/

    int updateByPrimaryKey(Releaseinfo record);
    
    int updateByPrimaryKeys(Map map);

	List<Releaseinfo> selectByCondition(Map<String, Object> map);

	List<Releaseinfo> exportData(Map<String, Object> map);
}