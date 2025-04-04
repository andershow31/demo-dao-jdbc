package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
	
	private Connection conn;
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(Department dep) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO department "
					+ "(Id, Name) "
					+ "VALUES "
					+ "(?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, dep.getId());
			st.setString(2, dep.getName());
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DbException("SQL error: " +e.getMessage());
		}
	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
