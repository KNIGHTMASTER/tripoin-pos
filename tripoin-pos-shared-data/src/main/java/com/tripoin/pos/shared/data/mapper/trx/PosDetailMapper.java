package com.tripoin.pos.shared.data.mapper.trx;

import com.tripoin.pos.shared.data.dto.response.trx.PosDetailResponseDTO;
import com.tripoin.pos.shared.data.model.trx.PosDetail;
import com.tripoin.scaffolding.data.mapper.ADATAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 12/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class PosDetailMapper extends ADATAMapper<PosDetail, PosDetailResponseDTO> {

    @Autowired
    private PosHeaderMapper posHeaderMapper;

    @Override
    public PosDetailResponseDTO convert(PosDetail posDetail) {
        PosDetailResponseDTO responseDTO = new PosDetailResponseDTO();
        responseDTO.setId(posDetail.getId());
        responseDTO.setCode(posDetail.getCode());
        responseDTO.setName(posDetail.getName());
        responseDTO.setRemarks(posDetail.getRemarks());
        if (posDetail.getPosHeader() != null) {
            responseDTO.setPosHeader(posHeaderMapper.convert(posDetail.getPosHeader()));
        }
        responseDTO.setOpenBalance(posDetail.getOpenBalance());
        responseDTO.setOpenTime(posDetail.getOpenTime());
        responseDTO.setIsOpenBalance(posDetail.getIsOpenBalance());
        responseDTO.setCloseBalance(posDetail.getCloseBalance());
        responseDTO.setCloseTime(posDetail.getCloseTime());
        responseDTO.setIsCloseBalance(posDetail.getIsCloseBalance());
        return responseDTO;
    }
}
