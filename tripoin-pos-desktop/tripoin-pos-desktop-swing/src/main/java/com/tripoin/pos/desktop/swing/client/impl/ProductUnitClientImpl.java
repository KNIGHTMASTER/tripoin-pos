package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.IProductUnitClient;
import com.tripoin.pos.desktop.swing.client.base.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.endpoint.IProductUnitEndPointClient;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.ProductUnitResponseDTO;
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
public class ProductUnitClientImpl extends ARetrofitRestClient implements IProductUnitClient {

    private IProductUnitEndPointClient productUnitEndPointClient;

    @PostConstruct
    @Override
    public void initComponents() {
        productUnitEndPointClient = retrofitFactory.getRetrofit().create(IProductUnitEndPointClient.class);
    }

    @Override
    public Call<GenericListResponseDTO<ProductUnitResponseDTO>> findAll() {
        return productUnitEndPointClient.findAll();
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductUnitResponseDTO>> findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAllDTO) {
        return productUnitEndPointClient.findPaginationAll(p_RequestPaginationAllDTO);
    }

    @Override
    public Call<GenericSingleDATAResponseDTO<ProductUnitResponseDTO>> findById(RequestFindById p_RequestFindById) {
        return productUnitEndPointClient.findById(p_RequestFindById);
    }

    @Override
    public Call<GenericListResponseDTO> selectLOV() {
        return productUnitEndPointClient.selectLOV();
    }

    @Override
    public Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById) {
        return productUnitEndPointClient.delete(p_RequestDeleteById);
    }

    @Override
    public Call<ResponseData> insert(ProductUnitResponseDTO p_DATA) {
        return productUnitEndPointClient.insert(p_DATA);
    }

    @Override
    public Call<ResponseData> update(ProductUnitResponseDTO p_DATA) {
        return productUnitEndPointClient.update(p_DATA);
    }

    @Override
    public Call<ResponseData> deleteCollectionById(List<String> p_ListOfIdToDelete) {
        return productUnitEndPointClient.deleteCollection(p_ListOfIdToDelete);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductUnitResponseDTO>> findPaginationByCodeOrderById(RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO) {
        return productUnitEndPointClient.findPaginationByCodeOrderById(p_RequestPaginationByCodeDTO);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ProductUnitResponseDTO>> findPaginationByNameOrderById(RequestPaginationByNameDTO p_RequestPaginationByNameDTO) {
        return productUnitEndPointClient.findPaginationByNameOrderById(p_RequestPaginationByNameDTO);
    }
}