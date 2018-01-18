package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.IParameterEndPoint;
import com.tripoin.pos.rest.desktop.service.system.IParameterService;
import com.tripoin.pos.shared.data.mapper.system.ParameterMapper;
import com.tripoin.pos.shared.data.model.system.Parameter;
import com.tripoin.scaffolding.endpoint.impl.AScaffoldingEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created on 11/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/parameter")
public class ParameterEndPointImpl extends AScaffoldingEndPoint<Parameter> implements IParameterEndPoint {

    @Autowired
    private IParameterService parameterService;

    @Autowired
    private ParameterMapper parameterMapper;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = parameterService;
        dataMapperIntegration = parameterMapper;
    }
}
