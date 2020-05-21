package com.jdbc01.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.jdbc.util.ConnectionUtils;



public class Jdbc01 {
	
	private static void getEmpData() throws SQLException, IOException{
		Connection conn = null;//连接对象
		Statement stmt = null;//语句对象
		ResultSet rs = null;//结果集
		String sql = "select * from person";//查询数据库中的数据
		
		conn =  ConnectionUtils.getConnection();
		stmt =  conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			System.out.println(id+","+name+","+age);
		}
		rs.close();
		stmt.close();
		conn.close();
	}
	
	
	public static void main(String[] args) throws IOException {
			try {
				getEmpData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}




}
