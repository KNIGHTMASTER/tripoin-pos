package com.tripoin.pos.shared.data.mapper;

import com.tripoin.pos.shared.data.dto.response.BranchResponseDTO;
import com.tripoin.pos.shared.data.model.master.Branch;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 11/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class BranchMapper extends ADATAMapper<Branch, BranchResponseDTO> {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public BranchResponseDTO convert(Branch branch) {
        BranchResponseDTO result = new BranchResponseDTO();
        result.setId(branch.getId());
        result.setCode(branch.getCode());
        result.setName(branch.getName());
        result.setRemarks(branch.getRemarks());
        try{
            if (branch.getCompany() != null){
                result.setCompany(companyMapper.convert(branch.getCompany()));
            }
        }catch (Exception ignored){
        }
        return result;
    }
}
