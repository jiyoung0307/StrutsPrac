package com.mytest.action02;

import com.opensymphony.xwork2.Action;
import java.sql.*;

public class StrutsJDBC implements Action{
	String url = "jdbc:mysql://localhost:3306/s2study?useSSL=false&serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    String username = "struts_prac";
    String password = "ubisso132!";
    String query = "INSERT INTO test VALUES(?, ?, ?)";
    private String message;
	public String getMessage() {
		return message;
	}
	public String execute() throws Exception {
	    Connection conn=null;
	    PreparedStatement pstmt=null;
		int val = 0;
		
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: " + e.getMessage());
			e.printStackTrace(); // 이걸 꼭 추가해야 콘솔에 진짜 오류 원인이 나옵니다
		}
	    try{
	      conn = DriverManager.getConnection(url, username, password);
	      pstmt = conn.prepareStatement(query);
		  pstmt.setString(1, "Struts 2");
		  pstmt.setString(2, "DB연동");
		  pstmt.setString(3, "테스트");
		  pstmt.executeUpdate();
		  pstmt.close();
		  conn.close();
	    }catch(Exception e){
	    	System.out.println("드라이버 로딩 오류: " + e.getMessage());
	    }
	    message = "테이블 행 등록 완료. MySQL에서 확인해주세요.";
	    return SUCCESS;
	}
}
