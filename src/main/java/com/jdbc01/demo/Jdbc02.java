package com.jdbc01.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.jdbc.util.ConnectionUtils;



public class Jdbc02 {
	
	
	private static boolean addPerson(int id, String name, int age) throws SQLException, IOException {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = ConnectionUtils.getConnection();
		String sql = "insert into person values(?,?,?)";//增加一行新数据
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, id);
		pstmt.setObject(2, name);
		pstmt.setObject(3, age);
		int n = pstmt.executeUpdate();
		if(n == 1) {
			flag = true;
		}
		pstmt.close();
		conn.close();
		return flag;
	}
	
	private static boolean deletePerson(int id) throws SQLException, IOException {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = ConnectionUtils.getConnection();
		String sql = "delete from person where id=?";//删除某一行数据
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, id);
		int n = pstmt.executeUpdate();
		if(n == 1) {
			flag = true;
		}
		pstmt.close();
		conn.close();
		return flag;
	}

	private static boolean updatePerson(String name, int id) throws SQLException, IOException {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = ConnectionUtils.getConnection();
		String sql = "update person set name=? where id=?";//修改某一个或多个数据
		pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, name);	
		pstmt.setObject(2, id);
		int n = pstmt.executeUpdate();
		if(n == 1) {
			flag = true;
		}
		pstmt.close();
		conn.close();
		return flag;
	}
	
	public static void main(String[] args) throws IOException, SQLException {		
		boolean addBool = addPerson(6,"mao",23);
		boolean deleteBool = deletePerson(6);
		boolean updateBool = updatePerson("郑晓军",1);
		System.out.println(addBool);
		System.out.println(deleteBool);
		System.out.println(updateBool);
	}



}
