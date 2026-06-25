package com.creatio.crm.framework.db.commons;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.creatio.crm.framework.utilities.DBUtil;

public class DBCommons {
	
	//common method to convert raw data into list of maps
		public static List<Map<String,String>> getData(String query) throws SQLException{
			
			//create empty list of maps to hold data
			List<Map<String,String>> data= new ArrayList<Map<String,String>>();
			
			//get raw data from db
			ResultSet rs=DBUtil.executeQuery(query);
			
			//convert raw data into list of maps--each row in one map each
			while(rs.next()) {   //check if next row available
				
				//create an empty map for each and every row
				Map<String,String> rowData=new HashMap<String, String>();
				
				//convert resultset into map
				for(int c=1;c<= rs.getMetaData().getColumnCount();c++) {
					String ColName= rs.getMetaData().getColumnName(c);
					String ColValue= rs.getString(c);
					rowData.put(ColName,ColValue); //put col name and value into map
				}
				
				//add map into list
				data.add(rowData);
			}		
			return data;
			}

}
