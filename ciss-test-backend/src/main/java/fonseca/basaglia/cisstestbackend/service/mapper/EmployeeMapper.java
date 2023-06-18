package fonseca.basaglia.cisstestbackend.service.mapper;

import fonseca.basaglia.cisstestbackend.domain.Employee;
import fonseca.basaglia.cisstestbackend.service.dto.EmployeeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Employee} and its DTO {@link EmployeeDTO}.
 */
@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<EmployeeDTO, Employee> {}
