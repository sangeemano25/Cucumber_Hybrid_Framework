package com.creatio.crm.framework.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DBUtil {
	
	public static Properties prop = PropUtil.readData("config.properties");
	
	//common method to connect with DB and get raw data from tables
	public static ResultSet executeQuery(String query) {
		ResultSet rs=null;
		String dbUrl=prop.getProperty("db.url");
		String dbUsername=prop.getProperty("db.userName");
		String dbPassword=prop.getProperty("db.password");
		try {
			Connection con=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			rs=con.createStatement().executeQuery(query);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		return rs;
		
	}
	
	
		
	}


