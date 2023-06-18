package fonseca.basaglia.cisstestbackend.service;

import fonseca.basaglia.cisstestbackend.domain.Employee;
import fonseca.basaglia.cisstestbackend.repository.EmployeeRepository;
import fonseca.basaglia.cisstestbackend.service.dto.EmployeeDTO;
import fonseca.basaglia.cisstestbackend.service.mapper.EmployeeMapper;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    private final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Employee save = employeeRepository.save(employee);
        return employeeMapper.toDto(save);
    }

    public Optional<EmployeeDTO> findOne(Long id) {
        return employeeRepository.findById(id).map(employeeMapper::toDto);
    }
}
