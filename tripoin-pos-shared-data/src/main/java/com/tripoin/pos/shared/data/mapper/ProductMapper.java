package com.tripoin.pos.shared.data.mapper;

import com.tripoin.pos.shared.data.dto.response.ProductResponseDTO;
import com.tripoin.pos.shared.data.model.master.Product;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProductMapper extends ADATAMapper<Product, ProductResponseDTO> {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Autowired
    private ProductBrandMapper productBrandMapper;

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private PriceMapper priceMapper;

    @Autowired
    private ProductStockMapper productStockMapper;

    @Override
    public ProductResponseDTO convert(Product product) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setId(product.getId());
        responseDTO.setCode(product.getCode());
        responseDTO.setName(product.getName());
        responseDTO.setRemarks(product.getRemarks());
        if (product.getProductCategory() != null) {
            responseDTO.setProductCategory(productCategoryMapper.convert(product.getProductCategory()));
        }
        if (product.getProductType() != null) {
            responseDTO.setProductType(productTypeMapper.convert(product.getProductType()));
        }
        if (product.getProductBrand() != null) {
            responseDTO.setProductBrand(productBrandMapper.convert(product.getProductBrand()));
        }
        if (product.getSupplier() != null) {
            responseDTO.setSupplier(supplierMapper.convert(product.getSupplier()));
        }
        if (product.getPrice() != null) {
            responseDTO.setPrice(priceMapper.convert(product.getPrice()));
        }
        if (product.getProductStock() != null) {
            responseDTO.setProductStock(productStockMapper.convert(product.getProductStock()));
        }
        return responseDTO;
    }
}
