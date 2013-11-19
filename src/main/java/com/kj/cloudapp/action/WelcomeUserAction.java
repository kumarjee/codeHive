package com.kj.cloudapp.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kj.cloudapp.dao.MySQLTest;
import com.kj.cloudapp.dao.Users;

public class WelcomeUserAction{
	 
	private String username;
	
	private String daoMessage;
	
	private ArrayList<Users>list;
	
	
	
 
	public ArrayList<Users> getList() {
		return list;
	}

	public void setList(ArrayList<Users> list) {
		this.list = list;
	}

	public String getDaoMessage() {
		return daoMessage;
	}

	public void setDaoMessage(String daoMessage) {
		this.daoMessage = daoMessage;
	}

	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	// all struts logic here
	public String execute() {
		MySQLTest test = new MySQLTest();
		Connection connect = null;
		try {
			connect = test.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(connect != null){
		test.addUser(connect, this.username);
		
		}
		try {
			this.list= test.getUsers(connect);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			test.closeConnection(connect);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "SUCCESS";
 
	}
}