package com.tripoin.pos.desktop.swing.client.endpoint;

import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.master.ProductBrandResponseDTO;
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
public interface IProductBrandEndPointClient {

    @GET("productbrand/100004")
    Call<GenericListResponseDTO<ProductBrandResponseDTO>> findAll();

    @POST("productbrand/100005")
    Call<ResponseGenericPaginationDTO<ProductBrandResponseDTO>> findPaginationAll(@Body RequestPaginationAllDTO p_RequestPaginationAllDTO);

    @POST("productbrand/100031")
    Call<ResponseGenericPaginationDTO<ProductBrandResponseDTO>> findPaginationByCodeOrderById(@Body RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    @POST("productbrand/100032")
    Call<ResponseGenericPaginationDTO<ProductBrandResponseDTO>> findPaginationByNameOrderById(@Body RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    @POST("productbrand/100006")
    Call<GenericSingleDATAResponseDTO<ProductBrandResponseDTO>> findById(@Body RequestFindById p_RequestFindById);

    @POST("productbrand/100023")
    Call<ResponseData> insert(@Body ProductBrandResponseDTO p_ProductBrandResponseDTO);

    @PUT("productbrand/100022")
    Call<ResponseData> update(@Body ProductBrandResponseDTO p_ProductBrandResponseDTO);

    @HTTP(method = "DELETE", path = "productbrand/100026", hasBody = true)
    Call<ResponseData> delete(@Body RequestDeleteById p_IdToDelete);

    @HTTP(method = "DELETE", path = "productbrand/100029", hasBody = true)
    Call<ResponseData> deleteCollection(@Body List<String> p_ListOfIdToDelete);

    @GET("productbrand/100017")
    Call<GenericListResponseDTO> selectLOV();
}
