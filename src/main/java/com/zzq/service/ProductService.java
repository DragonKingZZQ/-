package com.zzq.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzq.entity.Product;

public interface ProductService {

	List<Product> findAllPro();
	
	Product selectProById(int id);
	
	List<Product> selectByTypeid(int type_id);
	
	int insertPro(@Param("pro")Product pro);
	
	//我的发布
	List<Product> selectByCastOpenid(@Param("cast_openid")String cast_openid);
	
	//我的订单
	List<Product> selectByReceiveOpenid(@Param("receive_openid")String receive_openid);

	//接收订单时更新
	int insertRelease(@Param("pro")Product pro);
	
	List<Product> searchTitle(String title);

}
