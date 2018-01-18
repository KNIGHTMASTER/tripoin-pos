package com.tripoin.pos.desktop.swing.component.dialog.impl;

import com.tripoin.pos.desktop.swing.component.combobox.*;
import com.tripoin.pos.desktop.swing.component.dialog.base.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.textarea.DisabledTextArea;
import com.tripoin.pos.desktop.swing.component.textfield.DisabledTextField;
import com.tripoin.pos.shared.data.dto.response.master.*;
import com.tripoin.pos.shared.data.dto.response.trx.PriceResponseDTO;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 11/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ScaffoldingDialogProduct extends AScaffoldingDialog<ProductResponseDTO> {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2593952653246461722L;

    private ProductCategoryLOV productCategoryLOV;
    private ProductTypeLOV productTypeLOV;
    private ProductBrandLOV productBrandLOV;
    private SupplierLOV supplierLOV;
    private PriceLOV priceLOV;
    private ProductStockLOV productStockLOV;
    private ProductGuaranteeLOV productGuaranteeLOV;

    @Override
    public void initComponents() {
        preferredHeight = 600;
        preferredWidth = 550;

        productCategoryLOV = getProductCategoryLOV();
        productTypeLOV = getProductTypeLOV();
        productBrandLOV = getProductBrandLOV();
        supplierLOV = getSupplierLOV();
        priceLOV = getPriceLOV();
        productStockLOV = getProductStockLOV();
        productGuaranteeLOV = getProductGuaranteeLOV();

        super.initComponents();
    }

    @Override
    public String[] getTitles() {
        return new String[] {
                "ui.dialog.detail.product.title",
                "ui.dialog.insert.product.title",
                "ui.dialog.update.product.title"
        };
    }

    @Override
    public List<Component> getDisabledModeFields() {
        productCategoryLOV.initComponents();
        productTypeLOV.initComponents();
        productBrandLOV.initComponents();
        supplierLOV.initComponents();
        priceLOV.initComponents();
        productStockLOV.initComponents();
        productGuaranteeLOV.initComponents();

        disabledTextFields = new LinkedList<>();

        DisabledTextField txtId = new DisabledTextField();
        DisabledTextField txtCode = new DisabledTextField();
        DisabledTextField txtName = new DisabledTextField();
        DisabledTextField txtImageUrl = new DisabledTextField();
        DisabledTextArea txtRemarks = new DisabledTextArea();

        disabledTextFields.add(txtId);
        disabledTextFields.add(txtCode);
        disabledTextFields.add(txtName);
        disabledTextFields.add(productCategoryLOV);
        disabledTextFields.add(productTypeLOV);
        disabledTextFields.add(productBrandLOV);
        disabledTextFields.add(supplierLOV);
        disabledTextFields.add(priceLOV);
        disabledTextFields.add(productStockLOV);
        disabledTextFields.add(productGuaranteeLOV);
        disabledTextFields.add(txtImageUrl);
        disabledTextFields.add(txtRemarks);

        return disabledTextFields;
    }

    @Override
    public List<Component> getEnabledModeFields() {
        productCategoryLOV.initComponents();
        productTypeLOV.initComponents();
        productBrandLOV.initComponents();
        supplierLOV.initComponents();
        priceLOV.initComponents();
        productStockLOV.initComponents();
        productGuaranteeLOV.initComponents();

        enabledTextFields = new LinkedList<>();

        JTextField txtId = new JTextField();
        JTextField txtCode = new JTextField();
        JTextField txtName = new JTextField();
        JTextField txtImageUrl = new JTextField();
        JTextArea txtRemarks = new JTextArea();

        enabledTextFields.add(txtId);
        enabledTextFields.add(txtCode);
        enabledTextFields.add(txtName);
        enabledTextFields.add(productCategoryLOV);
        enabledTextFields.add(productTypeLOV);
        enabledTextFields.add(productBrandLOV);
        enabledTextFields.add(supplierLOV);
        enabledTextFields.add(priceLOV);
        enabledTextFields.add(productStockLOV);
        enabledTextFields.add(productGuaranteeLOV);
        enabledTextFields.add(txtImageUrl);
        enabledTextFields.add(txtRemarks);

        return enabledTextFields;
    }

    @Override
    public ProductResponseDTO getDATAtoInsert() {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        ProductCategoryResponseDTO productCategoryResponseDTO = new ProductCategoryResponseDTO();
        ProductTypeResponseDTO productTypeResponseDTO = new ProductTypeResponseDTO();
        ProductBrandResponseDTO productBrandResponseDTO = new ProductBrandResponseDTO();
        SupplierResponseDTO supplierResponseDTO = new SupplierResponseDTO();
        PriceResponseDTO priceResponseDTO = new PriceResponseDTO();
        ProductStockResponseDTO productStockResponseDTO = new ProductStockResponseDTO();
        ProductGuaranteeResponseDTO productGuaranteeResponseDTO = new ProductGuaranteeResponseDTO();

        if (enabledTextFields.size() == getNumberOfComponent()) {
            productResponseDTO.setId(Long.valueOf(((JTextField) enabledTextFields.get(0)).getText()));
            productResponseDTO.setCode(((JTextField) enabledTextFields.get(1)).getText());
            productResponseDTO.setName(((JTextField) enabledTextFields.get(2)).getText());

            productCategoryResponseDTO.setId(((ALOV) enabledTextFields.get(3)).getSelectedId(((ALOV) enabledTextFields.get(3)).getSelectedIndex()));
            productResponseDTO.setProductCategory(productCategoryResponseDTO);

            productTypeResponseDTO.setId(((ALOV) enabledTextFields.get(4)).getSelectedId(((ALOV) enabledTextFields.get(4)).getSelectedIndex()));
            productResponseDTO.setProductType(productTypeResponseDTO);

            productBrandResponseDTO.setId(((ALOV) enabledTextFields.get(5)).getSelectedId(((ALOV) enabledTextFields.get(5)).getSelectedIndex()));
            productResponseDTO.setProductBrand(productBrandResponseDTO);

            supplierResponseDTO.setId(((ALOV) enabledTextFields.get(6)).getSelectedId(((ALOV) enabledTextFields.get(6)).getSelectedIndex()));
            productResponseDTO.setSupplier(supplierResponseDTO);

            priceResponseDTO.setId(((ALOV) enabledTextFields.get(7)).getSelectedId(((ALOV) enabledTextFields.get(7)).getSelectedIndex()));
            productResponseDTO.setPrice(priceResponseDTO);

            productStockResponseDTO.setId(((ALOV) enabledTextFields.get(8)).getSelectedId(((ALOV) enabledTextFields.get(8)).getSelectedIndex()));
            productResponseDTO.setProductStock(productStockResponseDTO);

            productGuaranteeResponseDTO.setId(((ALOV) enabledTextFields.get(9)).getSelectedId(((ALOV) enabledTextFields.get(9)).getSelectedIndex()));
            productResponseDTO.setProductGuarantee(productGuaranteeResponseDTO);

            productResponseDTO.setImageUrl(((JTextField) enabledTextFields.get(10)).getText());

            productResponseDTO.setRemarks(((JTextArea) enabledTextFields.get(11)).getText());
        }else {
            productResponseDTO.setCode(((JTextField) enabledTextFields.get(0)).getText());
            productResponseDTO.setName(((JTextField) enabledTextFields.get(1)).getText());

            productCategoryResponseDTO.setId(((ALOV) enabledTextFields.get(2)).getSelectedId(((ALOV) enabledTextFields.get(2)).getSelectedIndex()));
            productResponseDTO.setProductCategory(productCategoryResponseDTO);

            productTypeResponseDTO.setId(((ALOV) enabledTextFields.get(3)).getSelectedId(((ALOV) enabledTextFields.get(3)).getSelectedIndex()));
            productResponseDTO.setProductType(productTypeResponseDTO);

            productBrandResponseDTO.setId(((ALOV) enabledTextFields.get(4)).getSelectedId(((ALOV) enabledTextFields.get(4)).getSelectedIndex()));
            productResponseDTO.setProductBrand(productBrandResponseDTO);

            supplierResponseDTO.setId(((ALOV) enabledTextFields.get(5)).getSelectedId(((ALOV) enabledTextFields.get(5)).getSelectedIndex()));
            productResponseDTO.setSupplier(supplierResponseDTO);

            priceResponseDTO.setId(((ALOV) enabledTextFields.get(6)).getSelectedId(((ALOV) enabledTextFields.get(6)).getSelectedIndex()));
            productResponseDTO.setPrice(priceResponseDTO);

            productStockResponseDTO.setId(((ALOV) enabledTextFields.get(7)).getSelectedId(((ALOV) enabledTextFields.get(7)).getSelectedIndex()));
            productResponseDTO.setProductStock(productStockResponseDTO);

            productGuaranteeResponseDTO.setId(((ALOV) enabledTextFields.get(8)).getSelectedId(((ALOV) enabledTextFields.get(8)).getSelectedIndex()));
            productResponseDTO.setProductGuarantee(productGuaranteeResponseDTO);

            productResponseDTO.setImageUrl(((JTextField) enabledTextFields.get(9)).getText());

            productResponseDTO.setRemarks(((JTextArea) enabledTextFields.get(10)).getText());
        }
        return productResponseDTO;
    }

    @Override
    public String[] getLabelComponentText() {
        return new String[] {"Id", "Code", "Name", "Category", "Type", "Brand", "Supplier", "Price", "Stock", "Guarantee", "Image Url", "Remarks"};
    }

    @Override
    public String[] getParamContentArray() {
        return new String[] {
                String.valueOf(getParamContent().getId()),
                getParamContent().getCode(),
                getParamContent().getName(),
                getParamContent().getProductCategory().getName(),
                getParamContent().getProductType().getName(),
                getParamContent().getProductBrand().getName(),
                getParamContent().getSupplier().getName(),
                getParamContent().getPrice().getName(),
                getParamContent().getProductStock().getName(),
                getParamContent().getProductGuarantee().getName(),
                getParamContent().getImageUrl(),
                getParamContent().getRemarks()
        };
    }

    public abstract ProductCategoryLOV getProductCategoryLOV();
    public abstract ProductTypeLOV getProductTypeLOV();
    public abstract ProductBrandLOV getProductBrandLOV();
    public abstract SupplierLOV getSupplierLOV();
    public abstract PriceLOV getPriceLOV();
    public abstract ProductStockLOV getProductStockLOV();
    public abstract ProductGuaranteeLOV getProductGuaranteeLOV();
}
