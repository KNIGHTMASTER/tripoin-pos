package com.tripoin.pos.desktop.swing.component.table.view;

import com.tripoin.pos.desktop.swing.client.base.IScaffoldingClient;
import com.tripoin.pos.desktop.swing.component.dialog.DialogProgress;
import com.tripoin.pos.desktop.swing.component.table.ITableListener;
import com.tripoin.pos.desktop.swing.component.table.listener.AScaffoldingTableListener;
import com.tripoin.pos.desktop.swing.component.table.model.AScaffoldingTableModel;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.scaffolding.data.dto.request.RequestPaginationAllDTO;
import com.tripoin.scaffolding.data.dto.request.RequestPaginationByCodeDTO;
import com.tripoin.scaffolding.data.dto.request.RequestPaginationByNameDTO;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.util.UIConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <RESPONSE>
 */
public abstract class AScaffoldingTable<RESPONSE> extends JTable implements IComponentInitializer, IComponentAction, ITableListener {
    /**
     *
     *
     */
    private static final long serialVersionUID = 9018509907770354676L;

    public IScaffoldingClient scaffoldingClient;

    protected AScaffoldingTableModel scaffoldingTableModel;

    public AScaffoldingTableListener scaffoldingTableListener;

    protected static final Logger LOGGER = LoggerFactory.getLogger(AScaffoldingTable.class);

    @Autowired
    private DialogProgress dialogProgress;

    @Override
    public void initComponents() {
        scaffoldingTableListener.initComponents();

        this.setRowSelectionAllowed(true);
        this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.setAutoCreateRowSorter(true);
        initAction();
    }

    public static enum FindMode {
        DEFAULT, CODE, NAME
    }

    @Override
    public ResponseGenericPaginationDTO<RESPONSE> refreshTable(int p_Size, int p_TargetPage, FindMode p_FindMode, String p_TextToSearch) {
        Call<ResponseGenericPaginationDTO<RESPONSE>> callBack = null;
        switch (p_FindMode) {
            case DEFAULT:
                RequestPaginationAllDTO requestPaginationAllDTO = new RequestPaginationAllDTO();
                requestPaginationAllDTO.setLimit(p_Size);
                requestPaginationAllDTO.setOffset(p_TargetPage);
                requestPaginationAllDTO.setOrder("asc");
                requestPaginationAllDTO.setSort("id");
                callBack = scaffoldingClient.findPaginationAll(requestPaginationAllDTO);
                break;
            case CODE:
                RequestPaginationByCodeDTO requestPaginationByCodeDTO = new RequestPaginationByCodeDTO();
                requestPaginationByCodeDTO.setLimit(p_Size);
                requestPaginationByCodeDTO.setOffset(p_TargetPage);
                requestPaginationByCodeDTO.setOrder("asc");
                requestPaginationByCodeDTO.setSort("id");
                requestPaginationByCodeDTO.setCode(p_TextToSearch);
                callBack = scaffoldingClient.findPaginationByCodeOrderById(requestPaginationByCodeDTO);
                break;
            case NAME:
                RequestPaginationByNameDTO requestPaginationByNameDTO = new RequestPaginationByNameDTO();
                requestPaginationByNameDTO.setLimit(p_Size);
                requestPaginationByNameDTO.setOffset(p_TargetPage);
                requestPaginationByNameDTO.setOrder("asc");
                requestPaginationByNameDTO.setSort("id");
                requestPaginationByNameDTO.setName(p_TextToSearch);
                callBack = scaffoldingClient.findPaginationByNameOrderById(requestPaginationByNameDTO);
                break;
        }
        ResponseGenericPaginationDTO<RESPONSE> responseDTO;
        try {
            responseDTO = callBack.execute().body();
            if (responseDTO.getContent().size() > 0){
                scaffoldingTableModel.setDataList(responseDTO.getContent());
            }else {
                scaffoldingTableModel.setDataList(new ArrayList<>());
            }
            this.setModel(scaffoldingTableModel);
            return responseDTO;
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Error Communicate to Rest Application "+e.toString());
            return null;
        }
    }

    @Override
    public ResponseGenericPaginationDTO refreshTableWithWorker(int p_Size, int p_TargetPage, AScaffoldingTable.FindMode p_FindMode, String p_TextToSearch) {
        if (p_TextToSearch == null){
            p_TextToSearch = UIConstant.Common.Punctuation.EMPTY;
        }
        ResponseGenericPaginationDTO responseGenericPaginationDTO = null;
        final String finalP_TextToSearch = p_TextToSearch;
        SwingWorker<ResponseGenericPaginationDTO<RESPONSE>, ?> worker = new SwingWorker<ResponseGenericPaginationDTO<RESPONSE>, Void>(){
            @Override
            protected ResponseGenericPaginationDTO<RESPONSE> doInBackground() throws Exception {
                return refreshTable(p_Size, p_TargetPage, p_FindMode, finalP_TextToSearch);
            }
            @Override
            protected void done(){
                dialogProgress.dispose();
            }
        };
        worker.execute();
        while (!worker.isDone()){
            dialogProgress.setVisible(true);
        }
        try {
            responseGenericPaginationDTO = worker.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return responseGenericPaginationDTO;
    }


    @Override
    public void initAction() {
        this.addMouseListener(scaffoldingTableListener);
    }

    public void setScaffoldingTableListener(AScaffoldingTableListener scaffoldingTableListener) {
        this.scaffoldingTableListener = scaffoldingTableListener;
    }
}
