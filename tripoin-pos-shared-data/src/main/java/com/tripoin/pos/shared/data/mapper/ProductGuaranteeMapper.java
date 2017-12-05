package com.tripoin.pos.shared.data.mapper;

import com.tripoin.pos.shared.data.dto.response.ProductGuaranteeResponseDTO;
import com.tripoin.pos.shared.data.model.master.ProductGuarantee;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProductGuaranteeMapper extends ADATAMapper<ProductGuarantee, ProductGuaranteeResponseDTO> {

    @Override
    public ProductGuaranteeResponseDTO convert(ProductGuarantee productGuarantee) {
        ProductGuaranteeResponseDTO productGuaranteeResponseDTO = new ProductGuaranteeResponseDTO();
        productGuaranteeResponseDTO.setId(productGuarantee.getId());
        productGuaranteeResponseDTO.setCode(productGuarantee.getCode());
        productGuaranteeResponseDTO.setName(productGuarantee.getName());
        productGuaranteeResponseDTO.setRemarks(productGuarantee.getRemarks());
        productGuaranteeResponseDTO.setMerchantGuarantee(productGuarantee.getMerchantGuarantee());
        productGuaranteeResponseDTO.setBrandGuarantee(productGuarantee.getBrandGuarantee());
        return productGuaranteeResponseDTO;
    }
}
