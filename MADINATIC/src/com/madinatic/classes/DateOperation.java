package com.madinatic.classes;

import java.util.Date;

public class DateOperation {
	
	
	
	
	public static java.sql.Date ConvertDate(Date date ) {
		
		java.sql.Date sqldate ;
		sqldate = new java.sql.Date(date.getTime());
		
		System.out.println("la date convertie : "+ sqldate.toString());
		
		return sqldate ;
	}

	public Date ConvertSqlDate(java.sql.Date sqldate) {
		java.util.Date date = null ;
		

		
		return date ;
	}
	
}
