package com.tripoin.pos.desktop.swing.client.endpoint;

import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.ProductGuaranteeResponseDTO;
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
public interface IProductGuaranteeEndPointClient {

    @GET("productguarantee/100004")
    Call<GenericListResponseDTO<ProductGuaranteeResponseDTO>> findAll();

    @POST("productguarantee/100005")
    Call<ResponseGenericPaginationDTO<ProductGuaranteeResponseDTO>> findPaginationAll(@Body RequestPaginationAllDTO p_RequestPaginationAllDTO);

    @POST("productguarantee/100031")
    Call<ResponseGenericPaginationDTO<ProductGuaranteeResponseDTO>> findPaginationByCodeOrderById(@Body RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    @POST("productguarantee/100032")
    Call<ResponseGenericPaginationDTO<ProductGuaranteeResponseDTO>> findPaginationByNameOrderById(@Body RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    @POST("productguarantee/100006")
    Call<GenericSingleDATAResponseDTO<ProductGuaranteeResponseDTO>> findById(@Body RequestFindById p_RequestFindById);

    @POST("productguarantee/100023")
    Call<ResponseData> insert(@Body ProductGuaranteeResponseDTO p_ProductGuaranteeResponseDTO);

    @PUT("productguarantee/100022")
    Call<ResponseData> update(@Body ProductGuaranteeResponseDTO p_ProductGuaranteeResponseDTO);

    @HTTP(method = "DELETE", path = "productguarantee/100026", hasBody = true)
    Call<ResponseData> delete(@Body RequestDeleteById p_IdToDelete);

    @HTTP(method = "DELETE", path = "productguarantee/100029", hasBody = true)
    Call<ResponseData> deleteCollection(@Body List<String> p_ListOfIdToDelete);

    @GET("productguarantee/100017")
    Call<GenericListResponseDTO> selectLOV();
}
