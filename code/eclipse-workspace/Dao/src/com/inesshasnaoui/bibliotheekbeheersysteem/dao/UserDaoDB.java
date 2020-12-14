package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Librarian;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Loan;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Member;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Person;
import com.inesshasanoui.bibliotheekbeheersysteem.model.User;
import com.inesshasanoui.bibliotheekbeheersysteem.model.UserFactory;
import com.inesshasanoui.bibliotheekbeheersysteem.model.UserRole;
import com.inesshasanoui.bibliotheekbeheersysteem.model.UserState;



public class UserDaoDB implements UserDao {
	private ConnectDB connectDB;

	public UserDaoDB(ConnectDB connectDB) {
		this.connectDB = connectDB;
	}

	@Override
	public User insert(User user) {
		int userId = 0;
		String query = "INSERT INTO user";
		query += "(state,role,username,password,firstname,lastname,email,tel)";
		query += "VALUE ('"+user.getState()+"','"+UserFactory.getRoleUser(user).toString()+"','" + user.getUsername() + "','" + user.getPassword() + "','" + user.getPerson().getFirstname() + "','"
				+ user.getPerson().getLastname() + "','" + user.getPerson().getEmail() + "',NULL)";
		userId = connectDB.insertQuery(query);
		System.out.println("A new user was inserted successfully!" + userId);
		user.setId(userId);
		System.out.println("add User");
		System.out.println(user.getId());
		return user;
	}

	@Override
	public User update(User user) {
		System.out.print("updATEdaoDB"+ "" + user.getState().toString());
		String query = "UPDATE user SET firstname='" + user.getPerson().getFirstname().toString() + "'";
		query += ",lastname='" + user.getPerson().getLastname().toString() + "'";
		query += ",username='" + user.getUsername().toString() + "'";
		query += ",password='" + user.getPassword().toString() + "'";
	//	query += ",adres='" + user.getPerson().getAdres().toString() + "'";
		query += ",email='" + user.getPerson().getEmail().toString() + "'";
		query += ",tel='" + user.getPerson().getTel() + "'";
		query += ",state='" + UserState.valueOf(user.getState().toString()) + "'";
		query += "WHERE id='" + user.getId() + "'";
		connectDB.executeUpdate(query);
		return user;
	}

	@Override
	public boolean delete(User user) {
		String query = "DELETE FROM user WHERE id =" + user.getId() + " ";
		int t = connectDB.executeUpdate(query);
		if (t >= 1)
			System.out.println("A new user was deleted successfully!" + user.getId());
		else
			System.out.println("User" + user.getId() + " not deleted successfully!");

		return (t >= 1);
	}

	@Override
	public User get(long id) {
		String query = "SELECT * FROM user WHERE id =" + id + " ";
		ResultSet rs = connectDB.selectQuery(query);
		User user = null;
		try {
			user = extractUserFromResultSet(rs);
			} catch (SQLException e) {
			System.out.println("user doesn't exist");
			e.printStackTrace();
		}
				
		return user;
	}

	@Override
	public List<User> getAll() {
		String query = "SELECT * FROM user";
		ResultSet rs = connectDB.selectQuery(query);
		List<User> list = new ArrayList<>();
		try {
			list = extractListUserFromResultSet(rs);
			} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	private List<User> extractListUserFromResultSet(ResultSet rs) throws SQLException {
		List<User> list = new ArrayList<>();
		
		int id;
		
		UserState state;
		UserRole role;
		String username; 
		String password; 
		String firstname; 
		String lastname; 
		String adres=""; //rs.getString("adres"); moet nog ingevoerd in database
		String email;
		int tel;
		User user = null;
		
		try {
			while (rs.next()) {
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
				user= UserFactory.getUser(id,state,role,username,password,firstname,lastname,adres,email,tel);
				list.add(user);
			}
			return list;
		} catch (SQLException ex) {
			return null;
		}

	}

	private User extractUserFromResultSet(ResultSet rs) throws SQLException {

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
				
				user= UserFactory.getUser(id,state,role,username,password,firstname,lastname,adres,email,tel);
				}
			return user;
		} catch (SQLException ex) {
			return null;
		}
	}
	
	@Override
	public User get(String firstname, String lastname) {
		
		String query = "SELECT * FROM user WHERE firstname ='"+ firstname +"')";
		query+=", lastname ='"+lastname+"')";
				
		ResultSet rs = connectDB.selectQuery(query);
		User user = null;
		try {
			user = extractUserFromResultSet(rs);
			System.out.println(user.toString());
		} catch (SQLException e) {
			System.out.println("user bestaat niet");
			e.printStackTrace();
		}				
		return user;
		}

}
