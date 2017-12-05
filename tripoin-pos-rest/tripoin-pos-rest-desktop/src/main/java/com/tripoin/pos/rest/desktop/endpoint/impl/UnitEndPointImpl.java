package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.IUnitEndPoint;
import com.tripoin.pos.rest.desktop.service.master.IUnitService;
import com.tripoin.pos.shared.data.mapper.UnitMapper;
import com.tripoin.pos.shared.data.model.master.ProductUnit;
import com.tripoin.scaffolding.endpoint.impl.AScaffoldingEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created on 12/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/productunit")
public class UnitEndPointImpl extends AScaffoldingEndPoint<ProductUnit> implements IUnitEndPoint {

    @Autowired
    private IUnitService unitService;

    @Autowired
    private UnitMapper unitMapper;


    @PostConstruct
    @Override
    public void init() {
        dataMapperIntegration = unitMapper;
        scaffoldingService = unitService;
    }
}
