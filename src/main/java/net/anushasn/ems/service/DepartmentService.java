package net.anushasn.ems.service;

import java.util.List;

import net.anushasn.ems.dto.DepartmentDto;

public interface DepartmentService {
	
	DepartmentDto createDepartment(DepartmentDto departmentdto);
	
	DepartmentDto getDepartmentById(Long departmentId);
	
	List<DepartmentDto> getAllDepartments();
	
	DepartmentDto updateDepartment(Long departmentId,DepartmentDto updatedDepartment);

	void deleteDepartment(Long departmentId);
	
}
