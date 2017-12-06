package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.ISupplierClient;
import com.tripoin.pos.desktop.swing.client.base.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.endpoint.ISupplierEndPointClient;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.master.SupplierResponseDTO;
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
public class SupplierClientImpl extends ARetrofitRestClient implements ISupplierClient {

    private ISupplierEndPointClient supplierEndPointClient;

    @PostConstruct
    @Override
    public void initComponents() {
        supplierEndPointClient = retrofitFactory.getRetrofit().create(ISupplierEndPointClient.class);
    }

    @Override
    public Call<GenericListResponseDTO<SupplierResponseDTO>> findAll() {
        return supplierEndPointClient.findAll();
    }

    @Override
    public Call<ResponseGenericPaginationDTO<SupplierResponseDTO>> findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAllDTO) {
        return supplierEndPointClient.findPaginationAll(p_RequestPaginationAllDTO);
    }

    @Override
    public Call<GenericSingleDATAResponseDTO<SupplierResponseDTO>> findById(RequestFindById p_RequestFindById) {
        return supplierEndPointClient.findById(p_RequestFindById);
    }

    @Override
    public Call<GenericListResponseDTO> selectLOV() {
        return supplierEndPointClient.selectLOV();
    }

    @Override
    public Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById) {
        return supplierEndPointClient.delete(p_RequestDeleteById);
    }

    @Override
    public Call<ResponseData> insert(SupplierResponseDTO p_DATA) {
        return supplierEndPointClient.insert(p_DATA);
    }

    @Override
    public Call<ResponseData> update(SupplierResponseDTO p_DATA) {
        return supplierEndPointClient.update(p_DATA);
    }

    @Override
    public Call<ResponseData> deleteCollectionById(List<String> p_ListOfIdToDelete) {
        return supplierEndPointClient.deleteCollection(p_ListOfIdToDelete);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<SupplierResponseDTO>> findPaginationByCodeOrderById(RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO) {
        return supplierEndPointClient.findPaginationByCodeOrderById(p_RequestPaginationByCodeDTO);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<SupplierResponseDTO>> findPaginationByNameOrderById(RequestPaginationByNameDTO p_RequestPaginationByNameDTO) {
        return supplierEndPointClient.findPaginationByNameOrderById(p_RequestPaginationByNameDTO);
    }
}