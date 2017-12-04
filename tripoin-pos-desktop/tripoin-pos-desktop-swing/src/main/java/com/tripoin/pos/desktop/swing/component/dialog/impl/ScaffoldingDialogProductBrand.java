package com.tripoin.pos.desktop.swing.component.dialog.impl;

import com.tripoin.pos.desktop.swing.component.dialog.base.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.textarea.DisabledTextArea;
import com.tripoin.pos.desktop.swing.component.textfield.DisabledTextField;
import com.tripoin.pos.shared.data.dto.response.ProductBrandResponseDTO;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 11/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ScaffoldingDialogProductBrand extends AScaffoldingDialog<ProductBrandResponseDTO> {
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
                "ui.dialog.detail.productbrand.title",
                "ui.dialog.insert.productbrand.title",
                "ui.dialog.update.productbrand.title"
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
    public ProductBrandResponseDTO getDATAtoInsert() {
        ProductBrandResponseDTO productBrandResponseDTO = new ProductBrandResponseDTO();
        if (enabledTextFields.size() == getNumberOfComponent()) {
            productBrandResponseDTO.setId(Long.valueOf(((JTextField) enabledTextFields.get(0)).getText()));
            productBrandResponseDTO.setCode(((JTextField) enabledTextFields.get(1)).getText());
            productBrandResponseDTO.setName(((JTextField) enabledTextFields.get(2)).getText());
            productBrandResponseDTO.setRemarks(((JTextArea) enabledTextFields.get(3)).getText());
        }else {
            productBrandResponseDTO.setCode(((JTextField) enabledTextFields.get(0)).getText());
            productBrandResponseDTO.setName(((JTextField) enabledTextFields.get(1)).getText());
            productBrandResponseDTO.setRemarks(((JTextArea) enabledTextFields.get(2)).getText());
        }
        return productBrandResponseDTO;
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
