package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.IProductTypeEndPoint;
import com.tripoin.pos.rest.desktop.service.master.IProductTypeService;
import com.tripoin.pos.shared.data.dto.request.SelectLOVProductTypeByProductCategoryRequestDTO;
import com.tripoin.pos.shared.data.mapper.master.ProductTypeMapper;
import com.tripoin.pos.shared.data.model.master.ProductType;
import com.tripoin.scaffolding.data.constant.EResponseCode;
import com.tripoin.scaffolding.data.dto.ResponseData;
import com.tripoin.scaffolding.data.dto.request.RequestFindByCode;
import com.tripoin.scaffolding.data.dto.response.GenericListResponseDTO;
import com.tripoin.scaffolding.endpoint.exception.EndPointException;
import com.tripoin.scaffolding.endpoint.impl.AScaffoldingEndPoint;
import com.tripoin.scaffolding.service.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/producttype")
public class ProductTypeEndPointImpl extends AScaffoldingEndPoint<ProductType> implements IProductTypeEndPoint {
    @Autowired
    private IProductTypeService productTypeService;

    @Autowired
    private ProductTypeMapper productTypeMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTypeEndPointImpl.class);

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = productTypeService;
        dataMapperIntegration = productTypeMapper;
    }

    @Override
    public GenericListResponseDTO selectLOVByProductType(@RequestBody SelectLOVProductTypeByProductCategoryRequestDTO p_ProductCategoryId) {
        GenericListResponseDTO result = new GenericListResponseDTO();
        result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        try {
            result = this.scaffoldingResponseConstructor.constructListFindResponse(productTypeService.selectLOVByProductType(Long.valueOf(p_ProductCategoryId.getProductCategoryId())));
        } catch (EndPointException | ServiceException e) {
            LOGGER.error(e.toString());
        }

        return result;
    }

    @Override
    public GenericListResponseDTO findByProductCategoryCode(@RequestBody RequestFindByCode p_RequestFindByCode) throws EndPointException {
        GenericListResponseDTO result = new GenericListResponseDTO();
        result.setResponseData(new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg()));
        try {
            if(this.dataMapperIntegration != null) {
                result = this.scaffoldingResponseConstructor.constructDTOListFindResponse(this.dataMapperIntegration.mapEntitiesIntoDTOs(this.productTypeService.findByProductCategoryCode(p_RequestFindByCode.getCode())));
            }
        } catch (EndPointException | ServiceException e) {
            LOGGER.error(e.toString());
        }

        return result;
    }
}
