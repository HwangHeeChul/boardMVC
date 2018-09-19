package kr.itedu.boardmvc;

import java.sql.Timestamp;

public class BoardVO {
   private int bid;
   private String btitle;
   private String bcontent;
   private String bregdate;
   
    public BoardVO(int _bid, String _btitle, String _bcontent,String _bregdate) {
    	  this.bid = _bid;
    	  this.btitle = _btitle;
    	  this.bcontent = _bcontent;
    	  this.bregdate = _bregdate;
    	
    }
   
    public BoardVO() {
  	
  	
  }


public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public String getBtitle() {
	return btitle;
}
public void setBtitle(String btitle) {
	this.btitle = btitle;
}
public String getBcontent() {
	return bcontent;
}
public void setBcontent(String bcontent) {
	this.bcontent = bcontent;
}
public String getBregdate() {
	return bregdate;
}
public void setBregdate(String bregdate) {
	this.bregdate = bregdate;
}
   
   
	
	
	
}
