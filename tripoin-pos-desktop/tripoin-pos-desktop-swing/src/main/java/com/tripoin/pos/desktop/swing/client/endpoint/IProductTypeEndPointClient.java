package com.tripoin.pos.desktop.swing.client.endpoint;

import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.request.SelectLOVProductTypeByProductCategoryRequestDTO;
import com.tripoin.pos.shared.data.dto.response.master.ProductTypeResponseDTO;
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
public interface IProductTypeEndPointClient {

    @GET("producttype/100004")
    Call<GenericListResponseDTO<ProductTypeResponseDTO>> findAll();

    @POST("producttype/100005")
    Call<ResponseGenericPaginationDTO<ProductTypeResponseDTO>> findPaginationAll(@Body RequestPaginationAllDTO p_RequestPaginationAllDTO);

    @POST("producttype/100031")
    Call<ResponseGenericPaginationDTO<ProductTypeResponseDTO>> findPaginationByCodeOrderById(@Body RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    @POST("producttype/100032")
    Call<ResponseGenericPaginationDTO<ProductTypeResponseDTO>> findPaginationByNameOrderById(@Body RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    @POST("producttype/100006")
    Call<GenericSingleDATAResponseDTO<ProductTypeResponseDTO>> findById(@Body RequestFindById p_RequestFindById);

    @POST("producttype/100023")
    Call<ResponseData> insert(@Body ProductTypeResponseDTO p_ProductTypeResponseDTO);

    @PUT("producttype/100022")
    Call<ResponseData> update(@Body ProductTypeResponseDTO p_ProductTypeResponseDTO);

    @HTTP(method = "DELETE", path = "producttype/100026", hasBody = true)
    Call<ResponseData> delete(@Body RequestDeleteById p_IdToDelete);

    @HTTP(method = "DELETE", path = "producttype/100029", hasBody = true)
    Call<ResponseData> deleteCollection(@Body List<String> p_ListOfIdToDelete);

    @GET("producttype/100017")
    Call<GenericListResponseDTO> selectLOV();

    @POST("producttype/100030")
    Call<GenericListResponseDTO> selectLOVByProductCategory(@Body SelectLOVProductTypeByProductCategoryRequestDTO productTypeByProductCategoryRequestDTO);
}
