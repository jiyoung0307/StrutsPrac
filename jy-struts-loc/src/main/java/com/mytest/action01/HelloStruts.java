package com.mytest.action01;

import com.opensymphony.xwork2.Action;
import java.sql.*;

public class HelloStruts implements Action{
	private String message;
	public String getMessage() {
		return message;
	}
	public String execute() throws Exception {
		message = "안녕 Struts 2.0.9";
		return SUCCESS;
	}
}