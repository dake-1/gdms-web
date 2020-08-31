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
		//����һ����ȷ��URL
		//String url = "http://localhost:8080/gdms-web/rest/huazhao/push/goods/bytype";
		String url = "https://free-api.heweather.com/v5/weather?city=����&key=d7bd43af19c64994b62fc643e5d75272";
		//����һ��HttpClient ����ģ�������
		HttpClient client = new DefaultHttpClient();
		
		//����һ��post����
		HttpPost post= new HttpPost(url);
		
		try {
			/*JSONObject j=new JSONObject();
			j.put("gtid",1);
			String jsonstr = j.toJSONString();
			HttpEntity entity=new StringEntity(jsonstr,"UTF-8");//����һ������ʵ��
			post.setEntity(entity);//Ϊpost����ָ������ʵ��
			post.setHeader("Content-Type","application/json");*/
			HttpResponse response = client.execute(post);//ִ��post����
			HttpEntity result = response.getEntity();//��ȡ��Ӧ�е����ݽ��
			String jsonResult = EntityUtils.toString(result);//�ѽ�������ַ���
			
			System.out.println("json = "+jsonResult);
			
			/*JSONObject o = JSONObject.parseObject(jsonResult);
			JSONArray ary = o.getJSONArray("goodsModel");
			for(int i=0;i<ary.size();i++)
			{
				Object obj = ary.get(i);
				JSONObject jobj=(JSONObject) obj;
				System.out.println("��Ʒ����="+jobj.getString("name")+"    ����="+jobj.getString("area"));
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
