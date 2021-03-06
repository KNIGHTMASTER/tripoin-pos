package com.tripoin.pos.rest.desktop.service.master.impl;

import com.tripoin.pos.rest.desktop.dao.master.IEmployeeDAO;
import com.tripoin.pos.rest.desktop.service.master.IEmployeeService;
import com.tripoin.pos.shared.data.model.master.Employee;
import com.tripoin.scaffolding.service.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class EmployeeServiceImpl extends AScaffoldingService<Employee> implements IEmployeeService {

    @Autowired
    private IEmployeeDAO employeeDAO;

    @PostConstruct
    @Override
    public void init() {
        this.scaffoldingDAO = employeeDAO;
    }
}
