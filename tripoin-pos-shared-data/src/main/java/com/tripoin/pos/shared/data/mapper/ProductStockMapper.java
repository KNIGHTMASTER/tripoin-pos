package com.tripoin.pos.shared.data.mapper;

import com.tripoin.pos.shared.data.dto.response.ProductStockResponseDTO;
import com.tripoin.pos.shared.data.model.ProductStock;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProductStockMapper extends ADATAMapper<ProductStock, ProductStockResponseDTO> {

    @Autowired
    private UnitMapper unitMapper;

    @Override
    public ProductStockResponseDTO convert(ProductStock productStock) {
        ProductStockResponseDTO responseDTO = new ProductStockResponseDTO();
        responseDTO.setId(productStock.getId());
        responseDTO.setCode(productStock.getCode());
        responseDTO.setName(productStock.getName());
        responseDTO.setRemarks(productStock.getRemarks());
        responseDTO.setWarehouseStock(productStock.getWarehouseStock());
        responseDTO.setDisplayStock(productStock.getDisplayStock());
        if (productStock.getProductUnit() != null) {
            responseDTO.setUnit(unitMapper.convert(productStock.getProductUnit()));
        }
        return responseDTO;
    }
}
