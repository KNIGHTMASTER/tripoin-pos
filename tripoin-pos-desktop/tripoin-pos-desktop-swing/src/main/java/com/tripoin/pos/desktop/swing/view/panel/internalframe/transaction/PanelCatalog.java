package com.tripoin.pos.desktop.swing.view.panel.internalframe.transaction;

import com.tripoin.pos.desktop.swing.client.IProductCategoryClient;
import com.tripoin.pos.desktop.swing.client.IProductTypeClient;
import com.tripoin.pos.shared.data.dto.response.master.ProductCategoryResponseDTO;
import com.tripoin.pos.shared.data.dto.response.master.ProductTypeResponseDTO;
import com.tripoin.scaffolding.data.dto.request.RequestFindByCode;
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
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private IProductTypeClient productTypeClient;

    private JButton btHomeCategory = new JButton("Home");

    private JPanel panelSearch = new JPanel();
    private JPanel panelSearchTop = new JPanel();
    private JPanel panelCatalogItem = new JPanel();

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

        btHomeCategory.addActionListener(x -> {
            panelCatalogItem.removeAll();
            panelCatalogItem.revalidate();
            panelCatalogItem.repaint();
        });
        this.add(panelSearch, BorderLayout.NORTH);
        this.add(panelCatalogItem, BorderLayout.CENTER);
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
            panelSearchTop.add(btHomeCategory);
            int defaultCatalogRow = 4;
            int defaultCatalogCol = 5;
            for (ProductCategoryResponseDTO productCategoryResponseDTO : productCategoryResponseDTOs.getContent()) {
                JButton btCategory = new JButton(productCategoryResponseDTO.getName());
                btCategory.setName(productCategoryResponseDTO.getCode());
                btCategory.addActionListener(e -> {
                    RequestFindByCode requestFindByCode = new RequestFindByCode();
                    requestFindByCode.setCode(productCategoryResponseDTO.getCode());
                    Call<GenericListResponseDTO<ProductTypeResponseDTO>> listResponseDTOCall = productTypeClient.findByProductCategoryCode(requestFindByCode);
                    try {
                        GenericListResponseDTO<ProductTypeResponseDTO> responseRaw = listResponseDTOCall.execute().body();
                        if (responseRaw.getContent().size() > 0) {
                            if (panelCatalogItem.getComponents().length > 0) {
                                panelCatalogItem.removeAll();
                            }
                            int modResult = responseRaw.getContent().size() % defaultCatalogCol;
                            int rowResult = responseRaw.getContent().size() / defaultCatalogCol;
                            System.out.println("Size : "+responseRaw.getContent().size());
                            System.out.println("mod res : "+modResult);
                            System.out.println("row res : "+rowResult);
                            if (rowResult <= defaultCatalogRow) {
                                panelCatalogItem.setLayout(new GridLayout(defaultCatalogRow, 1));
                                java.util.List<JPanel> panelContentCatalogs = new ArrayList<>();
                                for (int i=0; i<defaultCatalogRow; i++) {
                                    JPanel panelContentCatalog = new JPanel();
                                    panelContentCatalog.setLayout(new GridLayout(1, defaultCatalogCol));
                                    panelContentCatalogs.add(panelContentCatalog);

                                    panelCatalogItem.add(panelContentCatalog);
                                }

                                if (rowResult <= 0) {
                                    rowResult = 1;
                                }
                                for (int b=0; b<rowResult; b++) {
                                    for (ProductTypeResponseDTO responseDTO : responseRaw.getContent()) {
                                        if (panelContentCatalogs.get(b).getComponentCount() < defaultCatalogCol) {
                                            panelContentCatalogs.get(b).add(new JButton(responseDTO.getName()));
                                        }
                                    }
                                }
                                if (modResult > 0) {
                                    List<ProductTypeResponseDTO> restResponse = responseRaw.getContent().subList((responseRaw.getContent().size()-modResult), responseRaw.getContent().size());
                                    for (ProductTypeResponseDTO productTypeResponseDTO : restResponse) {
                                        panelContentCatalogs.get(rowResult).add(new JButton(productTypeResponseDTO.getName()));
                                    }
                                    for (int a=0; a<(defaultCatalogCol - modResult); a++) {
                                        JButton disabledButton = new JButton();
                                        disabledButton.setEnabled(false);
                                        disabledButton.setVisible(false);
                                        panelContentCatalogs.get(rowResult).add(disabledButton);
                                    }
                                }
                            }
                            panelCatalogItem.revalidate();
                            panelCatalogItem.repaint();
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                });
                panelSearchTop.add(btCategory);
            }
        }
    }
}
