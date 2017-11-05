package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.ICompanyClient;
import com.tripoin.pos.desktop.swing.client.endpoint.ICompanyEndPointClient;
import com.tripoin.pos.shared.data.CompanyTableDTO;
import com.tripoin.scaffolding.data.dto.ResponseData;
import com.tripoin.scaffolding.data.dto.request.RequestDeleteById;
import com.tripoin.scaffolding.data.dto.request.RequestFindById;
import com.tripoin.scaffolding.data.dto.response.GenericListResponseDTO;
import com.tripoin.scaffolding.data.dto.response.GenericSingleDATAResponseDTO;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import javax.annotation.PostConstruct;

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
    public Call<GenericListResponseDTO<CompanyTableDTO>> findAll() {
        return companyClient.findAll();
    }

    @Override
    public Call<GenericSingleDATAResponseDTO<CompanyTableDTO>> findById(RequestFindById p_RequestFindById) {
        return companyClient.findById(p_RequestFindById);
    }

    @Override
    public Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById) {
        return companyClient.delete(p_RequestDeleteById);
    }

    @Override
    public Call<ResponseData> insert(CompanyTableDTO p_DATA) {
        return companyClient.insert(p_DATA);
    }

    @Override
    public Call<ResponseData> update(CompanyTableDTO p_DATA) {
        return companyClient.update(p_DATA);
    }
}