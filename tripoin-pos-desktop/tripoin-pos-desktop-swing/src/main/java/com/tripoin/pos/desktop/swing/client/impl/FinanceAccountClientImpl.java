package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.IFinanceAccountClient;
import com.tripoin.pos.desktop.swing.client.base.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.endpoint.IFinanceAccountEndPointClient;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.master.FinanceAccountResponseDTO;
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
public class FinanceAccountClientImpl extends ARetrofitRestClient implements IFinanceAccountClient {

    private IFinanceAccountEndPointClient financeAccountEndPointClient;

    @PostConstruct
    @Override
    public void initComponents() {
        financeAccountEndPointClient = retrofitFactory.getRetrofit().create(IFinanceAccountEndPointClient.class);
    }

    @Override
    public Call<GenericListResponseDTO<FinanceAccountResponseDTO>> findAll() {
        return financeAccountEndPointClient.findAll();
    }

    @Override
    public Call<ResponseGenericPaginationDTO<FinanceAccountResponseDTO>> findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAllDTO) {
        return financeAccountEndPointClient.findPaginationAll(p_RequestPaginationAllDTO);
    }

    @Override
    public Call<GenericSingleDATAResponseDTO<FinanceAccountResponseDTO>> findById(RequestFindById p_RequestFindById) {
        return financeAccountEndPointClient.findById(p_RequestFindById);
    }

    @Override
    public Call<GenericListResponseDTO> selectLOV() {
        return financeAccountEndPointClient.selectLOV();
    }

    @Override
    public Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById) {
        return financeAccountEndPointClient.delete(p_RequestDeleteById);
    }

    @Override
    public Call<ResponseData> insert(FinanceAccountResponseDTO p_DATA) {
        return financeAccountEndPointClient.insert(p_DATA);
    }

    @Override
    public Call<ResponseData> update(FinanceAccountResponseDTO p_DATA) {
        return financeAccountEndPointClient.update(p_DATA);
    }

    @Override
    public Call<ResponseData> deleteCollectionById(List<String> p_ListOfIdToDelete) {
        return financeAccountEndPointClient.deleteCollection(p_ListOfIdToDelete);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<FinanceAccountResponseDTO>> findPaginationByCodeOrderById(RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO) {
        return financeAccountEndPointClient.findPaginationByCodeOrderById(p_RequestPaginationByCodeDTO);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<FinanceAccountResponseDTO>> findPaginationByNameOrderById(RequestPaginationByNameDTO p_RequestPaginationByNameDTO) {
        return financeAccountEndPointClient.findPaginationByNameOrderById(p_RequestPaginationByNameDTO);
    }
}