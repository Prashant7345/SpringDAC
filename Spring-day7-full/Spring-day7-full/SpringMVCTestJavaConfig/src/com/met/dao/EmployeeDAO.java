package com.met.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.met.model.Employee;

//@Component
@Repository
												//@Transactional
public class EmployeeDAO {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
		
	
	public void saveEmployee(Employee employee){
		
		System.out.println("Save employee to db..");
		
		
		
		//saveUsingJDBC(employee)
		
		//saveUsingDataSource(employee);
		
		//saveUsingJDBCTemplate(employee);
		
		//saveUsingHibernate(employee);
		
		Session currentSession = sessionFactory.getCurrentSession();			//check in thread local storage
																				//any hibernate session is present.
		currentSession.save(employee);
		
	}
	
	
	private void saveUsingHibernate(Employee employee){
		
		Session session = null;
		Transaction tx = null;
		
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			session.save(employee);
			
			tx.commit();
			
		}catch(HibernateException ex){
			ex.printStackTrace();
			if(tx!=null) tx.rollback();
		}finally {
			if(session != null) session.close();
		}
		
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



