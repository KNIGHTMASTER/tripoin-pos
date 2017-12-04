package com.tripoin.pos.desktop.swing.component.dialog.impl;

import com.tripoin.pos.desktop.swing.component.combobox.ALOV;
import com.tripoin.pos.desktop.swing.component.combobox.UnitLOV;
import com.tripoin.pos.desktop.swing.component.dialog.base.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.textarea.DisabledTextArea;
import com.tripoin.pos.desktop.swing.component.textfield.DisabledTextField;
import com.tripoin.pos.shared.data.dto.response.ProductStockResponseDTO;
import com.tripoin.pos.shared.data.dto.response.ProductUnitResponseDTO;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 11/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ScaffoldingDialogProductStock extends AScaffoldingDialog<ProductStockResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2593952653246461722L;

    private UnitLOV unitLOV;

    @Override
    public void initComponents() {
        unitLOV = getUnitLOV();

        preferredHeight = 400;
        preferredWidth = 400;
        super.initComponents();
    }

    @Override
    public String[] getTitles() {
        return new String[] {
                "ui.dialog.detail.productstock.title",
                "ui.dialog.insert.productstock.title",
                "ui.dialog.update.productstock.title"
        };
    }

    @Override
    public List<Component> getDisabledModeFields() {
        unitLOV.initComponents();
        disabledTextFields = new LinkedList<>();

        DisabledTextField txtId = new DisabledTextField();
        DisabledTextField txtCode = new DisabledTextField();
        DisabledTextField txtName = new DisabledTextField();
        DisabledTextField txtDisplayStock = new DisabledTextField();
        DisabledTextField txtWarehouseStock = new DisabledTextField();
        DisabledTextArea txtRemarks = new DisabledTextArea();


        disabledTextFields.add(txtId);
        disabledTextFields.add(txtCode);
        disabledTextFields.add(txtName);
        disabledTextFields.add(unitLOV);
        disabledTextFields.add(txtDisplayStock);
        disabledTextFields.add(txtWarehouseStock);
        disabledTextFields.add(txtRemarks);

        return disabledTextFields;
    }

    @Override
    public List<Component> getEnabledModeFields() {
        unitLOV.initComponents();
        enabledTextFields = new LinkedList<>();

        JTextField txtId = new JTextField();
        JTextField txtCode = new JTextField();
        JTextField txtName = new JTextField();
        JTextField txtDisplayStock = new JTextField();
        JTextField txtWarehouseStock = new JTextField();
        JTextArea txtRemarks = new JTextArea();

        enabledTextFields.add(txtId);
        enabledTextFields.add(txtCode);
        enabledTextFields.add(txtName);
        enabledTextFields.add(txtDisplayStock);
        enabledTextFields.add(txtWarehouseStock);
        enabledTextFields.add(unitLOV);
        enabledTextFields.add(txtRemarks);

        return enabledTextFields;
    }

    @Override
    public ProductStockResponseDTO getDATAtoInsert() {
        ProductStockResponseDTO productStockResponseDTO = new ProductStockResponseDTO();
        ProductUnitResponseDTO productUnitResponseDTO = new ProductUnitResponseDTO();
        if (enabledTextFields.size() == getNumberOfComponent()) {
            productStockResponseDTO.setId(Long.valueOf(((JTextField) enabledTextFields.get(0)).getText()));
            productStockResponseDTO.setCode(((JTextField) enabledTextFields.get(1)).getText());
            productStockResponseDTO.setName(((JTextField) enabledTextFields.get(2)).getText());
            productStockResponseDTO.setDisplayStock(Integer.parseInt(((JTextField) enabledTextFields.get(3)).getText()));
            productStockResponseDTO.setWarehouseStock(Integer.parseInt(((JTextField) enabledTextFields.get(5)).getText()));
            productUnitResponseDTO.setId(((ALOV) enabledTextFields.get(5)).getSelectedId(((ALOV) enabledTextFields.get(5)).getSelectedIndex()));
            productStockResponseDTO.setRemarks(((JTextArea) enabledTextFields.get(6)).getText());
        }else {
            productStockResponseDTO.setCode(((JTextField) enabledTextFields.get(0)).getText());
            productStockResponseDTO.setName(((JTextField) enabledTextFields.get(1)).getText());
            productStockResponseDTO.setDisplayStock(Integer.parseInt(((JTextField) enabledTextFields.get(2)).getText()));
            productStockResponseDTO.setWarehouseStock(Integer.parseInt(((JTextField) enabledTextFields.get(3)).getText()));
            productUnitResponseDTO.setId(((ALOV) enabledTextFields.get(4)).getSelectedId(((ALOV) enabledTextFields.get(4)).getSelectedIndex()));
            productStockResponseDTO.setRemarks(((JTextArea) enabledTextFields.get(5)).getText());
        }
        productStockResponseDTO.setUnit(productUnitResponseDTO);
        return productStockResponseDTO;
    }

    @Override
    public String[] getLabelComponentText() {
        return new String[] {"Id", "Code", "Name", "Display Stock", "Warehouse Stock", "Unit", "Remarks"};
    }

    @Override
    public String[] getParamContentArray() {
        System.out.println(getParamContent().toString());
        return new String[] {String.valueOf(getParamContent().getId()), getParamContent().getCode(), getParamContent().getName(), String.valueOf(getParamContent().getDisplayStock()), String.valueOf(getParamContent().getWarehouseStock()), getParamContent().getUnit().getName(), getParamContent().getRemarks()};
    }

    public abstract UnitLOV getUnitLOV();
}
