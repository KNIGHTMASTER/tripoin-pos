package com.tripoin.pos.desktop.swing.component.dialog;

import com.tripoin.pos.desktop.swing.component.textfield.DisabledTextField;
import com.tripoin.pos.shared.data.CompanyTableDTO;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 11/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ScaffoldingDialogCompany extends AScaffoldingDialog<CompanyTableDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2593952653246461722L;

    @Override
    public void initComponents() {
        preferredHeight = 180;
        preferredWidth = 330;
        super.initComponents();
    }

    @Override
    public String[] getTitles() {
        return new String[] {
                "ui.dialog.detail.company.title",
                "ui.dialog.insert.company.title",
                "ui.dialog.update.company.title"
        };
    }

    @Override
    public List<DisabledTextField> getDisabledModeFields() {
        disabledTextFields = new LinkedList<>();

        DisabledTextField txtId = new DisabledTextField();
        DisabledTextField txtCode = new DisabledTextField();
        DisabledTextField txtName = new DisabledTextField();

        disabledTextFields.add(txtId);
        disabledTextFields.add(txtCode);
        disabledTextFields.add(txtName);

        return disabledTextFields;
    }

    @Override
    public List<TextField> getEnabledModeFields() {
        enabledTextFields = new LinkedList<>();

        TextField txtId = new TextField();
        TextField txtCode = new TextField();
        TextField txtName = new TextField();

        enabledTextFields.add(txtId);
        enabledTextFields.add(txtCode);
        enabledTextFields.add(txtName);

        return enabledTextFields;
    }

    @Override
    public CompanyTableDTO getDATAtoInsert() {
        CompanyTableDTO companyTableDTO = new CompanyTableDTO();
        if (enabledTextFields.size() == getNumberOfComponent()) {
            companyTableDTO.setId(Long.valueOf(enabledTextFields.get(0).getText()));
            companyTableDTO.setCode(enabledTextFields.get(1).getText());
            companyTableDTO.setName(enabledTextFields.get(2).getText());
        }else {
            companyTableDTO.setCode(enabledTextFields.get(0).getText());
            companyTableDTO.setName(enabledTextFields.get(1).getText());
        }
        return companyTableDTO;
    }

    @Override
    public int getNumberOfComponent() {
        return 3;
    }

    @Override
    public String[] getLabelComponentText() {
        return new String[] {"Id", "Code", "Name"};
    }

    @Override
    public String[] getParamContentArray() {
        return new String[] {String.valueOf(getParamContent().getId()), getParamContent().getCode(), getParamContent().getName()};
    }
}
