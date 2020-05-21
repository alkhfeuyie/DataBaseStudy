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
import java.util.Scanner;

public class Jdbc03 {
	private static String url;
	private static String dbUser;
	private static String dbPassword;
	public static void main(String[] args) {
		//�����û�id���û������ж��û��Ƿ����
		//���ڷ���true�����򷵻�false
		Scanner sc = new Scanner(System.in);
		System.out.print("�������˺�:");
		String name = sc.next();
		System.out.print("����������:");
		String id = sc.next();
		boolean bool = login(name,id);
		System.out.println(bool);
	}
	private static boolean login(String name, String id) {
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
		Statement stmt = null;//������
		ResultSet rs = null;//�����
		String sql = "select * from login where id='"+name+"' and pwd='"+id+"'";
		try {
			conn = DriverManager.getConnection(url,dbUser,dbPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
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
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				stmt.close();
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
