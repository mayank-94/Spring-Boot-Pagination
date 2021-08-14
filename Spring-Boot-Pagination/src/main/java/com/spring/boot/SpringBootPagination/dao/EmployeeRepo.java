/**
 * 
 */
package com.spring.boot.SpringBootPagination.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.SpringBootPagination.entity.Employee;

/**
 * @author mayankjain
 *
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
