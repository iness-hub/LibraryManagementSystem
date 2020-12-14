package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public interface ConnectDB {
	 // Execute a command
   ResultSet executeQuery(String query);
   int insertQuery(String query);
   int executeUpdate(String query);
   ResultSet selectQuery(String query);
   // get statement
//   Statement getStatement(String stmt);
   Statement getStatement();
   PreparedStatement getPreparedStatement(String stmt);
}