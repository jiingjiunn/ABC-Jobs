package com.wdf.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wdf.entity.Entity;

public interface IDao {
	public int insert(Entity e) throws SQLException, ClassNotFoundException, Exception;
	public int update(Entity e) throws SQLException, ClassNotFoundException, Exception;
	public int delete(Entity e) throws SQLException, ClassNotFoundException, Exception;
	public Entity getById(int id) throws SQLException, ClassNotFoundException, Exception;
	public ArrayList<Entity> getAll() throws SQLException, ClassNotFoundException, Exception;
}
