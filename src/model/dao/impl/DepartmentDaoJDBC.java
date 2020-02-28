package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn=conn;
	}
	
	private Connection conn=null;

	@Override
	public void insert(Department obj) {
		PreparedStatement st=null;
		try {
			st=conn.prepareStatement("insert into department(name) values(?)",PreparedStatement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getName());
			
			
			
			int rowsAffected=st.executeUpdate();
			
			if(rowsAffected>0) {
				ResultSet rs=st.getGeneratedKeys();
				if(rs.next()) {
					int id=rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
				
			}
			else {
				throw new DbException("Unexpected error! No rows affected");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
		
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st=null;
		
		try {
			st=conn.prepareStatement("update department set name=? where id=?");
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			int rowsAffected=st.executeUpdate();
			if(rowsAffected==0) {
				throw new DbException("No rows affected");
				
			}
			
			
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deletById(Integer id) {
		PreparedStatement st=null;
		
		try {
			st=conn.prepareStatement("delete from department where id=?");
			st.setInt(1, id);
			
			st.executeUpdate();
			
			
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try {
			st=conn.prepareStatement("Select * from department where id=?");
			st.setInt(1, id);
			rs=st.executeQuery();
			if(rs.next()) {
				Department obj=new Department();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
			
			
				return obj;}
			return null;
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			st=conn.prepareStatement("select * from department order by Name");
		
			
			rs=st.executeQuery();
			List<Department> list=new ArrayList<>();
			while(rs.next()) {
				Department obj=new Department();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				list.add(obj);
			}
			return list;
			
				
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	
	

}
