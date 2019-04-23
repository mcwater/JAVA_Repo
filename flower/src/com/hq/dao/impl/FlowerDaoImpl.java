package com.hq.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hq.dao.FlowerDao;
import com.hq.pojo.Flower;

public class FlowerDaoImpl implements FlowerDao{

	@Override
	public List<Flower> selAll() {
		List<Flower> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://39.106.94.140:32768/ssm?characterEncoding=utf-8","root","123456");
			ps=conn.prepareStatement("select * from flower");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Flower(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4)));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public int insFlower(Flower flower) {
		int rows=0;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://39.106.94.140:32768/ssm","root","123456");
			ps=conn.prepareStatement("insert  into flower values(default,?,?,?)");
			ps.setObject(1, flower.getName());
			ps.setObject(2, flower.getPrice());
			ps.setObject(3, flower.getProduction());
			rows=ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rows;
	}
	
}
