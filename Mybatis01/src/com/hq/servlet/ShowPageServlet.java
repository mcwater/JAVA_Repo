package com.hq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hq.pojo.PageInfo;
import com.hq.service.PeopleService;
import com.hq.service.impl.PeopleServiceImpl;

@WebServlet("/page")
public class ShowPageServlet extends HttpServlet{

	private PeopleService peopleService=new PeopleServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageSizeString=req.getParameter("pageSize");
		String pageNumberString=req.getParameter("pageNumber");
		int pageSize =2;
		int pageNumber =1;
		if(pageSizeString!=null&&!pageSizeString.equals("")) {
			pageSize=Integer.parseInt(pageSizeString);
		}
		if(pageNumberString!=null&&!pageNumberString.equals("")) {
			pageNumber=Integer.parseInt(pageNumberString);
		}
		PageInfo piInfo=peopleService.showPage(pageSize, pageNumber);
		req.setAttribute("PageInfo", piInfo);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
