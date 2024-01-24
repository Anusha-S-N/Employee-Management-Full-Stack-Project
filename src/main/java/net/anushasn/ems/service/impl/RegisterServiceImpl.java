package net.anushasn.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.anushasn.ems.dto.EmployeeDto;
import net.anushasn.ems.dto.RegisterDto;
import net.anushasn.ems.entity.Department;
import net.anushasn.ems.entity.Employee;
import net.anushasn.ems.entity.Register;
import net.anushasn.ems.exception.ResourceAlreadyExistsException;
import net.anushasn.ems.exception.ResourceNotFoundException;
import net.anushasn.ems.mapper.EmployeeMapper;
import net.anushasn.ems.mapper.RegisterMapper;
import net.anushasn.ems.repository.EmployeeRepository;
import net.anushasn.ems.repository.RegisterRepository;
import net.anushasn.ems.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	public RegisterServiceImpl(RegisterRepository registerRepository) {
		this.registerRepository = registerRepository;
	}

	private RegisterRepository registerRepository;
	@Override
	public RegisterDto createUser(RegisterDto registerDto) {
		

		Register register = RegisterMapper.mapToRegister(registerDto)
			    .orElseThrow(() -> 
			        new ResourceAlreadyExistsException("This account already exists please login" + registerDto.getId()));

		   
			Register savedUser = registerRepository.save(register);
			return RegisterMapper.mapToRegisterDto(savedUser);
		}
		
	}
	
	
	
	


