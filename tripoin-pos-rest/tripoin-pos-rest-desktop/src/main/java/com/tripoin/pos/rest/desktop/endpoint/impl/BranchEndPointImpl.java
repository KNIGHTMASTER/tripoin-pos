package com.tripoin.pos.rest.desktop.endpoint.impl;

import com.tripoin.pos.rest.desktop.endpoint.IBranchEndPoint;
import com.tripoin.pos.rest.desktop.service.IBranchService;
import com.tripoin.pos.shared.data.BranchMapper;
import com.tripoin.pos.shared.data.model.Branch;
import com.tripoin.scaffolding.endpoint.impl.AScaffoldingEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created on 11/1/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/branch")
public class BranchEndPointImpl extends AScaffoldingEndPoint<Branch> implements IBranchEndPoint {

    @Autowired
    private IBranchService branchService;

    @Autowired
    private BranchMapper branchMapper;

    @PostConstruct
    @Override
    public void init() {
        dataMapperIntegration = branchMapper;
        scaffoldingService = branchService;
    }
}
