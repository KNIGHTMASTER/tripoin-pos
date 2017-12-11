package com.tripoin.pos.rest.desktop.service.master.impl;

import com.tripoin.pos.rest.desktop.dao.master.IProductTypeDAO;
import com.tripoin.pos.rest.desktop.service.master.IProductTypeService;
import com.tripoin.pos.shared.data.model.master.ProductType;
import com.tripoin.scaffolding.dao.exception.DAOException;
import com.tripoin.scaffolding.service.exception.ServiceException;
import com.tripoin.scaffolding.service.impl.AScaffoldingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProductTypeServiceImpl extends AScaffoldingService<ProductType> implements IProductTypeService {

    @Autowired
    private IProductTypeDAO productTypeDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTypeServiceImpl.class);

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = productTypeDAO;
    }

    @Override
    public List<ProductType> selectLOVByProductType(Long p_ProductCategoryId) throws ServiceException {
        List<ProductType> result = null;
        try {
            result = productTypeDAO.selectLOVByProductType(p_ProductCategoryId);
        } catch (DAOException e) {
            LOGGER.error(e.toString());
        }
        return result;
    }
}
