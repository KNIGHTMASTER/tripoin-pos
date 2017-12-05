package com.tripoin.pos.rest.desktop.service.system.impl;

import com.tripoin.pos.rest.desktop.dao.system.IPosShiftDAO;
import com.tripoin.pos.rest.desktop.service.system.IPosShiftService;
import com.tripoin.pos.shared.data.model.system.PosShift;
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
public class PosShiftImpl extends AScaffoldingService<PosShift> implements IPosShiftService {
    @Autowired
    private IPosShiftDAO posShiftDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = posShiftDAO;
    }
}
