package com.tripoin.pos.desktop.swing.client;

import com.tripoin.scaffolding.data.dto.request.RequestFindById;
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

    Call<GenericSingleDATAResponseDTO<RESPONSE>> findById(RequestFindById p_RequestFindById);
}
