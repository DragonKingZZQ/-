package com.zzq.serviceimpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzq.dao.TypeDao;
import com.zzq.entity.Type;
import com.zzq.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {
	
	@Autowired
	private TypeDao typeDao;

	public Type selectByTypeName(String typename) {
		// TODO Auto-generated method stub
		return typeDao.selectByTypeName(typename);
	}

	
	
	
	
}
