package mu.maccs.training.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mu.maccs.training.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}