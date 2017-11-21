package com.tripoin.pos.rest.desktop.service.impl;

import com.tripoin.pos.rest.desktop.dao.IProductCategoryDAO;
import com.tripoin.pos.rest.desktop.service.IProductCategoryService;
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
public class ProductCategoryServiceImpl extends AScaffoldingService<ProductCategory> implements IProductCategoryService{

    @Autowired
    private IProductCategoryDAO productCategoryDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = productCategoryDAO;
    }
}
