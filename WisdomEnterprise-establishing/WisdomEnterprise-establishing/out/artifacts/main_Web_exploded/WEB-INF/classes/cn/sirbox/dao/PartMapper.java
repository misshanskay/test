package cn.sirbox.dao;

import cn.sirbox.model.Part;
import cn.sirbox.model.PartExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table part
     *
     * @mbggenerated
     */
    int countByExample(PartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table part
     *
     * @mbggenerated
     */
    int deleteByExample(PartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table part
     *
     * @mbggenerated
     */
    @Insert({
        "insert into part (pid, pname)",
        "values (#{pid,jdbcType=INTEGER}, #{pname,jdbcType=VARCHAR})"
    })
    int insert(Part record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table part
     *
     * @mbggenerated
     */
    int insertSelective(Part record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table part
     *
     * @mbggenerated
     */
    List<Part> selectByExample(PartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table part
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Part record, @Param("example") PartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table part
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Part record, @Param("example") PartExample example);
}