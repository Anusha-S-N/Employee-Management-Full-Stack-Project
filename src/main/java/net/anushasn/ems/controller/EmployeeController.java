package net.anushasn.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.anushasn.ems.dto.EmployeeDto;
import net.anushasn.ems.entity.Employee;
import net.anushasn.ems.service.EmployeeService;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	 //private  EmployeeRepository employeeRepository;
	 
	//build add employee rest API
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
		
	}
	//Build get Employee rest Api
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById( @PathVariable("id")Long employeeId){
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
	}
	
	//Build get All Employees rest Api 
	@GetMapping
	public ResponseEntity<List<EmployeeDto>>getAllEmployees(){
	List<EmployeeDto>employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
		
	}
	
	//Build Update Employee REST API
	@PutMapping("{id}")
	
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id")Long employeeId,
			                                           @RequestBody EmployeeDto updatedEmployee){
		EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updatedEmployee);
		return  ResponseEntity.ok(employeeDto);
		
	}
	
	//Build Employee Delete RESY API
	
	@DeleteMapping("{id}")
	public  ResponseEntity<String> deleteEmployee(@PathVariable("id")Long employeeId){
		employeeService.deleteEmployee(employeeId);
		
		return ResponseEntity.ok("Employee Deleted successfuly!");
	}
	
	
	@GetMapping("/employee")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}

	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//@GetMapping("/all")
//public ResponseEntity<Page<Employee>> getAllEmployees(
//      @RequestParam(defaultValue = "0") int page,
//      @RequestParam(defaultValue = "10") int size,
//      @RequestParam(defaultValue = "firstName") String sortBy) {
//
//  Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
//  Page<Employee> employees = employeeService.getAllEmployeesSortedByFirstName(pageable);
//  return ResponseEntity.ok(employees);
// }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/page/{pageNo}")
//    public String findPaginated(@PathVariable(value="pageNo")int pageNo) {
//		int pageSize = 5;
//		Page <Employee> page = employeeService.findPaginated(pageNo, pageSize);
//		List<Employee> listEmployees = page.getContent();
//		model.addAttribute("currentPage",pageNo);
//		return null;
//	}
	
	



		