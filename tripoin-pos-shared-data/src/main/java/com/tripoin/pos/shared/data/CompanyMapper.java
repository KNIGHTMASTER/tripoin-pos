package com.tripoin.pos.shared.data;

import com.tripoin.pos.shared.data.model.Company;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class CompanyMapper extends ADATAMapper<Company, CompanyTableDTO> {

    @Override
    public CompanyTableDTO convert(Company companyRawDTO) {
        CompanyTableDTO companyTableDTO = new CompanyTableDTO();
        companyTableDTO.setId(companyRawDTO.getId());
        companyTableDTO.setCode(companyRawDTO.getCode());
        companyTableDTO.setName(companyRawDTO.getName());
        return companyTableDTO;
    }
}
