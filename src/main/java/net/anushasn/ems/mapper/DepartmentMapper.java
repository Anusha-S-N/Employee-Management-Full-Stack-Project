package net.anushasn.ems.mapper;

import net.anushasn.ems.dto.DepartmentDto;
import net.anushasn.ems.entity.Department;

public class DepartmentMapper {
	//convert department JPA Entity into Department DTO
	
	public static DepartmentDto mapToDepartmentDto(Department department) {
		
		
		return new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription());
	}
		

//convert departmentDto intoDepartmentEntity
public static Department mapToDepartment(DepartmentDto departmentDto) {
	return new Department(
			departmentDto.getId(),
			departmentDto.getDepartmentName(),
			departmentDto.getDepartmentDescription()
		
			);
}
}