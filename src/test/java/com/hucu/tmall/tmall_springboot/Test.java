package com.hucu.tmall.tmall_springboot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Test {

	public static void main(String[] args) throws Exception {
		  
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
  
        try (
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tmall_springboot?characterEncoding=UTF-8",
                "root", "admin");
        )
        {
        	System.out.println("ok");
              
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		



        //redis

		
	}



}
