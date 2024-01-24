package net.anushasn.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.anushasn.ems.dto.EmployeeDto;
import net.anushasn.ems.dto.RegisterDto;
import net.anushasn.ems.service.EmployeeService;
import net.anushasn.ems.service.RegisterService;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api")

public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	
	//build add employee rest API
		@PostMapping("/register")
		public ResponseEntity<RegisterDto> createUser(@RequestBody RegisterDto registerDto){
			RegisterDto savedUser = registerService.createUser(registerDto);
			return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
		}
}
				

