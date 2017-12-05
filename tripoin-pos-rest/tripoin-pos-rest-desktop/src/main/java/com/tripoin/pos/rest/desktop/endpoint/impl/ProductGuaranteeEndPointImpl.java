package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.IProductGuaranteeEndPoint;
import com.tripoin.pos.rest.desktop.service.master.IProductGuaranteeService;
import com.tripoin.pos.shared.data.mapper.ProductGuaranteeMapper;
import com.tripoin.pos.shared.data.model.master.ProductGuarantee;
import com.tripoin.scaffolding.endpoint.impl.AScaffoldingEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created on 11/21/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/productguarantee")
public class ProductGuaranteeEndPointImpl extends AScaffoldingEndPoint<ProductGuarantee> implements IProductGuaranteeEndPoint {
    @Autowired
    private IProductGuaranteeService productGuaranteeService;

    @Autowired
    private ProductGuaranteeMapper productGuaranteeMapper;

    @PostConstruct
    @Override
    public void init() {
        dataMapperIntegration = productGuaranteeMapper;
        scaffoldingService = productGuaranteeService;
    }
}
