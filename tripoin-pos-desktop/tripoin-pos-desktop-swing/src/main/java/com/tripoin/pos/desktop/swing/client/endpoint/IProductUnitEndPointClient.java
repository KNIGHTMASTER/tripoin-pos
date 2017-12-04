package com.tripoin.pos.desktop.swing.client.endpoint;

import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.pos.shared.data.dto.response.ProductUnitResponseDTO;
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
public interface IProductUnitEndPointClient {

    @GET("productunit/100004")
    Call<GenericListResponseDTO<ProductUnitResponseDTO>> findAll();

    @POST("productunit/100005")
    Call<ResponseGenericPaginationDTO<ProductUnitResponseDTO>> findPaginationAll(@Body RequestPaginationAllDTO p_RequestPaginationAllDTO);

    @POST("productunit/100031")
    Call<ResponseGenericPaginationDTO<ProductUnitResponseDTO>> findPaginationByCodeOrderById(@Body RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    @POST("productunit/100032")
    Call<ResponseGenericPaginationDTO<ProductUnitResponseDTO>> findPaginationByNameOrderById(@Body RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    @POST("productunit/100006")
    Call<GenericSingleDATAResponseDTO<ProductUnitResponseDTO>> findById(@Body RequestFindById p_RequestFindById);

    @POST("productunit/100023")
    Call<ResponseData> insert(@Body ProductUnitResponseDTO p_Product_UnitResponseDTO);

    @PUT("productunit/100022")
    Call<ResponseData> update(@Body ProductUnitResponseDTO p_Product_UnitResponseDTO);

    @HTTP(method = "DELETE", path = "productunit/100026", hasBody = true)
    Call<ResponseData> delete(@Body RequestDeleteById p_IdToDelete);

    @HTTP(method = "DELETE", path = "productunit/100029", hasBody = true)
    Call<ResponseData> deleteCollection(@Body List<String> p_ListOfIdToDelete);

    @GET("productunit/100017")
    Call<GenericListResponseDTO> selectLOV();
}
