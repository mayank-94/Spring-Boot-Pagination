/**
 * 
 */
package com.spring.boot.SpringBootPagination.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class
 * 
 * @author mayankjain
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Employee extends RepresentationModel<Employee>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private int id;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "dept_name")
	private String deptName;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
}
