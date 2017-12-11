package com.tripoin.pos.desktop.swing.client.impl;

import com.tripoin.pos.desktop.swing.client.IPriceClient;
import com.tripoin.pos.desktop.swing.client.base.ARetrofitRestClient;
import com.tripoin.pos.desktop.swing.client.endpoint.IPriceEndPointClient;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.trx.PriceResponseDTO;
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
public class PriceClientImpl extends ARetrofitRestClient implements IPriceClient {

    private IPriceEndPointClient priceEndPointClient;

    @PostConstruct
    @Override
    public void initComponents() {
        priceEndPointClient = retrofitFactory.getRetrofit().create(IPriceEndPointClient.class);
    }

    @Override
    public Call<GenericListResponseDTO<PriceResponseDTO>> findAll() {
        return priceEndPointClient.findAll();
    }

    @Override
    public Call<ResponseGenericPaginationDTO<PriceResponseDTO>> findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAllDTO) {
        return priceEndPointClient.findPaginationAll(p_RequestPaginationAllDTO);
    }

    @Override
    public Call<GenericSingleDATAResponseDTO<PriceResponseDTO>> findById(RequestFindById p_RequestFindById) {
        return priceEndPointClient.findById(p_RequestFindById);
    }

    @Override
    public Call<GenericListResponseDTO> selectLOV() {
        return priceEndPointClient.selectLOV();
    }

    @Override
    public Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById) {
        return priceEndPointClient.delete(p_RequestDeleteById);
    }

    @Override
    public Call<ResponseData> insert(PriceResponseDTO p_DATA) {
        return priceEndPointClient.insert(p_DATA);
    }

    @Override
    public Call<ResponseData> update(PriceResponseDTO p_DATA) {
        return priceEndPointClient.update(p_DATA);
    }

    @Override
    public Call<ResponseData> deleteCollectionById(List<String> p_ListOfIdToDelete) {
        return priceEndPointClient.deleteCollection(p_ListOfIdToDelete);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<PriceResponseDTO>> findPaginationByCodeOrderById(RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO) {
        return priceEndPointClient.findPaginationByCodeOrderById(p_RequestPaginationByCodeDTO);
    }

    @Override
    public Call<ResponseGenericPaginationDTO<PriceResponseDTO>> findPaginationByNameOrderById(RequestPaginationByNameDTO p_RequestPaginationByNameDTO) {
        return priceEndPointClient.findPaginationByNameOrderById(p_RequestPaginationByNameDTO);
    }
}