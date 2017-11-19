package com.tripoin.pos.desktop.swing.component.dialog;

import com.tripoin.pos.desktop.swing.component.combobox.ALOV;
import com.tripoin.pos.desktop.swing.component.combobox.CompanyLOV;
import com.tripoin.pos.desktop.swing.component.textarea.DisabledTextArea;
import com.tripoin.pos.desktop.swing.component.textfield.DisabledTextField;
import com.tripoin.pos.shared.data.BranchTableDTO;
import com.tripoin.pos.shared.data.CompanyTableDTO;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 11/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ScaffoldingDialogBranch extends AScaffoldingDialog<BranchTableDTO> {
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
    public BranchTableDTO getDATAtoInsert() {
        BranchTableDTO branchTableDTO = new BranchTableDTO();
        CompanyTableDTO companyTableDTO = new CompanyTableDTO();
        if (enabledTextFields.size() == getNumberOfComponent()) {
            branchTableDTO.setId(Long.valueOf(((JTextField) enabledTextFields.get(0)).getText()));
            branchTableDTO.setCode(((JTextField) enabledTextFields.get(1)).getText());
            branchTableDTO.setName(((JTextField) enabledTextFields.get(2)).getText());
            companyTableDTO.setId(((ALOV) enabledTextFields.get(3)).getSelectedId(((ALOV) enabledTextFields.get(3)).getSelectedIndex()));
            branchTableDTO.setCompany(companyTableDTO);
            branchTableDTO.setRemarks(((JTextArea)enabledTextFields.get(4)).getText());
        }else {
            branchTableDTO.setCode(((JTextField)enabledTextFields.get(0)).getText());
            branchTableDTO.setName(((JTextField) enabledTextFields.get(1)).getText());
            companyTableDTO.setId(((ALOV) enabledTextFields.get(2)).getSelectedId(((ALOV) enabledTextFields.get(2)).getSelectedIndex()));
            branchTableDTO.setCompany(companyTableDTO);
            branchTableDTO.setRemarks(((JTextArea) enabledTextFields.get(3)).getText());
        }
        return branchTableDTO;
    }

    @Override
    public int getNumberOfComponent() {
        return 5;
    }

    @Override
    public String[] getLabelComponentText() {
        return new String[] {"Id", "Code", "Name", "Company", "Remarks"};
    }

    @Override
    public String[] getParamContentArray() {
        return new String[] {String.valueOf(getParamContent().getId()), getParamContent().getCode(), getParamContent().getName(), String.valueOf(getParamContent().getCompany().getName()), getParamContent().getRemarks()};
    }

    public abstract CompanyLOV getCompanyLOV();
}
