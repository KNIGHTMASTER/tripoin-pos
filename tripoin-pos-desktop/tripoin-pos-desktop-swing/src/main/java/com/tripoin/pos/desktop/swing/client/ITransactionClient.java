package com.tripoin.pos.desktop.swing.client;

import com.tripoin.scaffolding.data.dto.ResponseData;
import com.tripoin.scaffolding.data.dto.request.RequestDeleteById;
import retrofit2.Call;

/**
 * Created on 11/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public interface ITransactionClient<DATA> {

    Call<ResponseData> insert(DATA p_DATA);

    Call<ResponseData> update(DATA p_DATA);

    Call<ResponseData> delete(RequestDeleteById p_RequestDeleteById);
}
