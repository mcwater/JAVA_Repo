package com.hq.service.impl;

import java.util.List;

import com.hq.dao.FlowerDao;
import com.hq.dao.impl.FlowerDaoImpl;
import com.hq.pojo.Flower;
import com.hq.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{
	
	private FlowerDao flowerDao=new FlowerDaoImpl();
	@Override
	public List<Flower> show() {
		// TODO Auto-generated method stub
		
		return flowerDao.selAll();
	}
	@Override
	public int add(Flower flower) {
		return flowerDao.insFlower(flower);
		
	}

}
