package com.met.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.met.model.Employee;

//@Component
@Repository
public class EmployeeDAO {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void saveEmployee(Employee employee){
		
		System.out.println("Save employee to db..");
		
		//saveUsingJDBC(employee)
		
		//saveUsingDataSource(employee);
		
		saveUsingJDBCTemplate(employee);
		
	}
	
	private void saveUsingJDBCTemplate(Employee employee){
		
		jdbcTemplate.update("insert into employeetbl values(?, ?, ?, ?)", 
					new Object[]{
							employee.getId(),
							employee.getName(),
							employee.getDesignation(),
							employee.getEmailId()
					}
				
				);
		
	}
	
	
	private void saveUsingDataSource(Employee employee){
		
		try(Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into employeetbl values(?, ?, ?, ?)")
				){
			
			pstmt.setInt(1, employee.getId());
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getDesignation());
			pstmt.setString(4, employee.getEmailId());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void saveUsingJDBC(Employee employee){
		
		
	}
	
	public List<Employee> getAllEmployees(){
		
		//return jdbcTemplate.queryForList("select * from employeetbl", Employee.class);
		
		return jdbcTemplate.query("select * from employeetbl", new BeanPropertyRowMapper<Employee>(Employee.class));
		
		//return jdbcTemplate.query("select * from employeetbl", new EmployeeMapper());
		
	}
}

class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Employee emp = new Employee();
		emp.setId(rs.getInt(1));
		emp.setName(rs.getString(2));
		emp.setDesignation(rs.getString("designation"));
		emp.setEmailId(rs.getString("emailId"));
		
		return emp;
	}
	
	
}


/*List<Employee>  listEMployees = new ArrayList();

while(rs.next()){
	
	Employee employee = mapper.mapRow(rs, 1);
	listEMployees.add(employee);
	
}*/



