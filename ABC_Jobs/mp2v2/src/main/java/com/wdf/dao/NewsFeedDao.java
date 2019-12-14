package com.wdf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wdf.entity.Entity;
import com.wdf.entity.NFThread;
import com.wdf.entity.NFThreadReply;

public class NewsFeedDao implements IDao {
	private DBManager dbManager = new DBManager();
	private Connection conn = null;
	
	//Create thread
	@Override
	public int insert(Entity e) throws SQLException, ClassNotFoundException, Exception {
		int rowsInserted = -1;
		String sql = null;
		NFThread thread = (NFThread) e;
		conn = dbManager.getConnection();
		sql = "INSERT INTO thread "
				+ "(threadowner_fk, threadcontent) "
				+ "VALUES (?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,thread.getOwner());//TODO write function to get owner id
		pstmt.setString(2, thread.getContent());
		rowsInserted = pstmt.executeUpdate();
		return rowsInserted;
	}
	
	//Reply thread
	public int insertThreadReply(Entity e) throws SQLException, ClassNotFoundException {
		int rowsInserted = -1;
		String sql = null;
		NFThreadReply reply = (NFThreadReply) e;
		conn = dbManager.getConnection();
		sql = "INSERT INTO threadreply "
				+ "(threadid_fk, threadreplyownerid, threadreplycontent) "
				+ "VALUES (?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, reply.getThreadId());
		pstmt.setInt(2, reply.getOwner());
		pstmt.setString(3, reply.getReplyContent());
		rowsInserted = pstmt.executeUpdate();
		return rowsInserted;
	}

	@Override
	public int update(Entity e) throws SQLException, ClassNotFoundException, Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Entity e) throws SQLException, ClassNotFoundException, Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Entity getById(int id) throws SQLException, ClassNotFoundException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Entity> getAll() throws SQLException, ClassNotFoundException, Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<NFThread> getAllThread() throws ClassNotFoundException, SQLException {
		List<NFThread> threads =  new ArrayList<>();
		String sql = "SELECT * FROM thread "
				+ "JOIN user "
				+ "ON threadowner_fk = id";
		conn = dbManager.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while(rs.next()) {
			NFThread e = new NFThread();
			e.setOwner(rs.getString("firstname") + " " + rs.getString("lastname"));
			e.setContent(rs.getString("threadcontent"));
			e.setDateTime(rs.getString("threadtimestamp"));
			e.setOwnerId(rs.getInt("id"));
			e.setId(rs.getInt("threadid"));
			e.setReplies(getReplies(rs.getInt("threadid")));
			threads.add(e);
		}
		return threads;
	}
	
	public List<NFThreadReply> getReplies(int id) throws SQLException{
		List<NFThreadReply> replies = new ArrayList<>();
		String sql = "SELECT * FROM threadreply "
				+ "where threadid_fk = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			NFThreadReply reply = new NFThreadReply();
			reply.setOwner(rs.getInt("threadreplyownerid"));
			reply.setDateTime(rs.getString("threadreplytimestamp"));
			reply.setReplyContent(rs.getString("threadreplycontent"));
			replies.add(reply);
		}
		return replies;
	}
	

}
