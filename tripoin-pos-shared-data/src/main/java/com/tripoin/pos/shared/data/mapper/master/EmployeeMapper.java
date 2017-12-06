package com.tripoin.pos.shared.data.mapper.master;

import com.tripoin.pos.shared.data.dto.response.master.EmployeeResponseDTO;
import com.tripoin.pos.shared.data.model.master.Employee;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class EmployeeMapper extends ADATAMapper<Employee, EmployeeResponseDTO> {
    @Override
    public EmployeeResponseDTO convert(Employee employee) {
        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        responseDTO.setId(employee.getId());
        responseDTO.setCode(employee.getCode());
        responseDTO.setName(employee.getName());
        responseDTO.setRemarks(employee.getRemarks());
        return responseDTO;
    }
}
