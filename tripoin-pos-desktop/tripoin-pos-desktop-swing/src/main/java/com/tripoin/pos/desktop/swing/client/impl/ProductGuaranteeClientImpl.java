package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.IProductGuaranteeClient;
import com.tripoin.pos.desktop.swing.client.base.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.endpoint.IProductGuaranteeEndPointClient;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.ProductGuaranteeResponseDTO;
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
public class ProductGuaranteeClientImpl extends ARetrofitRestClient implements IProductGuaranteeClient {

    private IProductGuaranteeEndPointClient productGuaranteeEndPointClient;

    @PostConstruct
    @Override
    public void initComponents() {
        productGuaranteeEndPointClient = retrofitFactory.getRetrofit().create(IProductGuaranteeEndPointClient.class);
    }

    @Override
    public Call<GenericListResponseDTO<ProductGuaranteeResponseDTO>> findAll() {
        return productGuaranteeEndPointClient.findAll();
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductGuaranteeResponseDTO>> findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAllDTO) {
        return productGuaranteeEndPointClient.findPaginationAll(p_RequestPaginationAllDTO);
    }

    @Override
    public Call<GenericSingleDATAResponseDTO<ProductGuaranteeResponseDTO>> findById(RequestFindById p_RequestFindById) {
        return productGuaranteeEndPointClient.findById(p_RequestFindById);
    }

    @Override
    public Call<GenericListResponseDTO> selectLOV() {
        return productGuaranteeEndPointClient.selectLOV();
    }

    @Override
    public Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById) {
        return productGuaranteeEndPointClient.delete(p_RequestDeleteById);
    }

    @Override
    public Call<ResponseData> insert(ProductGuaranteeResponseDTO p_DATA) {
        return productGuaranteeEndPointClient.insert(p_DATA);
    }

    @Override
    public Call<ResponseData> update(ProductGuaranteeResponseDTO p_DATA) {
        return productGuaranteeEndPointClient.update(p_DATA);
    }

    @Override
    public Call<ResponseData> deleteCollectionById(List<String> p_ListOfIdToDelete) {
        return productGuaranteeEndPointClient.deleteCollection(p_ListOfIdToDelete);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductGuaranteeResponseDTO>> findPaginationByCodeOrderById(RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO) {
        return productGuaranteeEndPointClient.findPaginationByCodeOrderById(p_RequestPaginationByCodeDTO);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductGuaranteeResponseDTO>> findPaginationByNameOrderById(RequestPaginationByNameDTO p_RequestPaginationByNameDTO) {
        return productGuaranteeEndPointClient.findPaginationByNameOrderById(p_RequestPaginationByNameDTO);
    }
}