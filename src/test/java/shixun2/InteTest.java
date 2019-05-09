package shixun2;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import com.zzq.entity.Product;


public class InteTest {
	
	@Test
	public void MybatisTest() {
		SqlSessionFactory sqlSessionFactory = null;
		InputStream input = null;
		SqlSession session = null;
		
	//创建sqlSessionFactory
    try {
    	
    	input = Resources.getResourceAsStream("testmybatis.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
		
	} catch (IOException e) {
		e.printStackTrace();
	}
    
   //得到SqlSession对象,执行查询操作
    try{
    	session  = sqlSessionFactory.openSession();
	    List<Product> pros =  session.selectList("com.zzq.mybatis.ProductMapper.selectAllPro");
	    for(Product pro:pros) {
	    	System.out.println("数据："+pro.toString());
	    }
    }finally{
    	session.close();
    	try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}

}
