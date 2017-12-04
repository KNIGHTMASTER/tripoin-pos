package com.tripoin.pos.desktop.swing.client.endpoint;

import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.SupplierResponseDTO;
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
public interface ISupplierEndPointClient {

    @GET("supplier/100004")
    Call<GenericListResponseDTO<SupplierResponseDTO>> findAll();

    @POST("supplier/100005")
    Call<ResponseGenericPaginationDTO<SupplierResponseDTO>> findPaginationAll(@Body RequestPaginationAllDTO p_RequestPaginationAllDTO);

    @POST("supplier/100031")
    Call<ResponseGenericPaginationDTO<SupplierResponseDTO>> findPaginationByCodeOrderById(@Body RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    @POST("supplier/100032")
    Call<ResponseGenericPaginationDTO<SupplierResponseDTO>> findPaginationByNameOrderById(@Body RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    @POST("supplier/100006")
    Call<GenericSingleDATAResponseDTO<SupplierResponseDTO>> findById(@Body RequestFindById p_RequestFindById);

    @POST("supplier/100023")
    Call<ResponseData> insert(@Body SupplierResponseDTO p_SupplierResponseDTO);

    @PUT("supplier/100022")
    Call<ResponseData> update(@Body SupplierResponseDTO p_SupplierResponseDTO);

    @HTTP(method = "DELETE", path = "supplier/100026", hasBody = true)
    Call<ResponseData> delete(@Body RequestDeleteById p_IdToDelete);

    @HTTP(method = "DELETE", path = "supplier/100029", hasBody = true)
    Call<ResponseData> deleteCollection(@Body List<String> p_ListOfIdToDelete);

    @GET("supplier/100017")
    Call<GenericListResponseDTO> selectLOV();
}
