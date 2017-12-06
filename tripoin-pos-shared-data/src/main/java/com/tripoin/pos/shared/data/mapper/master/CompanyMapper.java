package com.tripoin.pos.shared.data.mapper.master;

import com.tripoin.pos.shared.data.dto.response.master.CompanyResponseDTO;
import com.tripoin.pos.shared.data.model.master.Company;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class CompanyMapper extends ADATAMapper<Company, CompanyResponseDTO> {

    @Override
    public CompanyResponseDTO convert(Company companyRawDTO) {
        CompanyResponseDTO companyResponseDTO = new CompanyResponseDTO();
        companyResponseDTO.setId(companyRawDTO.getId());
        companyResponseDTO.setCode(companyRawDTO.getCode());
        companyResponseDTO.setName(companyRawDTO.getName());
        companyResponseDTO.setRemarks(companyRawDTO.getRemarks());
        return companyResponseDTO;
    }
}
