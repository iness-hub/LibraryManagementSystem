package com.inesshasnaoui.bibliotheekbeheersysteem.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectSql implements ConnectDB 
{

	private static String url = "jdbc:mysql://localhost:3306/Library";
	private static String user= "root";
	private static String password ="Mysql";

	 private  Connection connect = null;
	
	 
	 
	public ConnectSql () {
		
		
	};
	private  void connectToDb()  {
		       
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("connection is ok");
        	} catch (SQLException | ClassNotFoundException e) {
           
        	e.printStackTrace();
        }
    }

	@Override
    public PreparedStatement getPreparedStatement(String query) {
        try {
            if(this.connect == null)
                this.connectToDb();

            return this.connect.prepareStatement(query);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Statement getStatement() {
        try {
            if(this.connect == null)
                this.connectToDb();

            return this.connect.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public ResultSet selectQuery(String query) {
        try {
            Statement stmt =  getStatement();

            return  stmt.executeQuery(query);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResultSet executeQuery(String query) {
    	 PreparedStatement stmt = getPreparedStatement(query);
    	try {
           
            return stmt.executeQuery(query);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override

    public int insertQuery(String query) {
    	
    	int idRecord=0;
    	try {
        	 Statement ps =  getStatement();
        	 ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        	 ResultSet rs = ps.getGeneratedKeys();
             if(rs.next())
                   idRecord = rs.getInt(1);
  
             } catch (Exception e) {
            e.printStackTrace();
                   }
		return idRecord;
    }
    	
   
    @Override
    public int executeUpdate(String query) {
        try {
            PreparedStatement stmt = getPreparedStatement(query);

            return stmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

   
    void close() {
        try {
            this.connect.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



}
