package com.employee.service.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

import com.employee.service.employeeDao.DBConnection;
import com.employee.service.model.Employee;

/***
 * Services for the employee 
 * @author Ibrahim
 *
 */
public class EmployeeService {


	public EmployeeService() {
		super();
	}

	/***
	 * 
	 * @return List of employees ordered by id
	 */
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			PreparedStatement ps = DBConnection.getConnection()
					.prepareStatement("select * from user_details order by id");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setId(Integer.parseInt(rs.getString("id")));
				employeeList.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	/***
	 * 
	 * @param lastmodifiedstamp 
	 * @return List of {@link Employee} added after the specified lastModifiedDateTime
	 */
	public List<Employee> getEmployeesByTime(String lastmodifiedstamp) {
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			PreparedStatement ps = DBConnection.getConnection()
					.prepareStatement("select * from user_details where lastmodifiedstamp > ?");
			ps.setString(1, lastmodifiedstamp);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setId(Integer.parseInt(rs.getString("id")));
				employeeList.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}


	/***
	 * Finds the employee with the specified ID
	 * 
	 * @param id id (Primary key) for the user_details table 
	 * @return {@link Employee} with the corresponding id
	 */
	public Employee getEmployee(int id) {
		Validate.notNull(id);
		Employee employee = null;
		try {
			PreparedStatement ps = DBConnection.getConnection()
					.prepareStatement("select * from user_details where id =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employee = new Employee();
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setId(Integer.parseInt(rs.getString("id")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	/**
	 * Method adds a new Employee to the DB
	 * @param employee {@link Employee} Employee to be added into the DB
	 */
	public int addEmployee(Employee employee) {
		Validate.notNull(employee);
		int flag = 0;
		try {
			PreparedStatement ps = DBConnection.getConnection()
					.prepareStatement("INSERT INTO USER_DETAILS(id, first_Name,last_name) VALUES(?,?,?)");
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getFirstName());
			ps.setString(3, employee.getLastName());

			flag = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/***
	 * 
	 * @param employee {@link Employee} Employee to be updated
	 * @return updated {@link Employee} 
	 */
	public Employee updateEmployee(Employee employee) {
		Validate.notNull(employee);
		try {
			PreparedStatement ps = DBConnection.getConnection()
					.prepareStatement("update USER_DETAILS SET first_Name = ?,last_name=? where id=?");

			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setInt(3, employee.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;

	}

	/***
	 * Deletes the employee with the matching id
	 * @param id id of the employee to delete
	 */
	public void deleteEmployee(int id) {
		Validate.notNull(id);
		try {
			PreparedStatement ps = DBConnection.getConnection()
					.prepareStatement("delete from user_details where id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
