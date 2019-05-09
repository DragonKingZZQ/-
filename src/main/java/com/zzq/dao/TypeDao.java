package com.zzq.dao;


import com.zzq.entity.Type;

public interface TypeDao {
	Type selectByTypeName(String typename);
}
