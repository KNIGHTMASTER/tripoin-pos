package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.base.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.IProductCategoryClient;
import com.tripoin.pos.desktop.swing.client.endpoint.IProductCategoryEndPointClient;
import com.tripoin.pos.shared.data.dto.response.ProductCategoryResponseDTO;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
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
public class ProductCategoryClientImpl extends ARetrofitRestClient implements IProductCategoryClient {

    private IProductCategoryEndPointClient productCategoryEndPointClient;

    @PostConstruct
    @Override
    public void initComponents() {
        productCategoryEndPointClient = retrofitFactory.getRetrofit().create(IProductCategoryEndPointClient.class);
    }

    @Override
    public Call<GenericListResponseDTO<ProductCategoryResponseDTO>> findAll() {
        return productCategoryEndPointClient.findAll();
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductCategoryResponseDTO>> findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAllDTO) {
        return productCategoryEndPointClient.findPaginationAll(p_RequestPaginationAllDTO);
    }

    @Override
    public Call<GenericSingleDATAResponseDTO<ProductCategoryResponseDTO>> findById(RequestFindById p_RequestFindById) {
        return productCategoryEndPointClient.findById(p_RequestFindById);
    }

    @Override
    public Call<GenericListResponseDTO> selectLOV() {
        return productCategoryEndPointClient.selectLOV();
    }

    @Override
    public Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById) {
        return productCategoryEndPointClient.delete(p_RequestDeleteById);
    }

    @Override
    public Call<ResponseData> insert(ProductCategoryResponseDTO p_DATA) {
        return productCategoryEndPointClient.insert(p_DATA);
    }

    @Override
    public Call<ResponseData> update(ProductCategoryResponseDTO p_DATA) {
        return productCategoryEndPointClient.update(p_DATA);
    }

    @Override
    public Call<ResponseData> deleteCollectionById(List<String> p_ListOfIdToDelete) {
        return productCategoryEndPointClient.deleteCollection(p_ListOfIdToDelete);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductCategoryResponseDTO>> findPaginationByCodeOrderById(RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO) {
        return productCategoryEndPointClient.findPaginationByCodeOrderById(p_RequestPaginationByCodeDTO);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductCategoryResponseDTO>> findPaginationByNameOrderById(RequestPaginationByNameDTO p_RequestPaginationByNameDTO) {
        return productCategoryEndPointClient.findPaginationByNameOrderById(p_RequestPaginationByNameDTO);
    }
}