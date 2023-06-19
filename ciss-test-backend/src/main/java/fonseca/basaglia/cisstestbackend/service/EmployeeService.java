package fonseca.basaglia.cisstestbackend.service;

import fonseca.basaglia.cisstestbackend.domain.Employee;
import fonseca.basaglia.cisstestbackend.repository.EmployeeRepository;
import fonseca.basaglia.cisstestbackend.service.dto.EmployeeDTO;
import fonseca.basaglia.cisstestbackend.service.mapper.EmployeeMapper;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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
        log.info("Salvando funcionário {}", employeeDTO.getName());
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Employee save = employeeRepository.save(employee);
        return employeeMapper.toDto(save);
    }

    public Optional<EmployeeDTO> findOne(Long id) {
        log.info("Buscando funcionário número {}",id);
        return employeeRepository.findById(id).map(employeeMapper::toDto);
    }

    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        log.info("Atualizando funcionário {}", employeeDTO.getName());
        Employee employee = employeeMapper.toEntity(employeeDTO);
        employee = employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

    public void delete(Long id) {
        log.info("Atenção: deletando funcionário ID {}", id);
        employeeRepository.deleteById(id);
    }

    public List<EmployeeDTO> getAllEmployees() {
        log.info("Buscando todos os funcionários");
        return employeeRepository.findAll().stream().map(employeeMapper::toDto).toList();
    }

    public Page<EmployeeDTO> findAll(Pageable pageable) {
        log.info("Buscando todos os funcionarios com os filtros {}", pageable);
        return employeeRepository.findAll(pageable).map(employeeMapper::toDto);
    }
}
