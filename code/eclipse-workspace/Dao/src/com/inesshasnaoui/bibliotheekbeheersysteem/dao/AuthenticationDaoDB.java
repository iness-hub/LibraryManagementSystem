package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Librarian;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Member;
import com.inesshasanoui.bibliotheekbeheersysteem.model.StateUser;
import com.inesshasanoui.bibliotheekbeheersysteem.model.User;
import com.inesshasanoui.bibliotheekbeheersysteem.model.UserFactory;
import com.inesshasanoui.bibliotheekbeheersysteem.model.UserRole;
import com.inesshasanoui.bibliotheekbeheersysteem.model.UserState;



public class AuthenticationDaoDB implements AuthenticationDao {
	private ConnectDB connectDB;
	
	public AuthenticationDaoDB(ConnectDB connectDB) {
		super();
		this.connectDB = connectDB;
	}
	
	 
	@Override
	public User login(String username, String password) throws DaoException, NotFoundDaoException {
		
		String query = "SELECT * FROM USER";
		query+=" where username='"+username.toString()+"'";
		query+=	 " and password='"+password.toString()+"'";
	//	query+=	 " AND active= true";
		User user = null;
		try {
		 ResultSet rs=connectDB.selectQuery(query); 
		 user = extractUserFromResultSet(rs);
		
			
		} catch (SQLException e1) {
				throw new DaoException(ErrorsDaoException.dbDriverError.toString(),e1);
						
		}
		return user;
}
	

	
	private User extractUserFromResultSet(ResultSet rs) throws SQLException, NotFoundDaoException {

		int id;
		UserState state;
		UserRole role;
		String username;
		String password;
		String firstname;
		String lastname;
		String adres = ""; // rs.getString("adres"); moet nog ingevoerd in database
		String email;
		int tel;
		User user = null;
		try {
			if (rs.next()) {

				id = rs.getInt("id");
				state = UserState.valueOf(rs.getString("state"));
				role = UserRole.valueOf(rs.getString("role"));
				username = rs.getString("username");
				password = rs.getString("password");
				firstname = rs.getString("firstname");
				lastname = rs.getString("lastname");
				adres = ""; // rs.getString("adres");
				email = rs.getString("email");
				tel = rs.getInt("tel");
				System.out.println(role);
				user= UserFactory.getUser(id,state,role,username,password,firstname,lastname,adres,email,tel);
					
				 System.out.println(user.getUsername());
				 
			}
			else { throw new NotFoundDaoException("wrong combination password and name");}
			return user;
		} catch (SQLException ex) {
			return null;
		}
	}

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
