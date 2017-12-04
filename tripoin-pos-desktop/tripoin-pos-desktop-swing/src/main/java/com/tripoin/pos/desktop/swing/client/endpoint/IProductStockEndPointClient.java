package com.tripoin.pos.desktop.swing.client.endpoint;

import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.ProductStockResponseDTO;
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
public interface IProductStockEndPointClient {

    @GET("productstock/100004")
    Call<GenericListResponseDTO<ProductStockResponseDTO>> findAll();

    @POST("productstock/100005")
    Call<ResponseGenericPaginationDTO<ProductStockResponseDTO>> findPaginationAll(@Body RequestPaginationAllDTO p_RequestPaginationAllDTO);

    @POST("productstock/100031")
    Call<ResponseGenericPaginationDTO<ProductStockResponseDTO>> findPaginationByCodeOrderById(@Body RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    @POST("productstock/100032")
    Call<ResponseGenericPaginationDTO<ProductStockResponseDTO>> findPaginationByNameOrderById(@Body RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    @POST("productstock/100006")
    Call<GenericSingleDATAResponseDTO<ProductStockResponseDTO>> findById(@Body RequestFindById p_RequestFindById);

    @POST("productstock/100023")
    Call<ResponseData> insert(@Body ProductStockResponseDTO p_ProductStockResponseDTO);

    @PUT("productstock/100022")
    Call<ResponseData> update(@Body ProductStockResponseDTO p_ProductStockResponseDTO);

    @HTTP(method = "DELETE", path = "productstock/100026", hasBody = true)
    Call<ResponseData> delete(@Body RequestDeleteById p_IdToDelete);

    @HTTP(method = "DELETE", path = "productstock/100029", hasBody = true)
    Call<ResponseData> deleteCollection(@Body List<String> p_ListOfIdToDelete);

    @GET("productstock/100017")
    Call<GenericListResponseDTO> selectLOV();
}
