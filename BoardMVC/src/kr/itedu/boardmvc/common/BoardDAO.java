package kr.itedu.boardmvc.common;

import static  kr.itedu.boardmvc.common.DBManager.getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.itedu.boardmvc.BoardVO;

public class BoardDAO {
	private static BoardDAO dao;
	
	
	
	private BoardDAO() { //privete 생성자
		
	} 
	     
	public static BoardDAO getInstance() { //싱글톤 패턴
		 if(dao == null) {
			    dao = new BoardDAO();
		 }
	     return dao;
	}
	public ArrayList<BoardVO> getBoardList(int btype){
		
		 ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		  
		 PreparedStatement ps = null;
		 Connection conn = null;
		 ResultSet rs = null;
		 
		 String query = String.format(" select bid, btitle, " 
		                             + 
		                             " to_char(bregdate,'YYYY-MM-DD hh24:mi') as bregdate, " +		 
                                     " bcontent " +
		                             " from t_board%d",btype);
      
		 try {
		      conn = getConnect();
		      ps = conn.prepareStatement(query);
		      rs = ps.executeQuery();
		    	  
		    	  while(rs.next()) {
		    	  
		    		  int bid = rs.getInt("bid");
		    		  String btitle = rs.getString("btitle");
		    		  String bcontent = rs.getString("bcontent");
		    		  String bregdate = rs.getString("bregdate");
		    		
		    		  BoardVO board = new BoardVO(bid,btitle,bcontent,bregdate);
		    		  
		    		  result.add(board);	    		   
		    	  }
		    	     	     	  
		      }catch(SQLException e) {
		    	  System.out.println("zz");
					e.printStackTrace();		
				}catch(Exception e) {
					e.printStackTrace();
				}
		      finally {
		    	  
		    	  
		    	  DBManager.close(conn,ps,rs);
		      }
		      return result;
	 }
}
	
	
	

