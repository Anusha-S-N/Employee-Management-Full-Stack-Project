package net.anushasn.ems.service.impl;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.anushasn.ems.dto.EmployeeDto;
import net.anushasn.ems.entity.Department;
import net.anushasn.ems.entity.Employee;
import net.anushasn.ems.exception.ResourceNotFoundException;
import net.anushasn.ems.mapper.EmployeeMapper;
import net.anushasn.ems.repository.DepartmentRepository;
import net.anushasn.ems.repository.EmployeeRepository;
import net.anushasn.ems.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;
	private DepartmentRepository departmentRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
	    Department department = departmentRepository.findById(employeeDto.getDepartmentId())
	    		.orElseThrow(()-> 
	    		new ResourceNotFoundException("departmnet Doesnt exists with Id:"+employeeDto.getDepartmentId()));
	    employee.setDepartment(department);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		 Employee employee = employeeRepository.findById(employeeId)
		.orElseThrow(()-> new ResourceNotFoundException("Employee is not Exists with the givn Id :"+employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		// TODO Auto-generated method stub
		 Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				()-> new ResourceNotFoundException("Employee Is noot exists withgive Id:"+employeeId)
				);
		 
		 employee.setFirstName(updatedEmployee.getFirstName());
		 employee.setLastName(updatedEmployee.getLastName());
		 employee.setEmail(updatedEmployee.getEmail());
		 Department department = departmentRepository.findById(updatedEmployee.getDepartmentId())
		    		.orElseThrow(()-> 
		    		new ResourceNotFoundException("departmnet Doesnt exists with Id:"+updatedEmployee.getDepartmentId()));
		 
		    employee.setDepartment(department);
		 employee.setHireDate(updatedEmployee.getHireDate());
		 Employee updatedEmployeeObj = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(long employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee is not Exists with the givn Id :"+employeeId));
				
		employeeRepository.deleteById(employeeId);
			}

//	@Override
//	public Page<Employee> findPaginated(int pageNo, int pageSize) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Page<Employee> getAllEmployeesSortedByFirstName(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return employeeRepository.findAllByOrderByFirstName(pageable);
//	}
//
//	@Override
//	public Page<Employee> getAllEmployeesSortedByLastName(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return employeeRepository.findAllByOrderByLastName(pageable);
//	}
//
//	@Override
//	public Page<Employee> getAllEmployeesSortedByDepartment(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return  employeeRepository.findAllByOrderByDepartment(pageable);
//	}
//
//	@Override
//	public Page<Employee> getAllEmployeesSortedByHireDate(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return employeeRepository.findAllByOrderByHireDate(pageable);
//	}
//
//	@Override
//	public Page<Employee> findPaginated(int pageNo, int pageSize) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	//sorting employee firstname by asc
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAllByOrderByFirstNameAsc();
	}
	}
	
			
	
	


