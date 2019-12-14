package com.wdf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wdf.entity.Entity;
import com.wdf.entity.Profile;
import com.wdf.entity.User;

public class ProfileDao implements IDao {
	Connection conn = null;
	DBManager dbManager = new DBManager();

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
			throw new Exception(ex);
		}

	}

	@Override
	public int update(Entity e) throws SQLException, ClassNotFoundException, Exception {
		int rowsUpdated = -1;
		Profile p = (Profile) e;
		String sql;
		conn = dbManager.getConnection();
		sql = "UPDATE user"
				+ " INNER JOIN profile"
				+ " ON user.id = profile.userid_fk"
				+ " SET"
				+ " firstname = ?,"
				+ " lastname = ?,"
				+ " jobrole = ?,"
				+ " employer = ?,"
				+ " location = ?"
				+ " WHERE email = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// First parameter is the id of the company entity
		pstmt.setString(1, p.getFirstName());
		pstmt.setString(2, p.getLastName());
		pstmt.setString(3, p.getJobrole());
		pstmt.setString(4, p.getEmployer());
		pstmt.setString(5, p.getLocation());
		pstmt.setString(6, p.getEmail());
		System.out.println(pstmt);
		rowsUpdated = pstmt.executeUpdate();
		return rowsUpdated;
	}

	@Override
	public int delete(Entity e) throws SQLException, ClassNotFoundException, Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public Entity getByEmail(String Email) throws SQLException, ClassNotFoundException, Exception {
		String sql = "SELECT * FROM user" + " LEFT JOIN profile" + " ON user.id = profile.userid_fk"
				+ " WHERE email = ?";
		conn = dbManager.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, Email);
		ResultSet rs = pstmt.executeQuery();

		Profile profile = new Profile();
		while (rs.next()) {
			profile.setFirstName(rs.getString("firstname"));
			profile.setLastName(rs.getString("lastname"));
			profile.setEmail(rs.getString("email"));
			profile.setEmployer(rs.getString("employer"));
			profile.setLocation(rs.getString("location"));
			profile.setJobrole(rs.getString("jobrole"));
		}

		return profile;
	}

	@Override
	public ArrayList<Entity> getAll() throws SQLException, ClassNotFoundException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Profile> search(String query) throws ClassNotFoundException, SQLException {
		List<Profile> profiles = new ArrayList<>();
		Profile profile;
		query = "%" + query + "%";

		String sql = "SELECT * FROM user " + " LEFT JOIN profile " + " ON user.id = profile.userid_fk "
				+ " WHERE user.firstname LIKE ? " + " OR user.lastname LIKE ? " + " OR user.email LIKE ? "
				+ " OR profile.jobrole LIKE ?" + " OR profile.location LIKE ?" + " OR profile.employer LIKE ?";

		conn = dbManager.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, query);
		pstmt.setString(2, query);
		pstmt.setString(3, query);
		pstmt.setString(4, query);
		pstmt.setString(5, query);
		pstmt.setString(6, query);
		ResultSet rs = pstmt.executeQuery();

		// Populate the array list from the records of the company table
		while (rs.next()) {
			profile = new Profile();
			profile.setFirstName(rs.getString("user.firstname"));
			profile.setLastName(rs.getString("user.lastname"));
			profile.setEmail(rs.getString("user.email"));
			profile.setEmployer(rs.getString("profile.employer"));
			profile.setLocation(rs.getString("profile.location"));
			profile.setJobrole(rs.getString("profile.jobrole"));
			profiles.add(profile);
		}
		for (Profile p : profiles) {
			System.out.println(p.toString());
		}

		return profiles;
	}

	@Override
	public Entity getById(int id) throws SQLException, ClassNotFoundException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
