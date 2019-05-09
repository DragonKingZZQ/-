package com.zzq.resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzq.entity.Product;
import com.zzq.entity.Type;
import com.zzq.entity.User;
import com.zzq.service.ProductService;
import com.zzq.service.TypeService;
import com.zzq.service.UserService;

@Controller
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	@Autowired
	private TypeService typeService;
	
	@RequestMapping("/getAllPro")
	@ResponseBody
	public Map<String,Object> findAllPro(@RequestParam(required=true,defaultValue="1")Integer page,Model model) {		
		PageHelper.startPage(page, 20);
		List<Product> pros = productService.findAllPro();
		PageInfo<Product> products =new PageInfo<Product>(pros);
		
		List<Object> obj = new ArrayList<Object>();
		System.out.println("products.getList().get(i).toString()"+products.getList().get(0).toString());
		for(int i=0;i<products.getSize();i++) {
			User user = userService.getUserByOpenid(products.getList().get(i).getCast_openid());
			products.getList().get(i).setNickName(user.getNickName());
		
		}
		obj.add(products);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("values", obj);
		
		
		return map;
		
	}
	
	@RequestMapping("/release")
	@ResponseBody
	public Map<String,Integer> release(Product product) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		Type type = typeService.selectByTypeName(product.getType_name());
		product.setType_id(type.getType_id());
		int  result = productService.insertPro(product);
		if(result == 1) {
			map.put("code",1);			
		}
		else {
			map.put("code", 2);
		}
		return map;
		
	}
	
	
	@RequestMapping("/getProById")
	@ResponseBody
	public Model getProById(@RequestParam("id")int id,Model model) {
		Product pro = productService.selectProById(id);
		User user = userService.getUserByOpenid(pro.getCast_openid());
		model.addAttribute("pro", pro);
		model.addAttribute("user",user);
		return model;
		
	}
	
	@RequestMapping("/getProsByTypeid")
	@ResponseBody
	public PageInfo<Product> getProsByTypeid(@RequestParam(required=true,defaultValue="1")Integer page,
			@RequestParam("type_id")int type_id) {
		PageHelper.startPage(page, 20);
		List<Product> pros = productService.selectByTypeid(type_id);
		PageInfo<Product> products =new PageInfo<Product>(pros);
		return products;
		
	}
	
	@RequestMapping("/myRelease")
	@ResponseBody
	public List<Product> myRelease(@RequestParam("cast_openid")String cast_openid) {
		List<Product> pro = productService.selectByCastOpenid(cast_openid);
		return pro;
	}
	
	@RequestMapping("/myOrder")
	@ResponseBody
	public List<Product> myOrder(@RequestParam("receive_openid")String receive_openid) {
		List<Product> pro = productService.selectByReceiveOpenid(receive_openid);
		return pro;
	}
	
	@RequestMapping("/Receive")
	@ResponseBody
	public Map<String,Integer> Receive(Product pro){ 
		Map<String,Integer> map = new HashMap<String,Integer>();
		int i = productService.insertRelease(pro);
		if(i==1) {
			map.put("code",1);
		}else {
			map.put("code",0);
		}
		return map;
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public List<Product> search(@RequestParam("title")String title) {
		List<Product> pro = productService.searchTitle(title);
		return pro;
		
	}
	
	@RequestMapping("/authorize")
	@ResponseBody
	public Map<String,String> authorize(@RequestParam("js_code")String js_code){		
		Map<String,String> map = new HashMap<String,String>();
		String appid = "wx04d0c32f8ae0c8ac";
		String secret = "a8a232608b906499d30c0f0dece94ec2";
		String url="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+js_code+"&grant_type=authorization_code";

		String result = getUrl(url);
		map.put("openid", result);
		System.out.println(result+"result");
		return map;
	}

	private String getUrl(String url) {
		//实例化httpclient  
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        //实例化get方法  
        HttpGet httpget = new HttpGet(url);   
        //请求结果  
        CloseableHttpResponse response = null;  
        String content = "";
          
        try {  
            //执行get方法  
            response = httpclient.execute(httpget);  
            if(response.getStatusLine().getStatusCode()==200){            	
            	content = EntityUtils.toString(response.getEntity(),"utf-8");  
            	System.out.println(content+"content");
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return content; 
	}
	
}
