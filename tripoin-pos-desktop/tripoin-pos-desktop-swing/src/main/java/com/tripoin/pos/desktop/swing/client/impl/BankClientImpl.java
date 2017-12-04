package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.IBankClient;
import com.tripoin.pos.desktop.swing.client.base.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.endpoint.IBankEndPointClient;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.BankResponseDTO;
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
public class BankClientImpl extends ARetrofitRestClient implements IBankClient {

    private IBankEndPointClient bankEndPointClient;

    @PostConstruct
    @Override
    public void initComponents() {
        bankEndPointClient = retrofitFactory.getRetrofit().create(IBankEndPointClient.class);
    }

    @Override
    public Call<GenericListResponseDTO<BankResponseDTO>> findAll() {
        return bankEndPointClient.findAll();
    }

    @Override
    public Call<ResponseGenericPaginationDTO<BankResponseDTO>> findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAllDTO) {
        return bankEndPointClient.findPaginationAll(p_RequestPaginationAllDTO);
    }

    @Override
    public Call<GenericSingleDATAResponseDTO<BankResponseDTO>> findById(RequestFindById p_RequestFindById) {
        return bankEndPointClient.findById(p_RequestFindById);
    }

    @Override
    public Call<GenericListResponseDTO> selectLOV() {
        return bankEndPointClient.selectLOV();
    }

    @Override
    public Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById) {
        return bankEndPointClient.delete(p_RequestDeleteById);
    }

    @Override
    public Call<ResponseData> insert(BankResponseDTO p_DATA) {
        return bankEndPointClient.insert(p_DATA);
    }

    @Override
    public Call<ResponseData> update(BankResponseDTO p_DATA) {
        return bankEndPointClient.update(p_DATA);
    }

    @Override
    public Call<ResponseData> deleteCollectionById(List<String> p_ListOfIdToDelete) {
        return bankEndPointClient.deleteCollection(p_ListOfIdToDelete);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<BankResponseDTO>> findPaginationByCodeOrderById(RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO) {
        return bankEndPointClient.findPaginationByCodeOrderById(p_RequestPaginationByCodeDTO);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<BankResponseDTO>> findPaginationByNameOrderById(RequestPaginationByNameDTO p_RequestPaginationByNameDTO) {
        return bankEndPointClient.findPaginationByNameOrderById(p_RequestPaginationByNameDTO);
    }
}