package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.ReturHeaderResponseDTO;
import com.tripoin.pos.shared.data.model.trx.ReturHeader;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 12/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ReturHeaderMapper extends ADATAMapper<ReturHeader, ReturHeaderResponseDTO> {
    @Override
    public ReturHeaderResponseDTO convert(ReturHeader returHeader) {
        ReturHeaderResponseDTO responseDTO = new ReturHeaderResponseDTO();
        responseDTO.setId(returHeader.getId());
        responseDTO.setCode(returHeader.getCode());
        responseDTO.setName(returHeader.getName());
        responseDTO.setRemarks(returHeader.getRemarks());
        responseDTO.setTrxDate(returHeader.getTrxDate());
        responseDTO.setTotalItem(returHeader.getTotalItem());
        responseDTO.setTotalPrice(returHeader.getTotalPrice());
        responseDTO.setRefferenceId(returHeader.getRefferenceId());
        responseDTO.setCustomerName(returHeader.getCustomerName());
        responseDTO.setPhoneNumber(returHeader.getPhoneNumber());
        responseDTO.setAppSpv(returHeader.getAppSpv());
        return responseDTO;
    }
}
