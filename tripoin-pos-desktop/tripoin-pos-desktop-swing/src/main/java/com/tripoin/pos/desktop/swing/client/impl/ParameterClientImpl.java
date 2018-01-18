package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.IParameterClient;
import com.tripoin.pos.desktop.swing.client.base.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.endpoint.IParameterEndPointClient;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.system.ParameterResponseDTO;
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
public class ParameterClientImpl extends ARetrofitRestClient implements IParameterClient {

    private IParameterEndPointClient parameterEndPointClient;

    @PostConstruct
    @Override
    public void initComponents() {
        parameterEndPointClient = retrofitFactory.getRetrofit().create(IParameterEndPointClient.class);
    }

    @Override
    public Call<GenericListResponseDTO<ParameterResponseDTO>> findAll() {
        return parameterEndPointClient.findAll();
    }

    @Override
    public Call<GenericListResponseDTO<ParameterResponseDTO>> findByCode(RequestFindByCode p_RequestFindByCode) {
        return parameterEndPointClient.findByCode(p_RequestFindByCode);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ParameterResponseDTO>> findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAllDTO) {
        return parameterEndPointClient.findPaginationAll(p_RequestPaginationAllDTO);
    }

    @Override
    public Call<GenericSingleDATAResponseDTO<ParameterResponseDTO>> findById(RequestFindById p_RequestFindById) {
        return parameterEndPointClient.findById(p_RequestFindById);
    }

    @Override
    public Call<GenericListResponseDTO> selectLOV() {
        return parameterEndPointClient.selectLOV();
    }

    @Override
    public Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById) {
        return parameterEndPointClient.delete(p_RequestDeleteById);
    }

    @Override
    public Call<ResponseData> insert(ParameterResponseDTO p_DATA) {
        return parameterEndPointClient.insert(p_DATA);
    }

    @Override
    public Call<ResponseData> update(ParameterResponseDTO p_DATA) {
        return parameterEndPointClient.update(p_DATA);
    }

    @Override
    public Call<ResponseData> deleteCollectionById(List<String> p_ListOfIdToDelete) {
        return parameterEndPointClient.deleteCollection(p_ListOfIdToDelete);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ParameterResponseDTO>> findPaginationByCodeOrderById(RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO) {
        return parameterEndPointClient.findPaginationByCodeOrderById(p_RequestPaginationByCodeDTO);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<ParameterResponseDTO>> findPaginationByNameOrderById(RequestPaginationByNameDTO p_RequestPaginationByNameDTO) {
        return parameterEndPointClient.findPaginationByNameOrderById(p_RequestPaginationByNameDTO);
    }
}