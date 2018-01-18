package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.IProductTypeClient;
import com.tripoin.pos.desktop.swing.client.base.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.endpoint.IProductTypeEndPointClient;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.request.SelectLOVProductTypeByProductCategoryRequestDTO;
import com.tripoin.pos.shared.data.dto.response.master.ProductTypeResponseDTO;
import com.tripoin.scaffolding.data.dto.ResponseData;
import com.tripoin.scaffolding.data.dto.request.*;
import com.tripoin.scaffolding.data.dto.response.GenericListResponseDTO;
import com.tripoin.scaffolding.data.dto.response.GenericSingleDATAResponseDTO;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProductTypeClientImpl extends ARetrofitRestClient implements IProductTypeClient {

    private IProductTypeEndPointClient productTypeEndPointClient;

    @PostConstruct
    @Override
    public void initComponents() {
        productTypeEndPointClient = retrofitFactory.getRetrofit().create(IProductTypeEndPointClient.class);
    }

    @Override
    public Call<GenericListResponseDTO<ProductTypeResponseDTO>> findAll() {
        return productTypeEndPointClient.findAll();
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductTypeResponseDTO>> findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAllDTO) {
        return productTypeEndPointClient.findPaginationAll(p_RequestPaginationAllDTO);
    }

    @Override
    public Call<GenericSingleDATAResponseDTO<ProductTypeResponseDTO>> findById(RequestFindById p_RequestFindById) {
        return productTypeEndPointClient.findById(p_RequestFindById);
    }

    @Override
    public Call<GenericListResponseDTO> selectLOV() {
        return productTypeEndPointClient.selectLOV();
    }

    @Override
    public Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById) {
        return productTypeEndPointClient.delete(p_RequestDeleteById);
    }

    @Override
    public Call<ResponseData> insert(ProductTypeResponseDTO p_DATA) {
        return productTypeEndPointClient.insert(p_DATA);
    }

    @Override
    public Call<ResponseData> update(ProductTypeResponseDTO p_DATA) {
        return productTypeEndPointClient.update(p_DATA);
    }

    @Override
    public Call<ResponseData> deleteCollectionById(List<String> p_ListOfIdToDelete) {
        return productTypeEndPointClient.deleteCollection(p_ListOfIdToDelete);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductTypeResponseDTO>> findPaginationByCodeOrderById(RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO) {
        return productTypeEndPointClient.findPaginationByCodeOrderById(p_RequestPaginationByCodeDTO);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductTypeResponseDTO>> findPaginationByNameOrderById(RequestPaginationByNameDTO p_RequestPaginationByNameDTO) {
        return productTypeEndPointClient.findPaginationByNameOrderById(p_RequestPaginationByNameDTO);
    }

    @Override
    public Call<GenericListResponseDTO> selectLOVByProductCategory(SelectLOVProductTypeByProductCategoryRequestDTO productTypeByProductCategoryRequestDTO) {
        return productTypeEndPointClient.selectLOVByProductCategory(productTypeByProductCategoryRequestDTO);
    }

    @Override
    public Call<GenericListResponseDTO<ProductTypeResponseDTO>> findByProductCategoryCode(RequestFindByCode p_RequestFindByCode) {
        return productTypeEndPointClient.findByProductCategoryCode(p_RequestFindByCode);
    }
}