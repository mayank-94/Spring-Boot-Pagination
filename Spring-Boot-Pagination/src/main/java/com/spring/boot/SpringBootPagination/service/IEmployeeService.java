/**
 * 
 */
package com.spring.boot.SpringBootPagination.service;

import java.util.List;

import com.spring.boot.SpringBootPagination.entity.Employee;

/**
 * @author mayankjain
 *
 */
public interface IEmployeeService {
	Employee findById(int id);
	List<Employee> findAllEmployees(int pageNo, int pageSize);
	List<Employee> findAll();
}
