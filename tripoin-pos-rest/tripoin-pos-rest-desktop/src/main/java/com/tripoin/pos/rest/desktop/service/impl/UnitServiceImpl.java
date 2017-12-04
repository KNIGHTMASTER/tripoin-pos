package com.tripoin.pos.rest.desktop.service.impl;

import com.tripoin.pos.rest.desktop.dao.IUnitDAO;
import com.tripoin.pos.rest.desktop.service.IUnitService;
import com.tripoin.pos.shared.data.model.ProductUnit;
import com.tripoin.scaffolding.service.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 11/22/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class UnitServiceImpl extends AScaffoldingService<ProductUnit> implements IUnitService {
    @Autowired
    private IUnitDAO unitDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = unitDAO;
    }
}
