package net.anushasn.ems.mapper;

import net.anushasn.ems.dto.EmployeeDto;
import net.anushasn.ems.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getHireDate(),
				employee.getDepartment().getId()
				);
	}
	
	public static Employee mapToEmployee (EmployeeDto employeeDto) {
		Employee employee =  new Employee();
		
		employee.setId(employeeDto.getId());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		employee.setHireDate(employeeDto.getHireDate());
		return employee;
	}
	

}
