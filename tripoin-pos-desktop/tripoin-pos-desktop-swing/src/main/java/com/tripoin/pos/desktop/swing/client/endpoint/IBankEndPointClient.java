package com.tripoin.pos.desktop.swing.client.endpoint;

import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.BankResponseDTO;
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
public interface IBankEndPointClient {

    @GET("bank/100004")
    Call<GenericListResponseDTO<BankResponseDTO>> findAll();

    @POST("bank/100005")
    Call<ResponseGenericPaginationDTO<BankResponseDTO>> findPaginationAll(@Body RequestPaginationAllDTO p_RequestPaginationAllDTO);

    @POST("bank/100031")
    Call<ResponseGenericPaginationDTO<BankResponseDTO>> findPaginationByCodeOrderById(@Body RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    @POST("bank/100032")
    Call<ResponseGenericPaginationDTO<BankResponseDTO>> findPaginationByNameOrderById(@Body RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    @POST("bank/100006")
    Call<GenericSingleDATAResponseDTO<BankResponseDTO>> findById(@Body RequestFindById p_RequestFindById);

    @POST("bank/100023")
    Call<ResponseData> insert(@Body BankResponseDTO p_BankResponseDTO);

    @PUT("bank/100022")
    Call<ResponseData> update(@Body BankResponseDTO p_BankResponseDTO);

    @HTTP(method = "DELETE", path = "bank/100026", hasBody = true)
    Call<ResponseData> delete(@Body RequestDeleteById p_IdToDelete);

    @HTTP(method = "DELETE", path = "bank/100029", hasBody = true)
    Call<ResponseData> deleteCollection(@Body List<String> p_ListOfIdToDelete);

    @GET("bank/100017")
    Call<GenericListResponseDTO> selectLOV();
}
