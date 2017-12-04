package com.tripoin.pos.desktop.swing.component.dialog.impl;

import com.tripoin.pos.desktop.swing.component.combobox.ALOV;
import com.tripoin.pos.desktop.swing.component.combobox.CompanyLOV;
import com.tripoin.pos.desktop.swing.component.dialog.base.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.textarea.DisabledTextArea;
import com.tripoin.pos.desktop.swing.component.textfield.DisabledTextField;
import com.tripoin.pos.shared.data.dto.response.BranchResponseDTO;
import com.tripoin.pos.shared.data.dto.response.CompanyResponseDTO;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 11/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ScaffoldingDialogBranch extends AScaffoldingDialog<BranchResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2593952653246461722L;

    protected CompanyLOV companyLOV;

    @Override
    public void initComponents() {
        preferredHeight = 220;
        preferredWidth = 430;
        companyLOV = getCompanyLOV();
        super.initComponents();
    }

    @Override
    public String[] getTitles() {
        return new String[] {
                "ui.dialog.detail.branch.title",
                "ui.dialog.insert.branch.title",
                "ui.dialog.update.branch.title"
        };
    }

    @Override
    public List<Component> getDisabledModeFields() {
        companyLOV.initComponents();
        companyLOV.setEnabled(false);

        disabledTextFields = new LinkedList<>();

        DisabledTextField txtId = new DisabledTextField();
        DisabledTextField txtCode = new DisabledTextField();
        DisabledTextField txtName = new DisabledTextField();
        DisabledTextArea txtRemarks = new DisabledTextArea();

        disabledTextFields.add(txtId);
        disabledTextFields.add(txtCode);
        disabledTextFields.add(txtName);
        disabledTextFields.add(companyLOV);
        disabledTextFields.add(txtRemarks);

        return disabledTextFields;
    }

    @Override
    public List<Component> getEnabledModeFields() {
        companyLOV.initComponents();
        companyLOV.setEnabled(true);

        enabledTextFields = new LinkedList<>();

        JTextField txtId = new JTextField();
        JTextField txtCode = new JTextField();
        JTextField txtName = new JTextField();
        JTextArea txtRemarks = new JTextArea();

        enabledTextFields.add(txtId);
        enabledTextFields.add(txtCode);
        enabledTextFields.add(txtName);
        enabledTextFields.add(companyLOV);
        enabledTextFields.add(txtRemarks);

        return enabledTextFields;
    }

    @Override
    public BranchResponseDTO getDATAtoInsert() {
        BranchResponseDTO branchResponseDTO = new BranchResponseDTO();
        CompanyResponseDTO companyResponseDTO = new CompanyResponseDTO();
        if (enabledTextFields.size() == getNumberOfComponent()) {
            branchResponseDTO.setId(Long.valueOf(((JTextField) enabledTextFields.get(0)).getText()));
            branchResponseDTO.setCode(((JTextField) enabledTextFields.get(1)).getText());
            branchResponseDTO.setName(((JTextField) enabledTextFields.get(2)).getText());
            companyResponseDTO.setId(((ALOV) enabledTextFields.get(3)).getSelectedId(((ALOV) enabledTextFields.get(3)).getSelectedIndex()));
            branchResponseDTO.setCompany(companyResponseDTO);
            branchResponseDTO.setRemarks(((JTextArea)enabledTextFields.get(4)).getText());
        }else {
            branchResponseDTO.setCode(((JTextField)enabledTextFields.get(0)).getText());
            branchResponseDTO.setName(((JTextField) enabledTextFields.get(1)).getText());
            companyResponseDTO.setId(((ALOV) enabledTextFields.get(2)).getSelectedId(((ALOV) enabledTextFields.get(2)).getSelectedIndex()));
            branchResponseDTO.setCompany(companyResponseDTO);
            branchResponseDTO.setRemarks(((JTextArea) enabledTextFields.get(3)).getText());
        }
        return branchResponseDTO;
    }

    @Override
    public String[] getLabelComponentText() {
        return new String[] {"Id", "Code", "Name", "Company", "Remarks"};
    }

    @Override
    public String[] getParamContentArray() {
        return new String[] {String.valueOf(getParamContent().getId()), getParamContent().getCode(), getParamContent().getName(), getParamContent().getCompany().getName(), getParamContent().getRemarks()};
    }

    public abstract CompanyLOV getCompanyLOV();
}
