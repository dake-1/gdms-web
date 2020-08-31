package com.uplooking.restclient.test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class CallRest {
	public void testRest() {
		//构建一个正确的URL
		//String url = "http://localhost:8080/gdms-web/rest/huazhao/push/goods/bytype";
		String url = "https://free-api.heweather.com/v5/weather?city=广州&key=d7bd43af19c64994b62fc643e5d75272";
		//构造一个HttpClient 用于模拟浏览器
		HttpClient client = new DefaultHttpClient();
		
		//构造一个post对象
		HttpPost post= new HttpPost(url);
		
		try {
			/*JSONObject j=new JSONObject();
			j.put("gtid",1);
			String jsonstr = j.toJSONString();
			HttpEntity entity=new StringEntity(jsonstr,"UTF-8");//构造一个参数实体
			post.setEntity(entity);//为post请求指定参数实体
			post.setHeader("Content-Type","application/json");*/
			HttpResponse response = client.execute(post);//执行post请求
			HttpEntity result = response.getEntity();//获取响应中的数据结果
			String jsonResult = EntityUtils.toString(result);//把结果换成字符串
			
			System.out.println("json = "+jsonResult);
			
			/*JSONObject o = JSONObject.parseObject(jsonResult);
			JSONArray ary = o.getJSONArray("goodsModel");
			for(int i=0;i<ary.size();i++)
			{
				Object obj = ary.get(i);
				JSONObject jobj=(JSONObject) obj;
				System.out.println("商品名称="+jobj.getString("name")+"    产地="+jobj.getString("area"));
			}*/
		}  catch (Exception e) {
			e.printStackTrace();
		}finally {
			post.abort();
			post.releaseConnection();
		}
	}
	public static void main(String[] args) {
		new CallRest().testRest();
	}
}
