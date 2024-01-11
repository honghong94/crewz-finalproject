package com.project.crewz.moim;

import com.project.crewz.common.db.vo.Moim;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MoimDao {
    @Insert("insert into moim values(#{no}, #{categoryno}, #{memberid}, #{info}, #{title}, #{content}, #{photo1}, #{photo2}, #{photo3}, default)")
    int insert(Moim moim);

    @Select("select seq_moim.nextval from dual")
    Long nextVal();

    @Select("select * from moim where no = #{no}")
    Moim select(@Param("no") Long no);
}
