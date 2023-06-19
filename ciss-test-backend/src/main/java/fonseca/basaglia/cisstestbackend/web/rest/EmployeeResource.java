package fonseca.basaglia.cisstestbackend.web.rest;

import fonseca.basaglia.cisstestbackend.repository.EmployeeRepository;
import fonseca.basaglia.cisstestbackend.service.EmployeeService;
import fonseca.basaglia.cisstestbackend.service.dto.EmployeeDTO;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
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

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long id,
                                                      @Valid @RequestBody EmployeeDTO employeeDTO){
        if (employeeDTO.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        if (id != employeeDTO.getId()) {
            return ResponseEntity.badRequest().build();
        }
        EmployeeDTO empsDTO = employeeService.update(employeeDTO);
        return ResponseEntity.ok(empsDTO);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id){
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/employees/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeesWithoutFilter(){
        List<EmployeeDTO> employeeList =employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeList);
    }
    @GetMapping("/employees")
    public ResponseEntity<Page<EmployeeDTO>> getAllEmployees(Pageable pageable){
        Page<EmployeeDTO> page = employeeService.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }
}
