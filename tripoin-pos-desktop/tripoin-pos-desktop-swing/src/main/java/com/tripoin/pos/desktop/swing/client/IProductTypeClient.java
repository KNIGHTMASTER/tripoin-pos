package com.tripoin.pos.desktop.swing.client;

import com.tripoin.pos.desktop.swing.client.base.IScaffoldingClient;
import com.tripoin.pos.shared.data.dto.request.SelectLOVProductTypeByProductCategoryRequestDTO;
import com.tripoin.pos.shared.data.dto.response.master.ProductTypeResponseDTO;
import com.tripoin.scaffolding.data.dto.request.RequestFindByCode;
import com.tripoin.scaffolding.data.dto.response.GenericListResponseDTO;
import retrofit2.Call;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IProductTypeClient extends IScaffoldingClient<ProductTypeResponseDTO> {

    Call<GenericListResponseDTO> selectLOVByProductCategory(SelectLOVProductTypeByProductCategoryRequestDTO productTypeByProductCategoryRequestDTO);

    Call<GenericListResponseDTO<ProductTypeResponseDTO>> findByProductCategoryCode(RequestFindByCode p_RequestFindByCode);
}
