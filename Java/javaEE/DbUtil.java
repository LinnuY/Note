package com.kzw.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
	
	private static String url;
	private static String username;
	private static String password;
	
	// 线程局部变量：每个线程的变量值是不一样的（通过set()/get()进行读写）
	private static ThreadLocal<Connection> conn = new ThreadLocal<>();
	
	static {
		try {
			InputStream is = DbUtil.class.getResourceAsStream("/jdbc.properties");
			Properties prop = new Properties();
			prop.load(is);
			
			String driver = prop.getProperty("jdbc.driver");
			Class.forName(driver);
			
			url = prop.getProperty("jdbc.url");
			username = prop.getProperty("jdbc.username");
			password = prop.getProperty("jdbc.password");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得连接对象Connection, 线程不安全
	 * 但尽可能复用该对象，在同一个线程中共享
	 * java web中，每个请求都是一个线程处理
	 * 	线程局部变量：ThreadLocal
	 * */
	public static Connection getConn() throws SQLException {
		// 先从当前线程中获得连接对象，如果没有则打开一个新的连接并将它放到线程中
		Connection c = conn.get();
		if(c==null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
			conn.set(c);
		}
		return c;
	}
	
	/**
	 * 关闭当前线程中的连接对象
	 * */
	public static void closeConn() throws Exception {
		Connection c = conn.get();
		conn.set(null);
		
		if(c!=null && !c.isClosed()) {
			c.close();
		}
	}
	
}
