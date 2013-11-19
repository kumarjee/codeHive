package com.kj.cloudapp.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class MySQLTest {
	
	public void closeConnection(Connection conn) throws SQLException{
		conn.close();
	}

	public Connection  getConnection() throws ClassNotFoundException, SQLException  {
		
		
		// TODO Auto-generated method stub
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver");
		return  DriverManager.getConnection("jdbc:mysql://127.1.32.1:3306/strutsQuickStart","admin", "xEihXSUbHUy");
	 
		/*try {
			
			java.sql.Statement statement = connection.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS  users "
                    +"CREATE TABLE  users ( "
                    +"name text, last_login date);" )  ;
			
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			returnvalue= "Connection failed";
		}
	 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			returnvalue= "connectionEstablished";
		} else {
			System.out.println("Failed to make connection!");
		}
		returnvalue= "null returned";

	
		return returnvalue;*/
	}
	
	public String addUser(Connection connect, String userId) {
		try{
		Statement statement = connect.createStatement();
		String preQueryStatement = "INSERT  INTO  users  VALUES  (?,?)";
	    PreparedStatement pStmnt = connect.prepareStatement(preQueryStatement);
	    pStmnt.setString(1, userId);
	    Date today = new Date();
	    java.sql.Date date = new java.sql.Date(today.getTime());
	    pStmnt.setDate(2, date);
	    pStmnt.executeUpdate();
		}
	   catch(Exception e){
		   e.printStackTrace();
		   return "error";
	   }
		return "success";
	}
	public ArrayList<Users> getUsers(Connection connect) throws SQLException{
		Statement statement = connect.createStatement();
		ResultSet rs = statement.executeQuery("select * from users");
		ArrayList<Users> list = new ArrayList<Users>();
		while(rs.next()){
			Users user = new Users();
			user.setUserName(rs.getString("name"));
			Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateS = formatter.format(rs.getDate("last_login"));
			user.setLastLogin(dateS);
			list.add(user);
		}
		return list;
	}

}
