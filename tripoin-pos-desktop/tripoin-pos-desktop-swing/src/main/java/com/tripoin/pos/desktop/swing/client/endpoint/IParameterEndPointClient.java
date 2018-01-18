package com.tripoin.pos.desktop.swing.client.endpoint;

import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.system.ParameterResponseDTO;
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
public interface IParameterEndPointClient {

    @GET("parameter/100004")
    Call<GenericListResponseDTO<ParameterResponseDTO>> findAll();

    @POST("parameter/100007")
    Call<GenericListResponseDTO<ParameterResponseDTO>> findByCode(@Body RequestFindByCode p_RequestFindByCode);

    @POST("parameter/100005")
    Call<ResponseGenericPaginationDTO<ParameterResponseDTO>> findPaginationAll(@Body RequestPaginationAllDTO p_RequestPaginationAllDTO);

    @POST("parameter/100031")
    Call<ResponseGenericPaginationDTO<ParameterResponseDTO>> findPaginationByCodeOrderById(@Body RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    @POST("parameter/100032")
    Call<ResponseGenericPaginationDTO<ParameterResponseDTO>> findPaginationByNameOrderById(@Body RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    @POST("parameter/100006")
    Call<GenericSingleDATAResponseDTO<ParameterResponseDTO>> findById(@Body RequestFindById p_RequestFindById);

    @POST("parameter/100023")
    Call<ResponseData> insert(@Body ParameterResponseDTO p_ParameterResponseDTO);

    @PUT("parameter/100022")
    Call<ResponseData> update(@Body ParameterResponseDTO p_ParameterResponseDTO);

    @HTTP(method = "DELETE", path = "parameter/100026", hasBody = true)
    Call<ResponseData> delete(@Body RequestDeleteById p_IdToDelete);

    @HTTP(method = "DELETE", path = "parameter/100029", hasBody = true)
    Call<ResponseData> deleteCollection(@Body List<String> p_ListOfIdToDelete);

    @GET("parameter/100017")
    Call<GenericListResponseDTO> selectLOV();
}
