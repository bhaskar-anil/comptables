package com.bhaskar.tabcom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class TableMetadata {

	static DBConfig db = new DBConfig();
	
	public List<String[]> getTableMetadata(String table){
		List<String[]> colMetadataList = new ArrayList<String[]>();
		Connection con = (Connection) db.getConnection();
		String sql = "SELECT * FROM " + table + " LIMIT 1";
		Statement stm;
		try {
			stm = (Statement) con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
			int noOfColumns = md.getColumnCount();			
			
			for(int i = 1; i <= noOfColumns; i++){
				String[] colMetadata = new String[3];
				//System.out.println(md.getColumnName(i)+md.getColumnTypeName(i)+md.getColumnDisplaySize(i));
				colMetadata[0] = md.getColumnName(i);
				colMetadata[1] = md.getColumnTypeName(i);
				colMetadata[2] = Integer.toString(md.getColumnDisplaySize(i));
				
				colMetadataList.add(colMetadata);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return colMetadataList;
	}

}
