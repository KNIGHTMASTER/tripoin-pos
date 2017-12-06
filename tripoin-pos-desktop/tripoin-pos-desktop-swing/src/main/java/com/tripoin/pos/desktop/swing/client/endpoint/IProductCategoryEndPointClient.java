package com.tripoin.pos.desktop.swing.client.endpoint;

import com.tripoin.pos.shared.data.dto.response.master.ProductCategoryResponseDTO;
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
public interface IProductCategoryEndPointClient {

    @GET("productcategory/100004")
    Call<GenericListResponseDTO<ProductCategoryResponseDTO>> findAll();

    @POST("productcategory/100005")
    Call<ResponseGenericPaginationDTO<ProductCategoryResponseDTO>> findPaginationAll(@Body RequestPaginationAllDTO p_RequestPaginationAllDTO);

    @POST("productcategory/100031")
    Call<ResponseGenericPaginationDTO<ProductCategoryResponseDTO>> findPaginationByCodeOrderById(@Body RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    @POST("productcategory/100032")
    Call<ResponseGenericPaginationDTO<ProductCategoryResponseDTO>> findPaginationByNameOrderById(@Body RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    @POST("productcategory/100006")
    Call<GenericSingleDATAResponseDTO<ProductCategoryResponseDTO>> findById(@Body RequestFindById p_RequestFindById);

    @POST("productcategory/100023")
    Call<ResponseData> insert(@Body ProductCategoryResponseDTO p_ProductCategoryResponseDTO);

    @PUT("productcategory/100022")
    Call<ResponseData> update(@Body ProductCategoryResponseDTO p_ProductCategoryResponseDTO);

    @HTTP(method = "DELETE", path = "productcategory/100026", hasBody = true)
    Call<ResponseData> delete(@Body RequestDeleteById p_IdToDelete);

    @HTTP(method = "DELETE", path = "productcategory/100029", hasBody = true)
    Call<ResponseData> deleteCollection(@Body List<String> p_ListOfIdToDelete);

    @GET("productcategory/100017")
    Call<GenericListResponseDTO> selectLOV();
}
