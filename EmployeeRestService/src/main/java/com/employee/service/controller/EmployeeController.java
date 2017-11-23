package com.employee.service.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.employee.service.model.Employee;
import com.employee.service.service.EmployeeService;

/***
 * controller for employee
 * @author Ibrahim
 *
 */
@Path("/employee")
public class EmployeeController {
	
	EmployeeService employeeService=new EmployeeService();
	/***
	 * 
	 * @return List of employees ordered by id
	 */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees()
	{
		
		List<Employee> employeeList=employeeService.getAllEmployees();
		return employeeList;
	}
    /***
	 * Finds the employee with the specified ID
	 * 
	 * @param id id (Primary key) for the user_details table 
	 * @return {@link Employee} with the corresponding id
	 */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeById(@PathParam("id") int id)
	{
		return employeeService.getEmployee(id);
	}
    
    /***
	 * 
	 * @param lastmodifiedstamp 
	 * @return List of {@link Employee} added after the specified lastModifiedDateTime
	 */
    @GET
    @Path("/lastmodifiedstamp/{lastmodifiedstamp}")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeeByTime(@PathParam("lastmodifiedstamp") String lastmodifiedstamp)
	{
		return employeeService.getEmployeesByTime(lastmodifiedstamp);
	}
    /**
	 * Method adds a new Employee to the DB
	 * @param employee {@link Employee} Employee to be added into the DB
	 */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	public String addEmployee(Employee employee)
	{
    	String flag = "SUCCESS";
		Employee emp = new Employee( employee.getFirstName(), employee.getLastName());
		if (employeeService.addEmployee(emp) != 1)
			flag = "FAILURE";
		return flag;
		
	}
    /***
	 * 
	 * @param employee {@link Employee} Employee to be updated
	 * @return updated {@link Employee} 
	 */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
	public Employee updateEmployee(Employee employee)
	{
		return employeeService.updateEmployee(employee);
		
	}
    /***
	 * Deletes the employee with the matching id
	 * @param id id of the employee to delete
	 */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public void deleteEmployee(@PathParam("id") int id)
	{
    	employeeService.deleteEmployee(id);
		
	}
	
}
