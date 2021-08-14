/**
 * 
 */
package com.spring.boot.SpringBootPagination.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.boot.SpringBootPagination.dao.EmployeeRepo;
import com.spring.boot.SpringBootPagination.entity.Employee;

import lombok.RequiredArgsConstructor;

/**
 * @author mayankjain
 *
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService{
	private final EmployeeRepo repo;
	
	@Override
	public Employee findById(final int id) {
		final Optional<Employee> employee = repo.findById(id);
		if(employee.isPresent())
			return employee.get();
		
		throw new RuntimeException("Employee with id "+id+" does not exist");
	}

	@Override
	public List<Employee> findAllEmployees(final int pageNo, final int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Employee> pageResult = repo.findAll(paging);
		if(pageResult.hasContent())
			return pageResult.getContent();
		else
			return new ArrayList<Employee>();
	}

	@Override
	public List<Employee> findAll() {
		return repo.findAll();
	}
}
