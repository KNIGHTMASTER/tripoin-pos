package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.IProductCategoryEndPoint;
import com.tripoin.pos.rest.desktop.service.master.IProductCategoryService;
import com.tripoin.pos.shared.data.mapper.master.ProductCategoryMapper;
import com.tripoin.pos.shared.data.model.master.ProductCategory;
import com.tripoin.scaffolding.endpoint.impl.AScaffoldingEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created on 11/19/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/productcategory")
public class ProductCategoryEndPointImpl extends AScaffoldingEndPoint<ProductCategory> implements IProductCategoryEndPoint {

    @Autowired
    private IProductCategoryService productCategoryService;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = productCategoryService;
        dataMapperIntegration = productCategoryMapper;
    }
}
