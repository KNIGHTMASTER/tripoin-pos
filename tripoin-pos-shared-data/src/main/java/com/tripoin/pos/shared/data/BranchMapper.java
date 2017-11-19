package com.tripoin.pos.shared.data;

import com.tripoin.pos.shared.data.model.Branch;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 11/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class BranchMapper extends ADATAMapper<Branch, BranchTableDTO> {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public BranchTableDTO convert(Branch branch) {
        BranchTableDTO result = new BranchTableDTO();
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
