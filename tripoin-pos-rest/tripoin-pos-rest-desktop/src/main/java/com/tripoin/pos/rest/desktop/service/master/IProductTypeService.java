package com.tripoin.pos.rest.desktop.service.master;

import com.tripoin.pos.shared.data.model.master.ProductType;
import com.tripoin.scaffolding.service.IScaffoldingService;
import com.tripoin.scaffolding.service.exception.ServiceException;

import java.util.List;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IProductTypeService extends IScaffoldingService<ProductType> {
    List<ProductType> selectLOVByProductType(Long p_ProductCategoryId) throws ServiceException;
}
