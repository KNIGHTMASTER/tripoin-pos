package com.tripoin.pos.desktop.swing.controller.panel;

import com.tripoin.pos.desktop.swing.component.dialog.DialogAutoCloseAlert;
import com.tripoin.pos.desktop.swing.component.dialog.ScaffoldingDialogMode;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.dto.param.ControllerScaffoldingParam;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import com.tripoin.scaffolding.data.constant.EResponseCode;
import com.tripoin.scaffolding.data.dto.ResponseData;
import com.tripoin.scaffolding.data.dto.request.RequestDeleteById;
import com.tripoin.scaffolding.data.dto.request.RequestFindById;
import com.tripoin.scaffolding.data.dto.response.GenericSingleDATAResponseDTO;
import id.co.telkomsigma.tgf.util.IParameterizedComponent;
import id.co.telkomsigma.tgf.util.UIConstant;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 11/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <RESPONSE>
 */
public abstract class AControllerScaffolding<RESPONSE> implements IParameterizedComponent<ControllerScaffoldingParam> {

    @Autowired
    private DialogAutoCloseAlert dialogAutoCloseAlert;

    private ControllerScaffoldingParam<RESPONSE> controllerScaffoldingParam;

    public void refresh() {
        getParam().getScaffoldingTable().refreshTableWithWorker(getParam().getComboBoxDisplayNumberOfData().getSelectedValue(getParam().getComboBoxDisplayNumberOfData().getSelectedIndex()), 0, AScaffoldingTable.FindMode.DEFAULT, UIConstant.Common.Punctuation.EMPTY);
    }

    public void delete() {
        int dialogResult = JOptionPane.showConfirmDialog(getParam().getScaffoldingTable(), "Would You Like to Delete Selected Data ?", "Warning", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            if (getParam().getSelectedTableRow() != null){
                String id;
                if (getParam().getPoint() == null){
                    id = String.valueOf(getParam().getScaffoldingTable().getValueAt(getParam().getSelectedTableRow(), 0));
                }else {
                    id = String.valueOf(getParam().getScaffoldingTable().getValueAt(getParam().getScaffoldingTable().rowAtPoint(getParam().getPoint()), 0));
                }
                RequestDeleteById requestDeleteById = new RequestDeleteById();
                requestDeleteById.setId(id);
                Call<ResponseData> responseDataCall = controllerScaffoldingParam.getScaffoldingClient().delete(requestDeleteById);
                ResponseData responseData;
                try {
                    responseData = responseDataCall.execute().body();
                    if (responseData != null) {
                        if (responseData.getResponseCode().equals(EResponseCode.RC_SUCCESS.getResponseCode())) {
                            dialogAutoCloseAlert.setMode(DialogAutoCloseAlert.MODE.INFO);
                            dialogAutoCloseAlert.initComponents();
                            getParam().getScaffoldingTable().refreshTableWithWorker(getParam().getComboBoxDisplayNumberOfData().getSelectedValue(getParam().getComboBoxDisplayNumberOfData().getSelectedIndex()), 0, AScaffoldingTable.FindMode.DEFAULT, UIConstant.Common.Punctuation.EMPTY);
                        }else {
                            dialogAutoCloseAlert.setMode(DialogAutoCloseAlert.MODE.ERROR);
                            dialogAutoCloseAlert.initComponents();
                        }
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }else {
                List<String> ids = new ArrayList<>();
                for (int a=0; a<getParam().getSelectedTableRows().length; a++){
                    ids.add(String.valueOf(getParam().getScaffoldingTable().getValueAt(getParam().getSelectedTableRows()[a], 0)));
                }

                Call<ResponseData> responseDataCall = controllerScaffoldingParam.getScaffoldingClient().deleteCollectionById(ids);
                ResponseData responseData;
                try {
                    responseData = responseDataCall.execute().body();
                    if (responseData != null) {
                        if (responseData.getResponseCode().equals(EResponseCode.RC_SUCCESS.getResponseCode())) {
                            dialogAutoCloseAlert.setMode(DialogAutoCloseAlert.MODE.INFO);
                            dialogAutoCloseAlert.initComponents();
                            getParam().getScaffoldingTable().refreshTableWithWorker(getParam().getComboBoxDisplayNumberOfData().getSelectedValue(getParam().getComboBoxDisplayNumberOfData().getSelectedIndex()), 0, AScaffoldingTable.FindMode.DEFAULT, UIConstant.Common.Punctuation.EMPTY);
                        }else {
                            dialogAutoCloseAlert.setMode(DialogAutoCloseAlert.MODE.ERROR);
                            dialogAutoCloseAlert.initComponents();
                        }
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public void showDetailDialog() {
        String id = String.valueOf(getParam().getScaffoldingTable().getValueAt(getParam().getScaffoldingTable().rowAtPoint(getParam().getPoint()), 0));
        Call<GenericSingleDATAResponseDTO<RESPONSE>> responseCall;
        RequestFindById requestFindById = new RequestFindById();
        requestFindById.setId(Long.valueOf(id));
        responseCall = getParam().getScaffoldingClient().findById(requestFindById);

        GenericSingleDATAResponseDTO<RESPONSE> response;
        try {
            response = responseCall.execute().body();
            getParam().getScaffoldingDialog().setModeDialog(ScaffoldingDialogMode.DETAIL);
            getParam().getScaffoldingDialog().setParam(response);
            getParam().getScaffoldingDialog().setFieldsDetail();
            getParam().getScaffoldingDialog().setVisible(true);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void showInsertDialog() {
        getParam().getScaffoldingDialog().setModeDialog(ScaffoldingDialogMode.INSERT);
        getParam().getScaffoldingDialog().setVisible(true);
    }

    public void showUpdateDialog() {
        String id;
        if (getParam().getPoint() == null){
            id = String.valueOf(getParam().getScaffoldingTable().getValueAt(getParam().getSelectedTableRow(), 0));
        }else {
            id = String.valueOf(getParam().getScaffoldingTable().getValueAt(getParam().getScaffoldingTable().rowAtPoint(getParam().getPoint()), 0));
        }
        Call<GenericSingleDATAResponseDTO<RESPONSE>> responseCall;
        RequestFindById requestFindById = new RequestFindById();
        requestFindById.setId(Long.valueOf(id));
        responseCall = getParam().getScaffoldingClient().findById(requestFindById);

        GenericSingleDATAResponseDTO<RESPONSE> response;
        try {
            response = responseCall.execute().body();
            getParam().getScaffoldingDialog().setParam(response);
            getParam().getScaffoldingDialog().setFieldsUpdate();
            getParam().getScaffoldingDialog().setModeDialog(ScaffoldingDialogMode.UPDATE);
            getParam().getScaffoldingDialog().setVisible(true);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void insert() {
        Call<ResponseData> responseDataCall = getParam().getScaffoldingClient().insert(getParam().getData());
        try {
            ResponseData responseData = responseDataCall.execute().body();
            if (responseData.getResponseCode().equals(EResponseCode.RC_SUCCESS.getResponseCode())) {
                dialogAutoCloseAlert.setMode(DialogAutoCloseAlert.MODE.INFO);
                dialogAutoCloseAlert.initComponents();
                getParam().getScaffoldingTable().refreshTableWithWorker(getParam().getComboBoxDisplayNumberOfData().getSelectedValue(getParam().getComboBoxDisplayNumberOfData().getSelectedIndex()), 0, AScaffoldingTable.FindMode.DEFAULT, UIConstant.Common.Punctuation.EMPTY);
            }else {
                dialogAutoCloseAlert.setMode(DialogAutoCloseAlert.MODE.ERROR);
                dialogAutoCloseAlert.initComponents();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        getParam().getScaffoldingDialog().setVisible(false);
    }

    public void update(){
        Call<ResponseData> responseDataCall = getParam().getScaffoldingClient().update(getParam().getData());
        try {
            ResponseData responseData = responseDataCall.execute().body();
            if (responseData.getResponseCode().equals(EResponseCode.RC_SUCCESS.getResponseCode())) {
                dialogAutoCloseAlert.setMode(DialogAutoCloseAlert.MODE.INFO);
                dialogAutoCloseAlert.initComponents();
                getParam().getScaffoldingTable().refreshTableWithWorker(getParam().getComboBoxDisplayNumberOfData().getSelectedValue(getParam().getComboBoxDisplayNumberOfData().getSelectedIndex()), 0, AScaffoldingTable.FindMode.DEFAULT, UIConstant.Common.Punctuation.EMPTY);
            }else {
                dialogAutoCloseAlert.setMode(DialogAutoCloseAlert.MODE.ERROR);
                dialogAutoCloseAlert.initComponents();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        getParam().getScaffoldingDialog().setVisible(false);
    }

    public void refreshTable(ResponseGenericPaginationDTO responseGenericPaginationDTO){
        int selectedCombo = getParam().getComboBoxDisplayNumberOfData().getSelectedValue(getParam().getComboBoxDisplayNumberOfData().getSelectedIndex());
        int startIndex = (selectedCombo * responseGenericPaginationDTO.getNumber()) - responseGenericPaginationDTO.getNumber() + 1;
        getParam().getLabelIndex().setText("Showing 1 - "+startIndex+" from "+responseGenericPaginationDTO.getTotalElements()+" Record");
        if (responseGenericPaginationDTO.getFirst()){
            getParam().getPanelPaginationButton().getButtonFirstPage().setEnabled(false);
            getParam().getPanelPaginationButton().getButtonPrevPage().setEnabled(false);
        }else {
            getParam().getPanelPaginationButton().getButtonFirstPage().setEnabled(true);
            getParam().getPanelPaginationButton().getButtonPrevPage().setEnabled(true);
        }
        if (responseGenericPaginationDTO.getLast()){
            getParam().getPanelPaginationButton().getButtonLastPage().setEnabled(false);
            getParam().getPanelPaginationButton().getButtonNextPage().setEnabled(false);
        }else {
            getParam().getPanelPaginationButton().getButtonLastPage().setEnabled(true);
            getParam().getPanelPaginationButton().getButtonNextPage().setEnabled(true);
        }
    }

    @Override
    public void setParam(ControllerScaffoldingParam p_ControllerScaffoldingParam) {
        this.controllerScaffoldingParam = p_ControllerScaffoldingParam;
    }

    @Override
    public ControllerScaffoldingParam getParam() {
        return controllerScaffoldingParam;
    }
}
