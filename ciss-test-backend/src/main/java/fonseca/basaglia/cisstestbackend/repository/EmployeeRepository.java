package fonseca.basaglia.cisstestbackend.repository;

import fonseca.basaglia.cisstestbackend.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
