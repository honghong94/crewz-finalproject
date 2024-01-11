package com.project.crewz.index;

import com.project.crewz.common.db.vo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface IndexDao {
    /**
     * INSERT
     */
    @Insert("insert into category values(#{no}, #{name}, #{photo}, default)")
    int insert(Category category);

    /**
     * 시퀀스 값
     */
    @Select("select seq_category.nextval from dual")
    Long nextVal();

    /**
     * SELECT: 특정(no) 카테고리에 대한 정보
     */
    @Select("select * from category where no = #{no}")
    Category select(@Param("no") Long no);

    @Select("select * from category order by no asc")
    ArrayList<Category> selectAll();
}
