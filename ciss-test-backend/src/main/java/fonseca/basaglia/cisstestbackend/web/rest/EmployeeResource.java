package fonseca.basaglia.cisstestbackend.web.rest;

import fonseca.basaglia.cisstestbackend.repository.EmployeeRepository;
import fonseca.basaglia.cisstestbackend.service.EmployeeService;
import fonseca.basaglia.cisstestbackend.service.dto.EmployeeDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeResource {
    private final Logger log = LoggerFactory.getLogger(EmployeeResource.class);
    private static final String ENTITY_NAME = "employee";
    @Autowired
    private final EmployeeService employeeService;
    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeResource(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO save = employeeService.save(employeeDTO);
        return ResponseEntity.ok(save);
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Optional<EmployeeDTO>> getEmployee(@PathVariable Long id){
        Optional<EmployeeDTO> employeeDTO = employeeService.findOne(id);
        if (!employeeDTO.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeDTO);
    }

}
