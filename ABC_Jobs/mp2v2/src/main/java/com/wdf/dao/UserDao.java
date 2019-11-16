package com.wdf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.wdf.entity.Entity;
import com.wdf.entity.User;

public class UserDao implements IDao {
	private DBManager dbManager = new DBManager();
	private Connection conn = null;

	@Override
	public int insert(Entity e) throws SQLException, ClassNotFoundException, Exception {
		int rowsInserted = -1;
		String sql;
		System.out.println("connecting to database");
		User u = (User) e;
		conn = dbManager.getConnection();
		System.out.println("Connected to database");
		// SQL script to insert record into the company table with the parameter
		// id - Is a auto increment field. It will be inserted automatically
		try {
			sql = "INSERT INTO user (firstname, lastname, email, password)" + " VALUES (?,?,?,md5(?))";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// First parameter is the first name of the user
			pstmt.setString(1, u.getFirstName());
			// Second parameter is the second name of the user
			pstmt.setString(2, u.getLastName());
			// Third parameter is the email of the user
			pstmt.setString(3, u.getEmail());
			// fourth parameter is the password of the user
			pstmt.setString(4, u.getPassword());

			// returns the number of records inserted
			rowsInserted = pstmt.executeUpdate();
			System.out.println("rowInserted");
			return rowsInserted;
			
		} catch (SQLException ex) {
			System.out.println(ex);
			ex.printStackTrace();
			return rowsInserted;
		}
		
	}

	@Override
	public int update(Entity e) throws SQLException, ClassNotFoundException, Exception {
		int rowsDeleted = -1;
		String sql;
		User u = (User) e;
		conn = dbManager.getConnection();
		sql = "DELETE FROM user WHERE userid =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// First parameter is the id of the company entity
		pstmt.setInt(1, u.getId());

		rowsDeleted = pstmt.executeUpdate();
		return rowsDeleted;
	}

	@Override
	public int delete(Entity e) throws SQLException, ClassNotFoundException, Exception {
		int rowsDeleted = -1;
		String sql;
		User u = (User) e;
		conn = dbManager.getConnection();
		sql = "DELETE FROM user WHERE userid =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// First parameter is the id of the company entity
		pstmt.setInt(1, u.getId());

		rowsDeleted = pstmt.executeUpdate();
		return rowsDeleted;
	}

	@Override
	public Entity getById(int id) throws SQLException, ClassNotFoundException, Exception {
		String sql;
		conn = dbManager.getConnection();
		sql = "SELECT * FROM user WHERE id = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		// First parameter is the id of the company entity
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();

		User u = new User();

		while (rs.next()) {

			u.setId(rs.getInt("id"));
			u.setFirstName(rs.getString("firstName"));
			u.setLastName(rs.getString("lastName"));
			u.setEmail(rs.getString("email"));
		}
		return u;
	}

	@Override
	public ArrayList<Entity> getAll() throws SQLException, ClassNotFoundException, Exception {
		String sql = "SELECT * FROM user";
		conn = dbManager.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		ArrayList<Entity> users = new ArrayList<>();
		User u;

		// Populate the array list from the records of the company table
		while (rs.next()) {
			u = new User();
			u.setId(rs.getInt("id"));
			u.setFirstName(rs.getString("firstName"));
			u.setLastName(rs.getString("lastName"));
			u.setEmail(rs.getString("email"));

			users.add(u);
		}
		return users;
	}
	
	public Entity getByEmail(String LoginEmail) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM user WHERE email = ?";
		conn = dbManager.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, LoginEmail);
		ResultSet rs = pstmt.executeQuery();
		
		User u = new User();
		while(rs.next()) {
			u.setFirstName(rs.getString("firstname"));
			u.setLastName(rs.getString("lastname"));
			u.setEmail(rs.getString("email"));
			u.setPassword(rs.getString("password"));
			u.setCode(rs.getString("code"));
		}
		return u;
	}
	
	public int updateField(String col, String s, String email) throws SQLException, ClassNotFoundException, Exception {
		int rowsDeleted = -1;
		String sql;
		conn = dbManager.getConnection();
		sql = "UPDATE user SET "+ col +" = ? WHERE email = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// First parameter is the id of the company entity
		pstmt.setString(1, s);
		pstmt.setString(2, email);

		rowsDeleted = pstmt.executeUpdate();
		return rowsDeleted;
	}

}
