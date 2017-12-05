package com.tripoin.pos.rest.desktop.service.security.impl;

import com.tripoin.pos.rest.desktop.dao.security.IUserDAO;
import com.tripoin.pos.rest.desktop.service.security.IUserService;
import com.tripoin.pos.shared.data.model.security.User;
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
public class UserServiceImpl extends AScaffoldingService<User> implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = userDAO;
    }
}
