package com.hq.dao;

import java.util.List;

import com.hq.pojo.Flower;

public interface FlowerDao {
	List<Flower> selAll();
	int insFlower(Flower flower);
}
