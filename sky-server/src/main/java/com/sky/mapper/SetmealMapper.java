package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SetmealMapper {

    @Select("select * from category where id=#{id}")
    Integer countByCategoryId(Long id);


}
