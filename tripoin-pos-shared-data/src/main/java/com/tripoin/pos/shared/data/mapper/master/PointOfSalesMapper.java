package com.tripoin.pos.shared.data.mapper.master;

import com.tripoin.pos.shared.data.dto.response.master.PointOfSalesResponseDTO;
import com.tripoin.pos.shared.data.model.master.PointOfSales;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class PointOfSalesMapper extends ADATAMapper<PointOfSales, PointOfSalesResponseDTO> {
    @Override
    public PointOfSalesResponseDTO convert(PointOfSales pointOfSales) {
        PointOfSalesResponseDTO responseDTO = new PointOfSalesResponseDTO();
        responseDTO.setId(pointOfSales.getId());
        responseDTO.setCode(pointOfSales.getCode());
        responseDTO.setName(pointOfSales.getName());
        responseDTO.setRemarks(pointOfSales.getRemarks());
        return responseDTO;
    }
}
