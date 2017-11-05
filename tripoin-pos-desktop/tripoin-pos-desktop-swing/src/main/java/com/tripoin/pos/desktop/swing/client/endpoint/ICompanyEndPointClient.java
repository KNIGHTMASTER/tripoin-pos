package com.tripoin.pos.desktop.swing.client.endpoint;

import com.tripoin.pos.shared.data.CompanyTableDTO;
import com.tripoin.scaffolding.data.dto.ResponseData;
import com.tripoin.scaffolding.data.dto.request.RequestDeleteById;
import com.tripoin.scaffolding.data.dto.request.RequestFindById;
import com.tripoin.scaffolding.data.dto.response.GenericListResponseDTO;
import com.tripoin.scaffolding.data.dto.response.GenericSingleDATAResponseDTO;
import retrofit2.Call;
import retrofit2.http.*;

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
public interface ICompanyEndPointClient {

    @GET("company/100004")
    Call<GenericListResponseDTO<CompanyTableDTO>> findAll();

    @POST("company/100006")
    Call<GenericSingleDATAResponseDTO<CompanyTableDTO>> findById(@Body RequestFindById p_RequestFindById);

    @HTTP(method = "DELETE", path = "company/100026", hasBody = true)
    Call<ResponseData> delete(@Body RequestDeleteById p_IdToDelete);

    @POST("company/100023")
    Call<ResponseData> insert(@Body CompanyTableDTO p_CompanyTableDTO);

    @PUT("company/100022")
    Call<ResponseData> update(@Body CompanyTableDTO p_CompanyTableDTO);
}
