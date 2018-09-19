package kr.itedu.boardmvc.common;

import javax.naming.*;
import java.sql.*;
import javax.sql.*;



public class DBManager {
   
	public static Connection getConnect() throws SQLException{
		Connection conn = null;
		try {
		
		Context init = new InitialContext();
		DataSource ds =(DataSource)init.lookup("java:comp/env/oracleDB");
		  conn = ds.getConnection();
		  if(conn != null) {
			  System.out.println("DB연결 ok");
		  }else {
			  System.out.println("DB연결 실패");
		  }	
		}
		  catch(NamingException e) {
				e.printStackTrace();
			}
		return conn;
		
	}
	 
	
	private static void close(Connection conn, PreparedStatement ps)
	{
		try {
		
			if(ps !=null)
			{
			 ps.close();
			}
			if(conn !=null)
			{
			 conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void close(Connection conn, PreparedStatement ps,ResultSet rs)
	{	
		try {
			if(rs !=null)
			{
			 rs.close();
			}
			if(ps !=null)
			{
			 ps.close();
			}
			if(conn !=null)
			{
			 conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection c) {
		
		  close(c,null,null);
	}
	public static void close(PreparedStatement p) {
	
		  close(null,p,null);
    }	
	public static void close(ResultSet r) {
		
		  close(null,null,r);
    }
	public static void close(PreparedStatement p,ResultSet r) {
		
		  close(null,p,r);
  }	
}
