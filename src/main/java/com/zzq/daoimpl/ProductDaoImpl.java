package com.zzq.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.zzq.dao.ProductDao;
import com.zzq.entity.Product;
import com.zzq.mybatis.ProductMapper;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Resource
	private ProductMapper productMapper;
	
	
	public List<Product> findAllPro() {
		
		return productMapper.selectAllPro();
	}

	public Product selectProById(int id) {
		
		return productMapper.selectProById(id);
	}

	public List<Product> selectByTypeid(int type_id) {
		
		return productMapper.selectByTypeid(type_id);
	}

	public int insertPro(Product pro) {
		
		return productMapper.insertPro(pro);
	}

	public List<Product> selectByCastOpenid(String cast_openid) {
		// TODO Auto-generated method stub
		return productMapper.selectByCastOpenid(cast_openid);
	}

	public List<Product> selectByReceiveOpenid(String receive_openid) {
		// TODO Auto-generated method stub
		return productMapper.selectByReceiveOpenid(receive_openid);
	}

	public int insertRelease(Product pro) {
		// TODO Auto-generated method stub
		return productMapper.insertRelease(pro);
	}

	public List<Product> searchTitle(String title) {
		// TODO Auto-generated method stub
		return productMapper.searchTitle(title);
	}
	
	
}
