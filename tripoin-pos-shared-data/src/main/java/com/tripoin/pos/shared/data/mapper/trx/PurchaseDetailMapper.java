package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.PurchaseDetailResponseDTO;
import com.tripoin.pos.shared.data.mapper.master.ProductMapper;
import com.tripoin.pos.shared.data.model.trx.PurchaseDetail;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 12/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class PurchaseDetailMapper extends ADATAMapper<PurchaseDetail, PurchaseDetailResponseDTO> {

    @Autowired
    private PurchaseHeaderMapper purchaseHeaderMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public PurchaseDetailResponseDTO convert(PurchaseDetail purchaseDetail) {
        PurchaseDetailResponseDTO responseDTO = new PurchaseDetailResponseDTO();
        responseDTO.setId(purchaseDetail.getId());
        responseDTO.setCode(purchaseDetail.getCode());
        responseDTO.setName(purchaseDetail.getName());
        responseDTO.setRemarks(purchaseDetail.getRemarks());
        if (purchaseDetail.getPurchaseHeader() != null) {
            responseDTO.setPurchaseHeader(purchaseHeaderMapper.convert(purchaseDetail.getPurchaseHeader()));
        }
        if (purchaseDetail.getProduct() != null) {
            responseDTO.setProduct(productMapper.convert(purchaseDetail.getProduct()));
        }
        responseDTO.setQty(purchaseDetail.getQuantity());
        responseDTO.setItemPrice(purchaseDetail.getItemPrice());
        responseDTO.setProductName(purchaseDetail.getProductName());
        return responseDTO;
    }
}
