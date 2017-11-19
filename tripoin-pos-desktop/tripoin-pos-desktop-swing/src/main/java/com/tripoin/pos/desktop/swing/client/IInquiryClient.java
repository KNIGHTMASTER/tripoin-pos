package com.tripoin.pos.desktop.swing.client;

import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.scaffolding.data.dto.request.RequestFindById;
import com.tripoin.scaffolding.data.dto.request.RequestPaginationAllDTO;
import com.tripoin.scaffolding.data.dto.request.RequestPaginationByCodeDTO;
import com.tripoin.scaffolding.data.dto.request.RequestPaginationByNameDTO;
import com.tripoin.scaffolding.data.dto.response.GenericListResponseDTO;
import com.tripoin.scaffolding.data.dto.response.GenericSingleDATAResponseDTO;
import retrofit2.Call;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <RESPONSE>
 */
public interface IInquiryClient<RESPONSE> {

    Call<GenericListResponseDTO<RESPONSE>> findAll();

    Call<ResponseGenericPaginationDTO<RESPONSE>> findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAllDTO);

    Call<ResponseGenericPaginationDTO<RESPONSE>> findPaginationByCodeOrderById(RequestPaginationByCodeDTO p_RequestPaginationByCodeDTO);

    Call<ResponseGenericPaginationDTO<RESPONSE>> findPaginationByNameOrderById(RequestPaginationByNameDTO p_RequestPaginationByNameDTO);

    Call<GenericSingleDATAResponseDTO<RESPONSE>> findById(RequestFindById p_RequestFindById);

    Call<GenericListResponseDTO> selectLOV();
}
