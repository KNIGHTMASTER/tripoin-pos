package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.ReturDetailResponseDTO;
import com.tripoin.pos.shared.data.mapper.master.ProductMapper;
import com.tripoin.pos.shared.data.model.trx.ReturDetail;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 12/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ReturDetailMapper extends ADATAMapper<ReturDetail, ReturDetailResponseDTO> {

    @Autowired
    private ReturHeaderMapper returHeaderMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ReturDetailResponseDTO convert(ReturDetail returDetail) {
        ReturDetailResponseDTO responseDTO = new ReturDetailResponseDTO();
        responseDTO.setId(returDetail.getId());
        responseDTO.setCode(returDetail.getCode());
        responseDTO.setName(returDetail.getName());
        responseDTO.setRemarks(returDetail.getRemarks());
        if (returDetail.getReturHeader() != null) {
            responseDTO.setReturHeader(returHeaderMapper.convert(returDetail.getReturHeader()));
        }
        if (returDetail.getProduct() != null) {
            responseDTO.setProduct(productMapper.convert(returDetail.getProduct()));
        }
        responseDTO.setItemPrice(returDetail.getItemPrice());
        responseDTO.setQty(returDetail.getQty());
        responseDTO.setProductName(returDetail.getProductName());
        return responseDTO;
    }
}
