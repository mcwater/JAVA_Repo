package com.hq.service;

import java.util.List;

import com.hq.pojo.Flower;

public interface FlowerService {
	public List<Flower> show();
	/**
	 * Add
	 * @param flower
	 * @return
	 */
	int add(Flower flower);
}
