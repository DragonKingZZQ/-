package com.zzq.mybatis;

import org.apache.ibatis.annotations.Param;

import com.zzq.entity.Type;

public interface TypeMapper {
	Type selectByTypeName(@Param("typename")String typename);

}
