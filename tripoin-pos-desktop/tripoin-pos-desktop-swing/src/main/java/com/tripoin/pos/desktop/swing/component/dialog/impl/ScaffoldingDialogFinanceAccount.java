package com.tripoin.pos.desktop.swing.component.dialog.impl;

import com.tripoin.pos.desktop.swing.component.dialog.base.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.textarea.DisabledTextArea;
import com.tripoin.pos.desktop.swing.component.textfield.DisabledTextField;
import com.tripoin.pos.shared.data.dto.response.master.FinanceAccountResponseDTO;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 11/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ScaffoldingDialogFinanceAccount extends AScaffoldingDialog<FinanceAccountResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2593952653246461722L;

    @Override
    public void initComponents() {
        preferredHeight = 200;
        preferredWidth = 400;
        super.initComponents();
    }

    @Override
    public String[] getTitles() {
        return new String[] {
                "ui.dialog.detail.financeaccount.title",
                "ui.dialog.insert.financeaccount.title",
                "ui.dialog.update.financeaccount.title"
        };
    }

    @Override
    public List<Component> getDisabledModeFields() {
        disabledTextFields = new LinkedList<>();

        DisabledTextField txtId = new DisabledTextField();
        DisabledTextField txtCode = new DisabledTextField();
        DisabledTextField txtName = new DisabledTextField();
        DisabledTextArea txtRemarks = new DisabledTextArea();

        disabledTextFields.add(txtId);
        disabledTextFields.add(txtCode);
        disabledTextFields.add(txtName);
        disabledTextFields.add(txtRemarks);

        return disabledTextFields;
    }

    @Override
    public List<Component> getEnabledModeFields() {
        enabledTextFields = new LinkedList<>();

        JTextField txtId = new JTextField();
        JTextField txtCode = new JTextField();
        JTextField txtName = new JTextField();
        JTextArea txtRemarks = new JTextArea();

        enabledTextFields.add(txtId);
        enabledTextFields.add(txtCode);
        enabledTextFields.add(txtName);
        enabledTextFields.add(txtRemarks);

        return enabledTextFields;
    }

    @Override
    public FinanceAccountResponseDTO getDATAtoInsert() {
        FinanceAccountResponseDTO financeAccountResponseDTO = new FinanceAccountResponseDTO();
        if (enabledTextFields.size() == getNumberOfComponent()) {
            financeAccountResponseDTO.setId(Long.valueOf(((JTextField) enabledTextFields.get(0)).getText()));
            financeAccountResponseDTO.setCode(((JTextField) enabledTextFields.get(1)).getText());
            financeAccountResponseDTO.setName(((JTextField) enabledTextFields.get(2)).getText());
            financeAccountResponseDTO.setRemarks(((JTextArea) enabledTextFields.get(3)).getText());
        }else {
            financeAccountResponseDTO.setCode(((JTextField) enabledTextFields.get(0)).getText());
            financeAccountResponseDTO.setName(((JTextField) enabledTextFields.get(1)).getText());
            financeAccountResponseDTO.setRemarks(((JTextArea) enabledTextFields.get(2)).getText());
        }
        return financeAccountResponseDTO;
    }

    @Override
    public String[] getLabelComponentText() {
        return new String[] {"Id", "Code", "Name", "Remarks"};
    }

    @Override
    public String[] getParamContentArray() {
        return new String[] {String.valueOf(getParamContent().getId()), getParamContent().getCode(), getParamContent().getName(), getParamContent().getRemarks()};
    }
}
