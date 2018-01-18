package com.tripoin.pos.desktop.swing.controller.panel;

import com.tripoin.pos.desktop.swing.client.IParameterClient;
import com.tripoin.pos.shared.data.dto.response.system.ParameterResponseDTO;
import com.tripoin.scaffolding.data.dto.request.RequestFindByCode;
import com.tripoin.scaffolding.data.dto.response.GenericListResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import retrofit2.Call;

import java.io.IOException;

/**
 * Created on 1/8/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class RefreshContentChecker {

    private static final String CODE_PARAM = "TRIPOIN.CHECK.SCAFFOLDING.INSERTION";

    private static final Logger LOGGER = LoggerFactory.getLogger(RefreshContentChecker.class);

    @Autowired
    private IParameterClient parameterClient;

    @Transactional
    public void update() {
        RequestFindByCode requestFindByCode = new RequestFindByCode();
        requestFindByCode.setCode(CODE_PARAM);
        Call<GenericListResponseDTO<ParameterResponseDTO>> genericListResponseDTOCall= parameterClient.findByCode(requestFindByCode);
        try {
            GenericListResponseDTO<ParameterResponseDTO> responseDTO = genericListResponseDTOCall.execute().body();
            if (responseDTO.getContent().size() > 0) {
                ParameterResponseDTO parameterResponseDTO = responseDTO.getContent().get(0);
                if (parameterResponseDTO.getName().equals("1")) {
                    parameterResponseDTO.setName("0");
                } else {
                    parameterResponseDTO.setName("1");
                }
                parameterClient.update(parameterResponseDTO).execute().body();
            }
        } catch (IOException e) {
            LOGGER.error(e.toString());
        }
    }

    public int check() {
        RequestFindByCode requestFindByCode = new RequestFindByCode();
        requestFindByCode.setCode(CODE_PARAM);
        int result = 0;
        Call<GenericListResponseDTO<ParameterResponseDTO>> genericListResponseDTOCall= parameterClient.findByCode(requestFindByCode);
        try {
            GenericListResponseDTO<ParameterResponseDTO> responseDTO = genericListResponseDTOCall.execute().body();
            result = Integer.parseInt(responseDTO.getContent().get(0).getName());
        }catch (IOException e) {
            LOGGER.error(e.toString());
        }
        return result;
    }
}
