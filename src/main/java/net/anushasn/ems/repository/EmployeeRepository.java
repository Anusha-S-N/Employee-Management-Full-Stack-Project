package net.anushasn.ems.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.anushasn.ems.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

//	Page<Employee> findAllByOrderByFirstName(Pageable pageable);
//    Page<Employee> findAllByOrderByLastName(Pageable pageable);
//    Page<Employee> findAllByOrderByDepartment(Pageable pageable);
//    Page<Employee> findAllByOrderByHireDate(Pageable pageable);
	public List<Employee> findAllByOrderByFirstNameAsc();
	
}
