package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.IProductBrandClient;
import com.tripoin.pos.desktop.swing.client.base.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.endpoint.IProductBrandEndPointClient;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.master.ProductBrandResponseDTO;
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
public class ProductBrandClientImpl extends ARetrofitRestClient implements IProductBrandClient {

    private IProductBrandEndPointClient productBrandEndPointClient;

    @PostConstruct
    @Override
    public void initComponents() {
        productBrandEndPointClient = retrofitFactory.getRetrofit().create(IProductBrandEndPointClient.class);
    }

    @Override
    public Call<GenericListResponseDTO<ProductBrandResponseDTO>> findAll() {
        return productBrandEndPointClient.findAll();
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductBrandResponseDTO>> findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAllDTO) {
        return productBrandEndPointClient.findPaginationAll(p_RequestPaginationAllDTO);
    }

    @Override
    public Call<GenericSingleDATAResponseDTO<ProductBrandResponseDTO>> findById(RequestFindById p_RequestFindById) {
        return productBrandEndPointClient.findById(p_RequestFindById);
    }

    @Override
    public Call<GenericListResponseDTO> selectLOV() {
        return productBrandEndPointClient.selectLOV();
    }

    @Override
    public Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById) {
        return productBrandEndPointClient.delete(p_RequestDeleteById);
    }

    @Override
    public Call<ResponseData> insert(ProductBrandResponseDTO p_DATA) {
        return productBrandEndPointClient.insert(p_DATA);
    }

    @Override
    public Call<ResponseData> update(ProductBrandResponseDTO p_DATA) {
        return productBrandEndPointClient.update(p_DATA);
    }

    @Override
    public Call<ResponseData> deleteCollectionById(List<String> p_ListOfIdToDelete) {
        return productBrandEndPointClient.deleteCollection(p_ListOfIdToDelete);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductBrandResponseDTO>> findPaginationByCodeOrderById(RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO) {
        return productBrandEndPointClient.findPaginationByCodeOrderById(p_RequestPaginationByCodeDTO);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductBrandResponseDTO>> findPaginationByNameOrderById(RequestPaginationByNameDTO p_RequestPaginationByNameDTO) {
        return productBrandEndPointClient.findPaginationByNameOrderById(p_RequestPaginationByNameDTO);
    }
}