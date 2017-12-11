package com.tripoin.pos.rest.desktop.endpoint;

import com.tripoin.pos.shared.data.dto.request.SelectLOVProductTypeByProductCategoryRequestDTO;
import com.tripoin.pos.shared.data.model.master.ProductType;
import com.tripoin.scaffolding.data.dto.response.GenericListResponseDTO;
import com.tripoin.scaffolding.endpoint.IScaffoldingEndPoint;
import com.tripoin.scaffolding.endpoint.exception.EndPointException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IProductTypeEndPoint extends IScaffoldingEndPoint<ProductType> {
    @ResponseBody
    @PostMapping(
            value = {"/100030"}
    )
    GenericListResponseDTO selectLOVByProductType(@RequestBody SelectLOVProductTypeByProductCategoryRequestDTO p_ProductCategoryId) throws EndPointException;
}
