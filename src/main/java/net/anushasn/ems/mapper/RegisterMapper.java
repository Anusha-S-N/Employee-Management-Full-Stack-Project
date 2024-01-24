package net.anushasn.ems.mapper;

import java.util.Optional;

import net.anushasn.ems.dto.EmployeeDto;
import net.anushasn.ems.dto.RegisterDto;
import net.anushasn.ems.entity.Employee;
import net.anushasn.ems.entity.Register;

public class RegisterMapper {
	
	public static  RegisterDto mapToRegisterDto(Register register) {
		return new RegisterDto(
				register.getId(),
				register.getEmail(),
				register.getPassword(),
				register.getRole()
				
				);
	}
	
	public static Optional<Register> mapToRegister (RegisterDto registerDto) {
		Register register =  new Register();
		
		register.setId(registerDto.getId());
		register.setEmail(registerDto.getEmail());
		register.setPassword(registerDto.getPassword());
		register.setRole(registerDto.getRole());
		return Optional.ofNullable(register);
	}
	

}
