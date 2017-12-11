package com.tripoin.pos.desktop.swing.component.combobox;

import com.tripoin.pos.desktop.swing.client.IProductTypeClient;
import com.tripoin.pos.desktop.swing.client.base.IScaffoldingClient;
import com.tripoin.pos.shared.data.dto.request.SelectLOVProductTypeByProductCategoryRequestDTO;
import com.tripoin.scaffolding.data.dto.response.GenericListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;

/**
 * Created on 11/15/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ProductTypeLOV extends ALOV {
    /**
     *
     *
     */
    private static final long serialVersionUID = 7102025858813221345L;

    @Autowired
    private IProductTypeClient productTypeClient;

    @Override
    public IScaffoldingClient getScaffoldingClient() {
        return productTypeClient;
    }

    @Override
    public void setContentByParent(Long p_ParentId) {
        Call<GenericListResponseDTO> responseProductTypeLOV = productTypeClient.selectLOVByProductCategory(new SelectLOVProductTypeByProductCategoryRequestDTO(String.valueOf(p_ParentId)));
        reInitComponent(responseProductTypeLOV);
    }
}
