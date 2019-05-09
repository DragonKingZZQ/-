package com.zzq.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzq.entity.Product;

public interface ProductMapper {
	//查询所有的产品
	List<Product> selectAllPro();
	
	//根据id查询商品
	Product selectProById(@Param("id")int id);
	
	//根据产品类型查询产品
	List<Product> selectByTypeid(@Param("type_id")int type_id);
	
	//发布商品时进行插入
	int insertPro(@Param("pro")Product pro);
	
	//我的发布
	List<Product> selectByCastOpenid(@Param("cast_openid")String cast_openid);
	
	//我的订单
	List<Product> selectByReceiveOpenid(@Param("receive_openid")String receive_openid);

	//接收订单时更新
	int insertRelease(@Param("pro")Product pro);
	
	List<Product> searchTitle(@Param("title")String title);
}
