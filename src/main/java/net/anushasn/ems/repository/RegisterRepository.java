package net.anushasn.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.anushasn.ems.entity.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register,Long> {

}
