package com.jdbc01.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Jdbc04 {
	private static String url;
	private static String dbUser;
	private static String dbPassword;
	public static void main(String[] args) {
		//�����û�id���û������ж��û��Ƿ����
		//���ڷ���true�����򷵻�false
		Scanner sc = new Scanner(System.in);
		System.out.print("�������˺�:");
		String id = sc.next();
		System.out.print("����������:");
		String pwd = sc.next();
		boolean bool = login(id,pwd);
		System.out.println(bool);
	}
	private static boolean login(String id, String pwd) {
		boolean flag = false;
		Properties props = new Properties();//1.���������ļ�����
		File file = new File("src/main/resources/pro.properties");//2.����File����
		try {
			FileInputStream fileInputStream
				= new FileInputStream(file);//3.�ļ�����������
			try {
				props.load(fileInputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//4.�����ļ��������ָ�����ļ�����
			url = props.getProperty("url");
			dbUser = props.getProperty("username");
			dbPassword = props.getProperty("password");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;//���Ӷ���
		//Statement stmt = null;//������
		PreparedStatement pstmt = null;
		//String sql = "select * from login where id='"+name+"' and password='"+id+"'";
		try {
			conn = DriverManager.getConnection(url,dbUser,dbPassword);
			String sql = "select * from login where id = ? and pwd= ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			pstmt.setObject(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				flag = true;
				String user = rs.getString("name");
				System.out.println(user+",��ӭ��¼");
			}
			else
				System.out.println("�û������벻��ȷ���û������ڣ�");
		}catch (SQLException e) {
			e.getStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
}
