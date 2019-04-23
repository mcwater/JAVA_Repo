package com.hq.service;

import java.io.IOException;

import com.hq.pojo.PageInfo;

public interface PeopleService {

	public PageInfo showPage(int pageSize,int pageNumber) throws IOException;
}
