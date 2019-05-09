package com.zzq.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzq.dao.ProductDao;
import com.zzq.entity.Product;
import com.zzq.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	public List<Product> findAllPro() {
		
		return productDao.findAllPro();
	}

	public Product selectProById(int id) {
		
		return productDao.selectProById(id);
	}

	public List<Product> selectByTypeid(int type_id) {
		
		return productDao.selectByTypeid(type_id);
	}

	public int insertPro(Product pro) {
		// TODO Auto-generated method stub
		return productDao.insertPro(pro);
	}

	public List<Product> selectByCastOpenid(String cast_openid) {
		// TODO Auto-generated method stub
		return productDao.selectByCastOpenid(cast_openid);
	}

	public List<Product> selectByReceiveOpenid(String receive_openid) {
		// TODO Auto-generated method stub
		return productDao.selectByReceiveOpenid(receive_openid);
	}

	public int insertRelease(Product pro) {
		// TODO Auto-generated method stub
		return productDao.insertRelease(pro);
	}

	public List<Product> searchTitle(String title) {
		// TODO Auto-generated method stub
		return productDao.searchTitle(title);
	}
	
	
}
