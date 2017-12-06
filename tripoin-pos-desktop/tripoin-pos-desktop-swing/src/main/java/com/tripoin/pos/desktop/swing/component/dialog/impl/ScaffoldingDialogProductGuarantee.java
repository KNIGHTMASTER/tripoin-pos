package com.tripoin.pos.desktop.swing.component.dialog.impl;

import com.tripoin.pos.desktop.swing.component.dialog.base.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.textarea.DisabledTextArea;
import com.tripoin.pos.desktop.swing.component.textfield.DisabledTextField;
import com.tripoin.pos.shared.data.dto.response.master.ProductGuaranteeResponseDTO;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 11/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ScaffoldingDialogProductGuarantee extends AScaffoldingDialog<ProductGuaranteeResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2593952653246461722L;

    @Override
    public void initComponents() {
        preferredHeight = 250;
        preferredWidth = 400;
        super.initComponents();
    }

    @Override
    public String[] getTitles() {
        return new String[] {
                "ui.dialog.detail.productguarantee.title",
                "ui.dialog.insert.productguarantee.title",
                "ui.dialog.update.productguarantee.title"
        };
    }

    @Override
    public List<Component> getDisabledModeFields() {
        disabledTextFields = new LinkedList<>();

        DisabledTextField txtId = new DisabledTextField();
        DisabledTextField txtCode = new DisabledTextField();
        DisabledTextField txtName = new DisabledTextField();
        DisabledTextField txtMerchantGuarantee = new DisabledTextField();
        DisabledTextField txtBrandGuarantee = new DisabledTextField();
        DisabledTextArea txtRemarks = new DisabledTextArea();

        disabledTextFields.add(txtId);
        disabledTextFields.add(txtCode);
        disabledTextFields.add(txtName);
        disabledTextFields.add(txtMerchantGuarantee);
        disabledTextFields.add(txtBrandGuarantee);
        disabledTextFields.add(txtRemarks);

        return disabledTextFields;
    }

    @Override
    public List<Component> getEnabledModeFields() {
        enabledTextFields = new LinkedList<>();

        JTextField txtId = new JTextField();
        JTextField txtCode = new JTextField();
        JTextField txtName = new JTextField();
        JTextField txtMerchantGuarantee = new JTextField();
        JTextField txtBrandGuarantee = new JTextField();
        JTextArea txtRemarks = new JTextArea();

        enabledTextFields.add(txtId);
        enabledTextFields.add(txtCode);
        enabledTextFields.add(txtName);
        enabledTextFields.add(txtMerchantGuarantee);
        enabledTextFields.add(txtBrandGuarantee);
        enabledTextFields.add(txtRemarks);

        return enabledTextFields;
    }

    @Override
    public ProductGuaranteeResponseDTO getDATAtoInsert() {
        ProductGuaranteeResponseDTO productGuaranteeResponseDTO = new ProductGuaranteeResponseDTO();
        if (enabledTextFields.size() == getNumberOfComponent()) {
            productGuaranteeResponseDTO.setId(Long.valueOf(((JTextField) enabledTextFields.get(0)).getText()));
            productGuaranteeResponseDTO.setCode(((JTextField) enabledTextFields.get(1)).getText());
            productGuaranteeResponseDTO.setName(((JTextField) enabledTextFields.get(2)).getText());
            productGuaranteeResponseDTO.setMerchantGuarantee(Integer.parseInt(((JTextField) enabledTextFields.get(3)).getText()));
            productGuaranteeResponseDTO.setBrandGuarantee(Integer.parseInt(((JTextField) enabledTextFields.get(4)).getText()));
            productGuaranteeResponseDTO.setRemarks(((JTextArea) enabledTextFields.get(5)).getText());
        }else {
            productGuaranteeResponseDTO.setCode(((JTextField) enabledTextFields.get(0)).getText());
            productGuaranteeResponseDTO.setName(((JTextField) enabledTextFields.get(1)).getText());
            productGuaranteeResponseDTO.setMerchantGuarantee(Integer.parseInt(((JTextField) enabledTextFields.get(2)).getText()));
            productGuaranteeResponseDTO.setBrandGuarantee(Integer.parseInt(((JTextField) enabledTextFields.get(3)).getText()));
            productGuaranteeResponseDTO.setRemarks(((JTextArea) enabledTextFields.get(2)).getText());
        }
        return productGuaranteeResponseDTO;
    }

    @Override
    public String[] getLabelComponentText() {
        return new String[] {"Id", "Code", "Name", "Merchant Guarantee", "Brand Guarantee", "Remarks"};
    }

    @Override
    public String[] getParamContentArray() {
        return new String[] {
                String.valueOf(getParamContent().getId()),
                getParamContent().getCode(),
                getParamContent().getName(),
                String.valueOf(getParamContent().getMerchantGuarantee()),
                String.valueOf(getParamContent().getBrandGuarantee()),
                getParamContent().getRemarks()};
    }
}
