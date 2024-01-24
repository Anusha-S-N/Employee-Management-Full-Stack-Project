package net.anushasn.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.anushasn.ems.dto.EmployeeDto;
import net.anushasn.ems.entity.Employee;
import net.anushasn.ems.repository.EmployeeRepository;

public interface EmployeeService {
	//public static final EmployeeRepository employeeRepository = null;
	
	// public static final EmployeeRepository employeeRepository = null;
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee);
	
	void deleteEmployee(long employeeId);
	
//	Page <Employee>findPaginated(int pageNo,int pageSize);	
//
//	Page<Employee> getAllEmployeesSortedByFirstName(Pageable pageable);
//	
//	 Page<Employee> getAllEmployeesSortedByLastName(Pageable pageable);
//	 
//	 Page<Employee> getAllEmployeesSortedByDepartment(Pageable pageable);
//	 
//	 Page<Employee> getAllEmployeesSortedByHireDate(Pageable pageable);
	 
	 List<Employee> findAll();
	 
	 
}


