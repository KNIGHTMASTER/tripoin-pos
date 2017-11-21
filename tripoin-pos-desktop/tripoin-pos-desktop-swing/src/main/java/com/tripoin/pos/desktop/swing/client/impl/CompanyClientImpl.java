package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.base.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.ICompanyClient;
import com.tripoin.pos.desktop.swing.client.endpoint.ICompanyEndPointClient;
import com.tripoin.pos.shared.data.dto.response.CompanyResponseDTO;
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
public class CompanyClientImpl extends ARetrofitRestClient implements ICompanyClient {

    private ICompanyEndPointClient companyClient;

    @PostConstruct
    @Override
    public void initComponents() {
        companyClient = retrofitFactory.getRetrofit().create(ICompanyEndPointClient.class);
    }

    @Override
    public Call<GenericListResponseDTO<CompanyResponseDTO>> findAll() {
        return companyClient.findAll();
    }

    @Override
    public Call<ResponseGenericPaginationDTO<CompanyResponseDTO>> findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAllDTO) {
        return companyClient.findPaginationAll(p_RequestPaginationAllDTO);
    }

    @Override
    public Call<GenericSingleDATAResponseDTO<CompanyResponseDTO>> findById(RequestFindById p_RequestFindById) {
        return companyClient.findById(p_RequestFindById);
    }

    @Override
    public Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById) {
        return companyClient.delete(p_RequestDeleteById);
    }

    @Override
    public Call<ResponseData> insert(CompanyResponseDTO p_DATA) {
        return companyClient.insert(p_DATA);
    }

    @Override
    public Call<ResponseData> update(CompanyResponseDTO p_DATA) {
        return companyClient.update(p_DATA);
    }

    @Override
    public Call<ResponseData> deleteCollectionById(List<String> p_ListOfIdToDelete) {
        return companyClient.deleteCollection(p_ListOfIdToDelete);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<CompanyResponseDTO>> findPaginationByCodeOrderById(RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO) {
        return companyClient.findPaginationByCodeOrderById(p_RequestPaginationByCodeDTO);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<CompanyResponseDTO>> findPaginationByNameOrderById(RequestPaginationByNameDTO p_RequestPaginationByNameDTO) {
        return companyClient.findPaginationByNameOrderById(p_RequestPaginationByNameDTO);
    }

    @Override
    public Call<GenericListResponseDTO> selectLOV() {
        return companyClient.selectLOV();
    }
}