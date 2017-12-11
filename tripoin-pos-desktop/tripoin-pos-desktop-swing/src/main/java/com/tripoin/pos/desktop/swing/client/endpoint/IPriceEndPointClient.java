package com.tripoin.pos.desktop.swing.client.endpoint;

import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.trx.PriceResponseDTO;
import com.tripoin.scaffolding.data.dto.ResponseData;
import com.tripoin.scaffolding.data.dto.request.*;
import com.tripoin.scaffolding.data.dto.response.GenericListResponseDTO;
import com.tripoin.scaffolding.data.dto.response.GenericSingleDATAResponseDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 *
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * <p>
 *    @see <a href=https://stackoverflow.com/questions/34181208/api-interfaces-must-not-extend-other-interfaces-retrofit-2?answertab=active#tab-top>API Interfaces must not extend other Interfaces</a>
 * </p>
 */
public interface IPriceEndPointClient {

    @GET("price/100004")
    Call<GenericListResponseDTO<PriceResponseDTO>> findAll();

    @POST("price/100005")
    Call<ResponseGenericPaginationDTO<PriceResponseDTO>> findPaginationAll(@Body RequestPaginationAllDTO p_RequestPaginationAllDTO);

    @POST("price/100031")
    Call<ResponseGenericPaginationDTO<PriceResponseDTO>> findPaginationByCodeOrderById(@Body RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    @POST("price/100032")
    Call<ResponseGenericPaginationDTO<PriceResponseDTO>> findPaginationByNameOrderById(@Body RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    @POST("price/100006")
    Call<GenericSingleDATAResponseDTO<PriceResponseDTO>> findById(@Body RequestFindById p_RequestFindById);

    @POST("price/100023")
    Call<ResponseData> insert(@Body PriceResponseDTO p_PriceResponseDTO);

    @PUT("price/100022")
    Call<ResponseData> update(@Body PriceResponseDTO p_PriceResponseDTO);

    @HTTP(method = "DELETE", path = "price/100026", hasBody = true)
    Call<ResponseData> delete(@Body RequestDeleteById p_IdToDelete);

    @HTTP(method = "DELETE", path = "price/100029", hasBody = true)
    Call<ResponseData> deleteCollection(@Body List<String> p_ListOfIdToDelete);

    @GET("price/100017")
    Call<GenericListResponseDTO> selectLOV();
}
