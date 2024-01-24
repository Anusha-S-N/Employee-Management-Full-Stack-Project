package net.anushasn.ems.service;

//import net.anushasn.ems.dto.EmployeeDto;
import net.anushasn.ems.dto.RegisterDto;


public interface RegisterService {
	
	RegisterDto createUser(RegisterDto registerDto);

}
