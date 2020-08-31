package com.oracle.gdms.web.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.oracle.gdms.service.GoodsService;
import com.oracle.gdms.util.Factory;

/**
 * Servlet implementation class GoodsDelthis
 */
@WebServlet("/admin/goods/delthis.php")
public class GoodsDelthis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int goodsid = Integer.parseInt(request.getParameter("goodsid"));
		
		GoodsService service = (GoodsService)Factory.getInstance().getObject("goods.service.impl");
		int count = service.delthis(goodsid);//返回更新结果(受影响行数)
		response.setContentType("application/json;charset=utf-8");
		JSONObject j = new JSONObject();
		System.out.println("countcountcountcount" + count);
		if(count>0) {
			j.put("code",0);
			j.put("msg","删除成功");
		}else {
			j.put("code",1003);
			j.put("msg","删除失败");
		}
		response.getWriter().print(j.toJSONString());// 把JSON结果输出到客户端
	}

}
