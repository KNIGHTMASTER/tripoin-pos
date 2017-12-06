package com.tripoin.pos.desktop.swing.client.endpoint;

import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.master.ProductResponseDTO;
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
public interface IProductEndPointClient {

    @GET("product/100004")
    Call<GenericListResponseDTO<ProductResponseDTO>> findAll();

    @POST("product/100005")
    Call<ResponseGenericPaginationDTO<ProductResponseDTO>> findPaginationAll(@Body RequestPaginationAllDTO p_RequestPaginationAllDTO);

    @POST("product/100031")
    Call<ResponseGenericPaginationDTO<ProductResponseDTO>> findPaginationByCodeOrderById(@Body RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    @POST("product/100032")
    Call<ResponseGenericPaginationDTO<ProductResponseDTO>> findPaginationByNameOrderById(@Body RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    @POST("product/100006")
    Call<GenericSingleDATAResponseDTO<ProductResponseDTO>> findById(@Body RequestFindById p_RequestFindById);

    @POST("product/100023")
    Call<ResponseData> insert(@Body ProductResponseDTO p_ProductResponseDTO);

    @PUT("product/100022")
    Call<ResponseData> update(@Body ProductResponseDTO p_ProductResponseDTO);

    @HTTP(method = "DELETE", path = "product/100026", hasBody = true)
    Call<ResponseData> delete(@Body RequestDeleteById p_IdToDelete);

    @HTTP(method = "DELETE", path = "product/100029", hasBody = true)
    Call<ResponseData> deleteCollection(@Body List<String> p_ListOfIdToDelete);

    @GET("product/100017")
    Call<GenericListResponseDTO> selectLOV();
}
