package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.client.IScaffoldingClient;
import com.tripoin.pos.desktop.swing.component.dialog.DialogProgress;
import com.tripoin.pos.desktop.swing.component.table.ITableListener;
import com.tripoin.pos.desktop.swing.component.table.listener.AScaffoldingTableListener;
import com.tripoin.pos.desktop.swing.component.table.model.AScaffoldingTableModel;
import com.tripoin.scaffolding.data.dto.response.GenericListResponseDTO;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <REST_RESPONSE>
 */
public abstract class AScaffoldingTable<REST_RESPONSE> extends JTable implements IComponentInitializer, IComponentAction, ITableListener {
    /**
     *
     *
     */
    private static final long serialVersionUID = 9018509907770354676L;

    public IScaffoldingClient scaffoldingClient;

    protected AScaffoldingTableModel scaffoldingTableModel;

    protected AScaffoldingTableListener scaffoldingTableListener;

    protected static final Logger LOGGER = LoggerFactory.getLogger(AScaffoldingTable.class);

    @Autowired
    private DialogProgress dialogProgress;

    @Override
    public void initComponents() {
        initAction();
    }

    @Override
    public void refreshTable() {
        Call<GenericListResponseDTO<REST_RESPONSE>> callBack = scaffoldingClient.findAll();

        GenericListResponseDTO<REST_RESPONSE> responseDTO;
        try {
            responseDTO = callBack.execute().body();
            if (responseDTO.getContent() != null){
                scaffoldingTableModel.setDataList(responseDTO.getContent());

            }else {
                scaffoldingTableModel.setDataList(new ArrayList<>());
            }
            this.setModel(scaffoldingTableModel);
        } catch (IOException e) {
            LOGGER.error("Error Communicate to Rest Application "+e.toString());
        }
    }

    @Override
    public void refreshTableWithWorker() {
        SwingWorker<?,?> worker = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                refreshTable();
                return null;
            }

            @Override
            protected void done(){
                dialogProgress.dispose();
            }
        };
        worker.execute();
        dialogProgress.setVisible(true);
    }

    public AScaffoldingTableModel getScaffoldingTableModel() {
        return scaffoldingTableModel;
    }

    @Override
    public void initAction() {
        this.addMouseListener(scaffoldingTableListener);
    }
}
