package net.anushasn.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.anushasn.ems.dto.DepartmentDto;
import net.anushasn.ems.entity.Department;
import net.anushasn.ems.exception.ResourceNotFoundException;
import net.anushasn.ems.mapper.DepartmentMapper;
import net.anushasn.ems.repository.DepartmentRepository;
import net.anushasn.ems.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentRepository departmentRepository;
    @Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		
		// TODO Auto-generated method stub
		
		Department  department = DepartmentMapper.mapToDepartment(departmentDto);
		Department savedDepartment = departmentRepository.save(department);
		return DepartmentMapper.mapToDepartmentDto(savedDepartment);
	}
	@Override
	public DepartmentDto getDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		 Department department = departmentRepository.findById(departmentId).orElseThrow(
				()->new ResourceNotFoundException("Department Doesnt exists with the given Id"+departmentId));
		
		return DepartmentMapper.mapToDepartmentDto(department);
	}
	@Override
	public List<DepartmentDto> getAllDepartments() {
		// TODO Auto-generated method stub
		List<Department> departments = departmentRepository.findAll();
		return departments.stream().map((department)->DepartmentMapper.mapToDepartmentDto(department))
				     .collect(Collectors.toList());
	}
	@Override
	public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
		// TODO Auto-generated method stub
		 Department department = departmentRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department is not exists with the given department Id:"+departmentId));
		 department.setDepartmentName(updatedDepartment.getDepartmentName());
		 department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
		 Department savedDepartment = departmentRepository.save(department);
		return DepartmentMapper.mapToDepartmentDto(savedDepartment);
	}
	@Override
	public void deleteDepartment(Long departmentId) {
		// TODO Auto-generated method stub
		departmentRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department Id doesnt exists with the given Id:"+departmentId));
		departmentRepository.deleteById(departmentId);
		
		
	}

}
