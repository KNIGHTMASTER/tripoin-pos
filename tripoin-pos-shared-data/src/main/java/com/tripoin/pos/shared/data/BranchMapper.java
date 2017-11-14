package com.tripoin.pos.shared.data;

import com.tripoin.pos.shared.data.model.Branch;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 11/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class BranchMapper extends ADATAMapper<Branch, BranchTableDTO> {
    @Override
    public BranchTableDTO convert(Branch branch) {
        BranchTableDTO result = new BranchTableDTO();
        result.setId(branch.getId());
        result.setCode(branch.getCode());
        result.setName(branch.getName());
        result.setRemarks(branch.getRemarks());
        return result;
    }
}
