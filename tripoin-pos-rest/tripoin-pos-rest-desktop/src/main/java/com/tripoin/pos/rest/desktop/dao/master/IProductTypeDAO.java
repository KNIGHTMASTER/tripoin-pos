package com.tripoin.pos.rest.desktop.dao.master;

import com.tripoin.pos.shared.data.model.master.ProductType;
import com.tripoin.scaffolding.dao.IScaffoldingDAO;
import com.tripoin.scaffolding.dao.exception.DAOException;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IProductTypeDAO extends IScaffoldingDAO<ProductType> {

    @Query("SELECT id, name FROM ProductType a where a.productCategory.id = ?1")
    List<ProductType> selectLOVByProductType(Long p_ProductCategoryId) throws DAOException;

    @Query("SELECT a FROM ProductType a JOIN a.productCategory b WHERE b.code = ?1")
    List<ProductType> findByProductCategoryCode(String p_Code) throws DAOException;
}
