package com.hq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hq.pojo.Flower;
import com.hq.service.FlowerService;
import com.hq.service.impl.FlowerServiceImpl;

@WebServlet("/insert")
public class insertServlet extends HttpServlet{
	FlowerService flowerService=new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		String price=req.getParameter("price");
		String production=req.getParameter("production");
		Flower flower=new Flower(name,Double.parseDouble(price),production);
		
		int index=flowerService.add(flower);
		if (index>0) {
			resp.sendRedirect("show");
		}
		else {
			resp.sendRedirect("add.jsp");
		}
	}

}

	
