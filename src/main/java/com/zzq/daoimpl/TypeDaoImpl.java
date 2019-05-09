package com.zzq.daoimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.zzq.dao.TypeDao;
import com.zzq.entity.Type;
import com.zzq.mybatis.TypeMapper;

@Repository
public class TypeDaoImpl implements TypeDao {
	@Resource
	private TypeMapper typeMapper;

	public Type selectByTypeName(String typename) {
		// TODO Auto-generated method stub
		return typeMapper.selectByTypeName(typename);
	}
	
}
