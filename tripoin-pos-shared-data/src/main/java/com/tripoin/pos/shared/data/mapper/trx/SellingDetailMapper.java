package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.SellingDetailResponseDTO;
import com.tripoin.pos.shared.data.mapper.master.ProductMapper;
import com.tripoin.pos.shared.data.model.trx.SellingDetail;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 12/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class SellingDetailMapper extends ADATAMapper<SellingDetail, SellingDetailResponseDTO> {

    @Autowired
    private SellingHeaderMapper sellingHeaderMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public SellingDetailResponseDTO convert(SellingDetail sellingDetail) {
        SellingDetailResponseDTO responseDTO = new SellingDetailResponseDTO();
        responseDTO.setId(sellingDetail.getId());
        responseDTO.setCode(sellingDetail.getCode());
        responseDTO.setName(sellingDetail.getName());
        responseDTO.setRemarks(sellingDetail.getRemarks());
        if (sellingDetail.getSellingHeader() != null) {
            responseDTO.setSellingHeader(sellingHeaderMapper.convert(sellingDetail.getSellingHeader()));
        }
        if (sellingDetail.getProduct() != null) {
            responseDTO.setProduct(productMapper.convert(sellingDetail.getProduct()));
        }
        responseDTO.setItemPrice(sellingDetail.getItemPrice());
        responseDTO.setQty(sellingDetail.getQty());
        responseDTO.setProductName(sellingDetail.getProductName());
        return responseDTO;
    }
}