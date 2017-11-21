package com.tripoin.pos.rest.desktop.service.impl;

import com.tripoin.pos.rest.desktop.dao.IProductBrandDAO;
import com.tripoin.pos.rest.desktop.service.IProductBrandService;
import com.tripoin.pos.rest.desktop.service.IProductCategoryService;
import com.tripoin.pos.shared.data.model.ProductBrand;
import com.tripoin.pos.shared.data.model.ProductCategory;
import com.tripoin.scaffolding.service.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 11/19/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProductBrandServiceImpl extends AScaffoldingService<ProductBrand> implements IProductBrandService{

    @Autowired
    private IProductBrandDAO productBrandDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = productBrandDAO;
    }
}
