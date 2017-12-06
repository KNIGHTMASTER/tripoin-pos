package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.IProductClient;
import com.tripoin.pos.desktop.swing.client.base.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.endpoint.IProductEndPointClient;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.master.ProductResponseDTO;
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
public class ProductClientImpl extends ARetrofitRestClient implements IProductClient {

    private IProductEndPointClient productEndPointClient;

    @PostConstruct
    @Override
    public void initComponents() {
        productEndPointClient = retrofitFactory.getRetrofit().create(IProductEndPointClient.class);
    }

    @Override
    public Call<GenericListResponseDTO<ProductResponseDTO>> findAll() {
        return productEndPointClient.findAll();
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductResponseDTO>> findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAllDTO) {
        return productEndPointClient.findPaginationAll(p_RequestPaginationAllDTO);
    }

    @Override
    public Call<GenericSingleDATAResponseDTO<ProductResponseDTO>> findById(RequestFindById p_RequestFindById) {
        return productEndPointClient.findById(p_RequestFindById);
    }

    @Override
    public Call<GenericListResponseDTO> selectLOV() {
        return productEndPointClient.selectLOV();
    }

    @Override
    public Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById) {
        return productEndPointClient.delete(p_RequestDeleteById);
    }

    @Override
    public Call<ResponseData> insert(ProductResponseDTO p_DATA) {
        return productEndPointClient.insert(p_DATA);
    }

    @Override
    public Call<ResponseData> update(ProductResponseDTO p_DATA) {
        return productEndPointClient.update(p_DATA);
    }

    @Override
    public Call<ResponseData> deleteCollectionById(List<String> p_ListOfIdToDelete) {
        return productEndPointClient.deleteCollection(p_ListOfIdToDelete);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductResponseDTO>> findPaginationByCodeOrderById(RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO) {
        return productEndPointClient.findPaginationByCodeOrderById(p_RequestPaginationByCodeDTO);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductResponseDTO>> findPaginationByNameOrderById(RequestPaginationByNameDTO p_RequestPaginationByNameDTO) {
        return productEndPointClient.findPaginationByNameOrderById(p_RequestPaginationByNameDTO);
    }
}