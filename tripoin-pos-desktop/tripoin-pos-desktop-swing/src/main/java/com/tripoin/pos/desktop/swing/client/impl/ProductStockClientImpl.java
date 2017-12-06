package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.base.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.endpoint.IProductStockClient;
import com.tripoin.pos.desktop.swing.client.endpoint.IProductStockEndPointClient;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.master.ProductStockResponseDTO;
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
public class ProductStockClientImpl extends ARetrofitRestClient implements IProductStockClient {

    private IProductStockEndPointClient productStockEndPointClient;

    @PostConstruct
    @Override
    public void initComponents() {
        productStockEndPointClient = retrofitFactory.getRetrofit().create(IProductStockEndPointClient.class);
    }

    @Override
    public Call<GenericListResponseDTO<ProductStockResponseDTO>> findAll() {
        return productStockEndPointClient.findAll();
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductStockResponseDTO>> findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAllDTO) {
        return productStockEndPointClient.findPaginationAll(p_RequestPaginationAllDTO);
    }

    @Override
    public Call<GenericSingleDATAResponseDTO<ProductStockResponseDTO>> findById(RequestFindById p_RequestFindById) {
        return productStockEndPointClient.findById(p_RequestFindById);
    }

    @Override
    public Call<GenericListResponseDTO> selectLOV() {
        return productStockEndPointClient.selectLOV();
    }

    @Override
    public Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById) {
        return productStockEndPointClient.delete(p_RequestDeleteById);
    }

    @Override
    public Call<ResponseData> insert(ProductStockResponseDTO p_DATA) {
        return productStockEndPointClient.insert(p_DATA);
    }

    @Override
    public Call<ResponseData> update(ProductStockResponseDTO p_DATA) {
        return productStockEndPointClient.update(p_DATA);
    }

    @Override
    public Call<ResponseData> deleteCollectionById(List<String> p_ListOfIdToDelete) {
        return productStockEndPointClient.deleteCollection(p_ListOfIdToDelete);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductStockResponseDTO>> findPaginationByCodeOrderById(RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO) {
        return productStockEndPointClient.findPaginationByCodeOrderById(p_RequestPaginationByCodeDTO);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductStockResponseDTO>> findPaginationByNameOrderById(RequestPaginationByNameDTO p_RequestPaginationByNameDTO) {
        return productStockEndPointClient.findPaginationByNameOrderById(p_RequestPaginationByNameDTO);
    }
}