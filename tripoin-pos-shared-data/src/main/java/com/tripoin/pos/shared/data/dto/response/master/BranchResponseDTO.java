package com.tripoin.pos.shared.data.dto.response.master;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

/**
 * Created on 11/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class BranchResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = 3804645856350751959L;

    private CompanyResponseDTO company;

    public CompanyResponseDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyResponseDTO company) {
        this.company = company;
    }
}
