package com.tripoin.pos.desktop.swing.client.endpoint;

import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.master.FinanceAccountResponseDTO;
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
public interface IFinanceAccountEndPointClient {

    @GET("financeaccount/100004")
    Call<GenericListResponseDTO<FinanceAccountResponseDTO>> findAll();

    @POST("financeaccount/100005")
    Call<ResponseGenericPaginationDTO<FinanceAccountResponseDTO>> findPaginationAll(@Body RequestPaginationAllDTO p_RequestPaginationAllDTO);

    @POST("financeaccount/100031")
    Call<ResponseGenericPaginationDTO<FinanceAccountResponseDTO>> findPaginationByCodeOrderById(@Body RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    @POST("financeaccount/100032")
    Call<ResponseGenericPaginationDTO<FinanceAccountResponseDTO>> findPaginationByNameOrderById(@Body RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    @POST("financeaccount/100006")
    Call<GenericSingleDATAResponseDTO<FinanceAccountResponseDTO>> findById(@Body RequestFindById p_RequestFindById);

    @POST("financeaccount/100023")
    Call<ResponseData> insert(@Body FinanceAccountResponseDTO p_FinanceAccountResponseDTO);

    @PUT("financeaccount/100022")
    Call<ResponseData> update(@Body FinanceAccountResponseDTO p_FinanceAccountResponseDTO);

    @HTTP(method = "DELETE", path = "financeaccount/100026", hasBody = true)
    Call<ResponseData> delete(@Body RequestDeleteById p_IdToDelete);

    @HTTP(method = "DELETE", path = "financeaccount/100029", hasBody = true)
    Call<ResponseData> deleteCollection(@Body List<String> p_ListOfIdToDelete);

    @GET("financeaccount/100017")
    Call<GenericListResponseDTO> selectLOV();
}
