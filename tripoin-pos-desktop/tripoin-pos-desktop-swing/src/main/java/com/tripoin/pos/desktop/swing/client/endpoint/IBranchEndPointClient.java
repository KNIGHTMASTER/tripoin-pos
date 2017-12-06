package com.tripoin.pos.desktop.swing.client.endpoint;

import com.tripoin.pos.shared.data.dto.response.master.BranchResponseDTO;
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
public interface IBranchEndPointClient {

    @GET("branch/100004")
    Call<GenericListResponseDTO<BranchResponseDTO>> findAll();

    @POST("branch/100005")
    Call<ResponseGenericPaginationDTO<BranchResponseDTO>> findPaginationAll(@Body RequestPaginationAllDTO p_RequestPaginationAllDTO);

    @POST("branch/100031")
    Call<ResponseGenericPaginationDTO<BranchResponseDTO>> findPaginationByCodeOrderById(@Body RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    @POST("branch/100032")
    Call<ResponseGenericPaginationDTO<BranchResponseDTO>> findPaginationByNameOrderById(@Body RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    @POST("branch/100006")
    Call<GenericSingleDATAResponseDTO<BranchResponseDTO>> findById(@Body RequestFindById p_RequestFindById);

    @POST("branch/100023")
    Call<ResponseData> insert(@Body BranchResponseDTO p_BranchResponseDTO);

    @PUT("branch/100022")
    Call<ResponseData> update(@Body BranchResponseDTO p_BranchResponseDTO);

    @HTTP(method = "DELETE", path = "branch/100026", hasBody = true)
    Call<ResponseData> delete(@Body RequestDeleteById p_IdToDelete);

    @HTTP(method = "DELETE", path = "branch/100029", hasBody = true)
    Call<ResponseData> deleteCollection(@Body List<String> p_ListOfIdToDelete);

    @GET("branch/100017")
    Call<GenericListResponseDTO> selectLOV();
}
