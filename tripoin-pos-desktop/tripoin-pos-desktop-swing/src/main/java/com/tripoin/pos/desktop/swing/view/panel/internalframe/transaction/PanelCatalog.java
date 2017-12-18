package com.tripoin.pos.desktop.swing.view.panel.internalframe.transaction;

import com.tripoin.pos.desktop.swing.client.IProductCategoryClient;
import com.tripoin.pos.shared.data.dto.response.master.ProductCategoryResponseDTO;
import com.tripoin.scaffolding.data.dto.response.GenericListResponseDTO;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

/**
 * Created on 10/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelCatalog extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5452046179225624338L;

    @Autowired
    private IProductCategoryClient productCategoryClient;

    private JButton btHomeCategory = new JButton("Home");

    private JPanel panelSearch = new JPanel();
    private JPanel panelSearchTop = new JPanel();
    private JPanel panelCatalog = new JPanel();

    private final String SEARCH = "Search";
    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new BorderLayout());


        panelSearch.setLayout(new GridLayout(2, 1));

        refreshCategory();

        panelSearch.add(panelSearchTop);
        JTextField txtSearch = new JTextField(SEARCH);
        txtSearch.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtSearch.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtSearch.getText() == null || txtSearch.getText().length() <= 0) {
                    txtSearch.setText(SEARCH);
                }
            }
        });
        panelSearch.add(txtSearch);

        this.add(panelSearch, BorderLayout.NORTH);
        this.add(panelCatalog, BorderLayout.CENTER);
    }

    public void refreshCategory(){
        Call<GenericListResponseDTO<ProductCategoryResponseDTO>> productCategoryList = productCategoryClient.findAll();
        GenericListResponseDTO<ProductCategoryResponseDTO> productCategoryResponseDTOs = null;
        try {
            productCategoryResponseDTOs = productCategoryList.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (panelSearchTop.getComponents().length != (productCategoryResponseDTOs.getContent().size() + 1)) {
            if (panelSearchTop.getComponents().length > 0) {
                panelSearchTop.removeAll();
            }
            panelSearchTop.setLayout(new GridLayout(1, (productCategoryResponseDTOs.getContent().size() + 1)));
            btHomeCategory.setSize(20, 100);
            panelSearchTop.add(btHomeCategory);
            for (ProductCategoryResponseDTO productCategoryResponseDTO : productCategoryResponseDTOs.getContent()) {
                JButton btCategory = new JButton(productCategoryResponseDTO.getName());
                btCategory.setSize(20, 100);
                panelSearchTop.add(btCategory);
            }
        }
    }
}
