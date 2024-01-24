package net.anushasn.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.anushasn.ems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
	

}
