package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.ISupplierEndPoint;
import com.tripoin.pos.rest.desktop.service.master.ISupplierService;
import com.tripoin.pos.shared.data.mapper.master.SupplierMapper;
import com.tripoin.pos.shared.data.model.master.Supplier;
import com.tripoin.scaffolding.endpoint.impl.AScaffoldingEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/supplier")
public class SupplierEndPointImpl extends AScaffoldingEndPoint<Supplier> implements ISupplierEndPoint {

    @Autowired
    private ISupplierService supplierService;

    @Autowired
    private SupplierMapper supplierMapper;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = supplierService;
        dataMapperIntegration = supplierMapper;
    }
}
