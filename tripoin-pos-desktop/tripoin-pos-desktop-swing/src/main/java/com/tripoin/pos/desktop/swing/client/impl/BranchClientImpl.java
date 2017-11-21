package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.base.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.IBranchClient;
import com.tripoin.pos.desktop.swing.client.endpoint.IBranchEndPointClient;
import com.tripoin.pos.shared.data.dto.response.BranchResponseDTO;
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
public class BranchClientImpl extends ARetrofitRestClient implements IBranchClient {

    private IBranchEndPointClient branchClient;

    @PostConstruct
    @Override
    public void initComponents() {
        branchClient = retrofitFactory.getRetrofit().create(IBranchEndPointClient.class);
    }

    @Override
    public Call<GenericListResponseDTO<BranchResponseDTO>> findAll() {
        return branchClient.findAll();
    }

    @Override
    public Call<ResponseGenericPaginationDTO<BranchResponseDTO>> findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAllDTO) {
        return branchClient.findPaginationAll(p_RequestPaginationAllDTO);
    }

    @Override
    public Call<GenericSingleDATAResponseDTO<BranchResponseDTO>> findById(RequestFindById p_RequestFindById) {
        return branchClient.findById(p_RequestFindById);
    }

    @Override
    public Call<GenericListResponseDTO> selectLOV() {
        return branchClient.selectLOV();
    }

    @Override
    public Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById) {
        return branchClient.delete(p_RequestDeleteById);
    }

    @Override
    public Call<ResponseData> insert(BranchResponseDTO p_DATA) {
        return branchClient.insert(p_DATA);
    }

    @Override
    public Call<ResponseData> update(BranchResponseDTO p_DATA) {
        return branchClient.update(p_DATA);
    }

    @Override
    public Call<ResponseData> deleteCollectionById(List<String> p_ListOfIdToDelete) {
        return branchClient.deleteCollection(p_ListOfIdToDelete);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<BranchResponseDTO>> findPaginationByCodeOrderById(RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO) {
        return branchClient.findPaginationByCodeOrderById(p_RequestPaginationByCodeDTO);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<BranchResponseDTO>> findPaginationByNameOrderById(RequestPaginationByNameDTO p_RequestPaginationByNameDTO) {
        return branchClient.findPaginationByNameOrderById(p_RequestPaginationByNameDTO);
    }
}