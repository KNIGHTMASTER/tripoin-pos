package com.tripoin.pos.desktop.swing.component.combobox;

import com.tripoin.pos.desktop.swing.client.IScaffoldingClient;
import com.tripoin.pos.desktop.swing.dto.LOVDTO;
import com.tripoin.scaffolding.data.dto.response.GenericListResponseDTO;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

/**
 * Created on 11/15/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ALOV<RESPONSE extends LOVDTO> extends JComboBox<String> implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -466447181454306628L;

    protected IScaffoldingClient<RESPONSE> scaffoldingClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(ALOV.class);

    private GenericListResponseDTO<List<LOVDTO>> dto = null;

    protected String[] lovDATA;
    @Override
    public void initComponents() {
        scaffoldingClient = getScaffoldingClient();

        Call<GenericListResponseDTO> responseDTOCall = scaffoldingClient.selectLOV();
        try {
            dto = responseDTOCall.execute().body();
            lovDATA = new String[dto.getContent().size()];
            for (int a=0; a<dto.getContent().size(); a++){
                lovDATA[a] = String.valueOf(dto.getContent().get(a).get(1));
            }
            this.setModel(new DefaultComboBoxModel<>(lovDATA));
        } catch (IOException e) {
            LOGGER.error("Error select LOV Data from Rest ".concat(e.toString()));
        }
    }

    public abstract IScaffoldingClient<RESPONSE> getScaffoldingClient();

    public Long getSelectedId(int p_Index){
        return Long.valueOf(String.valueOf(dto.getContent().get(p_Index).get(0)));
    }
}
