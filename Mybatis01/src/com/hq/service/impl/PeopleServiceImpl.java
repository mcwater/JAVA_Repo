package com.hq.service.impl;



import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hq.pojo.PageInfo;
import com.hq.service.PeopleService;

public class PeopleServiceImpl implements PeopleService{

	@Override
	public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
		InputStream iStream=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(iStream);
		SqlSession session=factory.openSession();
		PageInfo pInfo=new PageInfo();
		pInfo.setPageNumber(pageNumber);
		pInfo.setPageSize(pageSize);
		Map<String, Object> map=new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize",pageSize);
		pInfo.setList(session.selectList("com.hq.mapper.PeopleMapper.selByPage",map));
		
		long count=session.selectOne("com.hq.mapper.PeopleMapper.selCount");
		pInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		// TODO Auto-generated method stub
		return pInfo;
	}

}
