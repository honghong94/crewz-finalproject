package com.project.crewz.local;

import com.project.crewz.common.db.vo.Local;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LocalDao {
    @Select("select * from local where no >= #{min} and no <= #{max}")
    List<Local> selectAllByNo(@Param("min") int min, @Param("max") int max);
}
