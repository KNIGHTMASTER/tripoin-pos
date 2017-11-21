package com.tripoin.pos.rest.desktop.service.impl;

import com.tripoin.pos.rest.desktop.dao.ISupplierDAO;
import com.tripoin.pos.rest.desktop.service.ISupplierService;
import com.tripoin.pos.shared.data.model.Supplier;
import com.tripoin.scaffolding.service.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class SupplierServiceImpl extends AScaffoldingService<Supplier> implements ISupplierService {
    @Autowired
    private ISupplierDAO supplierDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = supplierDAO;
    }
}
