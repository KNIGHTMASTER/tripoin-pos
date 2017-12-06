package com.tripoin.pos.desktop.swing.client.endpoint;

import com.tripoin.pos.shared.data.dto.response.master.CompanyResponseDTO;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
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
public interface ICompanyEndPointClient {

    @GET("company/100004")
    Call<GenericListResponseDTO<CompanyResponseDTO>> findAll();

    @POST("company/100005")
    Call<ResponseGenericPaginationDTO<CompanyResponseDTO>> findPaginationAll(@Body RequestPaginationAllDTO p_RequestPaginationAllDTO);

    @POST("company/100031")
    Call<ResponseGenericPaginationDTO<CompanyResponseDTO>> findPaginationByCodeOrderById(@Body RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    @POST("company/100032")
    Call<ResponseGenericPaginationDTO<CompanyResponseDTO>> findPaginationByNameOrderById(@Body RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    @POST("company/100006")
    Call<GenericSingleDATAResponseDTO<CompanyResponseDTO>> findById(@Body RequestFindById p_RequestFindById);

    @POST("company/100023")
    Call<ResponseData> insert(@Body CompanyResponseDTO p_CompanyResponseDTO);

    @PUT("company/100022")
    Call<ResponseData> update(@Body CompanyResponseDTO p_CompanyResponseDTO);

    @HTTP(method = "DELETE", path = "company/100026", hasBody = true)
    Call<ResponseData> delete(@Body RequestDeleteById p_IdToDelete);

    @HTTP(method = "DELETE", path = "company/100029", hasBody = true)
    Call<ResponseData> deleteCollection(@Body List<String> p_ListOfIdToDelete);

    @GET("company/100017")
    Call<GenericListResponseDTO> selectLOV();
}
