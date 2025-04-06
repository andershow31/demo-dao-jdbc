package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
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
			int rowsAffected = st.executeUpdate();
			//o if abaixo verifica se houve linhas modificadas
			//caso negativo lança uma exception
		if(rowsAffected > 0) {
			ResultSet rs = st.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				dep.setId(id);
			}
			DB.closeResultSet(rs);
			
		}else {
			throw new DbException("Unexpected error: no rows affected");
		}		
		
		}catch(SQLException e) {
			throw new DbException("SQL error: " +e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Department dep) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE department "
					+ "SET Name = ? "
					+ "WHERE Id = ? ");
			st.setString(1, dep.getName());
			st.setInt(2, dep.getId());
			st.executeUpdate();
			
		}catch(SQLException e){
			throw new DbException("SQL Exception: " + e.getMessage());
		}finally {
			DB.closeStatement(st);			
		}
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
