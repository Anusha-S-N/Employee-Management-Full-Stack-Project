package net.anushasn.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.anushasn.ems.dto.DepartmentDto;
import net.anushasn.ems.service.DepartmentService;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	//Build Add REST APi for Departmnet
	@PostMapping
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
		DepartmentDto department = departmentService.createDepartment(departmentDto);
		return new ResponseEntity<>(department,HttpStatus.CREATED);
		
	}
	//Build Get Department REST API
	@GetMapping("{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId)
	{
		DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
		return ResponseEntity.ok(departmentDto);
	}
	
	//Build Get all departments REST API
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
		 List<DepartmentDto> departments = departmentService.getAllDepartments();
		return ResponseEntity.ok(departments);
	}
	
	//build Update department REST API
	@PutMapping("{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable ("id")Long departmentId,@RequestBody DepartmentDto updatedDepartment){
	 DepartmentDto departmentDto =departmentService.updateDepartment(departmentId,updatedDepartment);
    return ResponseEntity.ok(departmentDto);
}
	
	//Build delete Department REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id")Long departmentId){
		departmentService.deleteDepartment(departmentId);
		return ResponseEntity.ok("Department deleted successfully!");
	}
}
