package com.tripoin.pos.desktop.swing.component.dialog.impl;

import com.tripoin.pos.desktop.swing.component.combobox.ALOV;
import com.tripoin.pos.desktop.swing.component.combobox.ProductCategoryLOV;
import com.tripoin.pos.desktop.swing.component.dialog.base.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.textarea.DisabledTextArea;
import com.tripoin.pos.desktop.swing.component.textfield.DisabledTextField;
import com.tripoin.pos.shared.data.dto.response.ProductCategoryResponseDTO;
import com.tripoin.pos.shared.data.dto.response.ProductTypeResponseDTO;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 11/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ScaffoldingDialogProductType extends AScaffoldingDialog<ProductTypeResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2593952653246461722L;

    protected ProductCategoryLOV productCategoryLOV;

    @Override
    public void initComponents() {
        preferredHeight = 200;
        preferredWidth = 400;
        productCategoryLOV = getProductCategoryLOV();
        super.initComponents();
    }

    @Override
    public String[] getTitles() {
        return new String[] {
                "ui.dialog.detail.producttype.title",
                "ui.dialog.insert.producttype.title",
                "ui.dialog.update.producttype.title"
        };
    }

    @Override
    public List<Component> getDisabledModeFields() {
        productCategoryLOV.initComponents();
        disabledTextFields = new LinkedList<>();

        DisabledTextField txtId = new DisabledTextField();
        DisabledTextField txtCode = new DisabledTextField();
        DisabledTextField txtName = new DisabledTextField();
        DisabledTextArea txtRemarks = new DisabledTextArea();

        disabledTextFields.add(txtId);
        disabledTextFields.add(txtCode);
        disabledTextFields.add(txtName);
        disabledTextFields.add(productCategoryLOV);
        disabledTextFields.add(txtRemarks);

        return disabledTextFields;
    }

    @Override
    public List<Component> getEnabledModeFields() {
        productCategoryLOV.initComponents();
        enabledTextFields = new LinkedList<>();

        JTextField txtId = new JTextField();
        JTextField txtCode = new JTextField();
        JTextField txtName = new JTextField();
        JTextArea txtRemarks = new JTextArea();

        enabledTextFields.add(txtId);
        enabledTextFields.add(txtCode);
        enabledTextFields.add(txtName);
        enabledTextFields.add(productCategoryLOV);
        enabledTextFields.add(txtRemarks);

        return enabledTextFields;
    }

    @Override
    public ProductTypeResponseDTO getDATAtoInsert() {
        ProductTypeResponseDTO productTypeResponseDTO = new ProductTypeResponseDTO();
        ProductCategoryResponseDTO productCategoryResponseDTO = new ProductCategoryResponseDTO();
        if (enabledTextFields.size() == getNumberOfComponent()) {
            productTypeResponseDTO.setId(Long.valueOf(((JTextField) enabledTextFields.get(0)).getText()));
            productTypeResponseDTO.setCode(((JTextField) enabledTextFields.get(1)).getText());
            productTypeResponseDTO.setName(((JTextField) enabledTextFields.get(2)).getText());
            productCategoryResponseDTO.setId(((ALOV) enabledTextFields.get(3)).getSelectedId(((ALOV) enabledTextFields.get(3)).getSelectedIndex()));
            productTypeResponseDTO.setProductCategory(productCategoryResponseDTO);
            productTypeResponseDTO.setRemarks(((JTextArea) enabledTextFields.get(4)).getText());
        }else {
            productTypeResponseDTO.setCode(((JTextField) enabledTextFields.get(0)).getText());
            productTypeResponseDTO.setName(((JTextField) enabledTextFields.get(1)).getText());
            productCategoryResponseDTO.setId(((ALOV) enabledTextFields.get(2)).getSelectedId(((ALOV) enabledTextFields.get(2)).getSelectedIndex()));
            productTypeResponseDTO.setProductCategory(productCategoryResponseDTO);
            productTypeResponseDTO.setRemarks(((JTextArea) enabledTextFields.get(3)).getText());
        }
        return productTypeResponseDTO;
    }

    @Override
    public String[] getLabelComponentText() {
        return new String[] {"Id", "Code", "Name", "Product Category", "Remarks"};
    }

    @Override
    public String[] getParamContentArray() {
        return new String[] {String.valueOf(getParamContent().getId()), getParamContent().getCode(), getParamContent().getName(), getParamContent().getProductCategory().getName(), getParamContent().getRemarks()};
    }

    public abstract ProductCategoryLOV getProductCategoryLOV();
}
