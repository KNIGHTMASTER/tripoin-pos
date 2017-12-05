package com.tripoin.pos.rest.desktop.service.security.impl;

import com.tripoin.pos.rest.desktop.dao.security.IUserProfileDAO;
import com.tripoin.pos.rest.desktop.service.security.IUserProfileService;
import com.tripoin.pos.shared.data.model.security.UserProfile;
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
public class UserProfileServiceImpl extends AScaffoldingService<UserProfile> implements IUserProfileService {

    @Autowired
    private IUserProfileDAO userProfileDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = userProfileDAO;
    }
}
