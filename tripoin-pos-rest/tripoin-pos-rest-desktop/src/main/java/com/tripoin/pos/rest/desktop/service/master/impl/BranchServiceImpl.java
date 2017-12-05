package com.tripoin.pos.rest.desktop.service.master.impl;

import com.tripoin.pos.rest.desktop.dao.master.IBranchDAO;
import com.tripoin.pos.rest.desktop.service.master.IBranchService;
import com.tripoin.pos.shared.data.model.master.Branch;
import com.tripoin.scaffolding.service.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 10/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class BranchServiceImpl extends AScaffoldingService<Branch> implements IBranchService {

    @Autowired
    private IBranchDAO branchDAO;

    @PostConstruct
    @Override
    public void init() {
        this.scaffoldingDAO = branchDAO;
    }
}
