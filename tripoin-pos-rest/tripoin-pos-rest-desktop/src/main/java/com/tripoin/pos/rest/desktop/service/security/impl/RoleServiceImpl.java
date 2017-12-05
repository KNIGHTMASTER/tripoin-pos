package com.tripoin.pos.rest.desktop.service.security.impl;

import com.tripoin.pos.rest.desktop.dao.security.IRoleDAO;
import com.tripoin.pos.rest.desktop.service.security.IRoleService;
import com.tripoin.pos.shared.data.model.security.Role;
import com.tripoin.scaffolding.service.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class RoleServiceImpl extends AScaffoldingService<Role> implements IRoleService {
    @Autowired
    private IRoleDAO roleDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = roleDAO;
    }
}
