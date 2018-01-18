package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import com.tripoin.pos.desktop.swing.component.base.ICentralizePositionComponent;
import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.button.base.ButtonDelete;
import com.tripoin.pos.desktop.swing.component.button.base.ButtonInsert;
import com.tripoin.pos.desktop.swing.component.button.base.ButtonRefresh;
import com.tripoin.pos.desktop.swing.component.button.base.ButtonUpdate;
import com.tripoin.pos.desktop.swing.component.button.scaffolding.ButtonFirstPage;
import com.tripoin.pos.desktop.swing.component.button.scaffolding.ButtonLastPage;
import com.tripoin.pos.desktop.swing.component.button.scaffolding.ButtonNextPage;
import com.tripoin.pos.desktop.swing.component.button.scaffolding.ButtonPrevPage;
import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxDisplayNumberOfData;
import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxFilter;
import com.tripoin.pos.desktop.swing.component.dialog.base.AScaffoldingDialog;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingDisplay;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingSearch;
import com.tripoin.pos.desktop.swing.component.label.LabelScaffoldingTitle;
import com.tripoin.pos.desktop.swing.component.scrollpane.AScaffoldingScrollPane;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.controller.panel.AScaffoldingController;
import com.tripoin.pos.desktop.swing.controller.panel.ThreadRefreshContentChecker;
import com.tripoin.pos.desktop.swing.dto.param.ControllerScaffoldingParam;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.util.UIConstant.Common.Punctuation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutionException;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class AScaffoldingPanel extends JPanel implements IComponentInitializer, IComponentAction {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4014844416320630738L;

    @Autowired
    protected IResourceBundleLocator rb;

    @Autowired
    protected ICentralizePositionComponent centralizePositionComponent;

    @Autowired
    private ThreadRefreshContentChecker threadRefreshContentChecker;

    @Value("${button.nextpage.imageurl}")
    private String nextPageImageUrl;

    @Value("${button.prevpage.imageurl}")
    private String prevPageImageUrl;

    @Value("${button.firstpage.imageurl}")
    private String firstPageImageUrl;

    @Value("${button.lastpage.imageurl}")
    private String lastPageImageUrl;

    protected PanelScaffoldingNorth panelScaffoldingNorth;
    protected PanelScaffoldingSouth panelScaffoldingSouth;
    protected AScaffoldingScrollPane scaffoldingScrollPane;
    protected AScaffoldingDialog scaffoldingDialog;

    private int currentPage = 0;
    private int totalPage = 0;

    protected static final Logger LOGGER = LoggerFactory.getLogger(AScaffoldingPanel.class);

    @Override
    public void initComponents() {
        panelScaffoldingNorth = new PanelScaffoldingNorth() {
            private static final long serialVersionUID = 8298531202750381429L;

            @Override
            public PanelScaffoldingNorthTop getPanelScaffoldingNorthTop() {
                return new PanelScaffoldingNorthTop() {
                    private static final long serialVersionUID = -8363575611672936019L;

                    @Override
                    public PanelScaffoldingActionButton getPanelScaffoldingActionButton() {
                        return new PanelScaffoldingActionButton() {
                            private static final long serialVersionUID = -3448925626659284219L;

                            @Override
                            public ButtonRefresh getButtonRefresh() {
                                buttonRefresh = new ButtonRefresh() {
                                    private static final long serialVersionUID = -5756479316464122703L;

                                    @Override
                                    public IResourceBundleLocator getRb() {
                                        return rb;
                                    }
                                };
                                buttonRefresh.initComponents();
                                return buttonRefresh;
                            }

                            @Override
                            public ButtonInsert getButtonInsert() {
                                buttonInsert = new ButtonInsert() {
                                    private static final long serialVersionUID = -8729999940003412065L;

                                    @Override
                                    public IResourceBundleLocator getRb() {
                                        return rb;
                                    }
                                };
                                buttonInsert.initComponents();
                                return buttonInsert;
                            }

                            @Override
                            public ButtonUpdate getButtonUpdate() {
                                buttonUpdate =  new ButtonUpdate() {
                                    private static final long serialVersionUID = -8181181640012128007L;

                                    @Override
                                    public IResourceBundleLocator getRb() {
                                        return rb;
                                    }
                                };
                                buttonUpdate.initComponents();
                                return buttonUpdate;
                            }

                            @Override
                            public ButtonDelete getButtonDelete() {
                                buttonDelete = new ButtonDelete() {
                                    private static final long serialVersionUID = 8364430905255679134L;

                                    @Override
                                    public IResourceBundleLocator getRb() {
                                        return rb;
                                    }
                                };
                                buttonDelete.initComponents();
                                return buttonDelete;
                            }
                        };
                    }

                    @Override
                    public LabelScaffoldingTitle getLabelScaffoldingTitle() {
                        return AScaffoldingPanel.this.getLabelScaffoldingTitle();
                    }
                };
            }

            @Override
            public PanelScaffoldingNorthBottom getPanelScaffoldingNorthBottom() {
                return new PanelScaffoldingNorthBottom() {
                    private static final long serialVersionUID = 414278115089922427L;

                    @Override
                    public LabelScaffoldingDisplay getLabelScaffoldingDisplay() {
                        LabelScaffoldingDisplay labelScaffoldingDisplay = new LabelScaffoldingDisplay() {
                            private static final long serialVersionUID = -3342926054383140138L;

                            @Override
                            public IResourceBundleLocator getRb() {
                                return rb;
                            }
                        };
                        labelScaffoldingDisplay.initComponents();
                        return labelScaffoldingDisplay;
                    }

                    @Override
                    public ComboBoxDisplayNumberOfData getComboBoxDisplayNumberOfData() {
                        comboBoxDisplayNumberOfData = new ComboBoxDisplayNumberOfData();
                        comboBoxDisplayNumberOfData.initComponents();
                        return comboBoxDisplayNumberOfData;
                    }

                    @Override
                    public LabelScaffoldingSearch getLabelScaffoldingSearch() {
                        LabelScaffoldingSearch labelScaffoldingSearch = new LabelScaffoldingSearch() {
                            private static final long serialVersionUID = -8160114556490932443L;

                            @Override
                            public IResourceBundleLocator getRb() {
                                return rb;
                            }
                        };
                        labelScaffoldingSearch.initComponents();
                        return labelScaffoldingSearch;
                    }

                    @Override
                    public ComboBoxFilter getComboBoxFilter() {
                        comboBoxFilter = new ComboBoxFilter();
                        comboBoxFilter.initComponents();
                        return comboBoxFilter;
                    }
                };
            }
        };
        panelScaffoldingNorth.initComponents();
        panelScaffoldingSouth = new PanelScaffoldingSouth() {
            private static final long serialVersionUID = -4832615529781735017L;

            @Override
            public PanelPaginationButton getPanelPaginationButton() {
                panelPaginationButton = new PanelPaginationButton() {
                    private static final long serialVersionUID = -1422985338606272075L;

                    @Override
                    public ButtonNextPage getButtonNextPage() {
                        buttonNextPage = new ButtonNextPage() {
                            private static final long serialVersionUID = 8154322648524053034L;

                            @Override
                            public String getImagePath() {
                                return nextPageImageUrl;
                            }
                        };
                        buttonNextPage.initComponents();
                        return buttonNextPage;
                    }

                    @Override
                    public ButtonPrevPage getButtonPrevPage() {
                        buttonPrevPage = new ButtonPrevPage() {
                            private static final long serialVersionUID = -2183456118066198148L;

                            @Override
                            public String getImagePath() {
                                return prevPageImageUrl;
                            }
                        };
                        buttonPrevPage.initComponents();
                        return buttonPrevPage;
                    }

                    @Override
                    public ButtonLastPage getButtonLastPage() {
                        buttonLastPage = new ButtonLastPage() {
                            private static final long serialVersionUID = 4313128592514733802L;

                            @Override
                            public String getImagePath() {
                                return lastPageImageUrl;
                            }
                        };
                        buttonLastPage.initComponents();
                        return buttonLastPage;
                    }

                    @Override
                    public ButtonFirstPage getButtonFirstPage() {
                        buttonFirstPage = new ButtonFirstPage() {
                            private static final long serialVersionUID = -7486073156242560896L;

                            @Override
                            public String getImagePath() {
                                return firstPageImageUrl;
                            }
                        };
                        buttonFirstPage.initComponents();
                        return buttonFirstPage;
                    }
                };
                panelPaginationButton.initComponents();
                return panelPaginationButton;
            }

        };
        panelScaffoldingSouth.initComponents();

        this.setLayout(new BorderLayout());
        this.add(panelScaffoldingNorth, BorderLayout.NORTH);
        this.add(scaffoldingScrollPane, BorderLayout.CENTER);
        this.add(panelScaffoldingSouth, BorderLayout.SOUTH);

        initAction();
    }

    @Override
    public void initAction() {
        ControllerScaffoldingParam controllerScaffoldingParam = new ControllerScaffoldingParam();
        controllerScaffoldingParam.setScaffoldingDialog(scaffoldingDialog);
        controllerScaffoldingParam.setScaffoldingTable(getScaffoldingTable());
        controllerScaffoldingParam.setScaffoldingClient(getScaffoldingTable().scaffoldingClient);

        panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.addActionListener(e -> {
                    currentPage = 0;
                    refreshContent(
                            panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedValue(panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedIndex()),
                            0,
                            AScaffoldingTable.FindMode.DEFAULT,
                            Punctuation.EMPTY
                    );
                }
        );


        panelScaffoldingNorth.panelScaffoldingNorthTop.panelScaffoldingActionButton.buttonRefresh.addActionListener(e -> refreshContent(
                        panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedValue(panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedIndex()),
                        0,
                        AScaffoldingTable.FindMode.DEFAULT,
                        Punctuation.EMPTY)
        );
        panelScaffoldingNorth.panelScaffoldingNorthTop.panelScaffoldingActionButton.buttonInsert.addActionListener(e -> {
            getControllerScaffolding().setParam(controllerScaffoldingParam);
            final Integer[] result = {null};
            SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>(){
                @Override
                protected Integer doInBackground() throws Exception {
                    while (result[0] == null) {
                        result[0] = threadRefreshContentChecker.check();
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        if (result[0] != null) {
                            break;
                        }
                    }
                    return result[0];
                }
            };
            worker.execute();

            getControllerScaffolding().showInsertDialog();
            try {
                worker.get();
                if (result[0] == 1) {
                    refreshContent(
                            panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedValue(panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedIndex()),
                            totalPage,
                            AScaffoldingTable.FindMode.DEFAULT,
                            Punctuation.EMPTY
                    );
                }
                threadRefreshContentChecker.update();
            } catch (InterruptedException | ExecutionException e1) {
                e1.printStackTrace();
            }

        });

        panelScaffoldingNorth.panelScaffoldingNorthTop.panelScaffoldingActionButton.buttonUpdate.addActionListener(e -> {
            controllerScaffoldingParam.setSelectedTableRow(getScaffoldingTable().getSelectedRow());
            getControllerScaffolding().setParam(controllerScaffoldingParam);
            getControllerScaffolding().showUpdateDialog();
        });

        panelScaffoldingNorth.panelScaffoldingNorthTop.panelScaffoldingActionButton.buttonDelete.addActionListener(e -> {
            int row = getScaffoldingTable().getSelectedRows().length;
            if (row <= -1) {
                JOptionPane.showMessageDialog(null, "Please choose a record on table");
            } else if (row == 1) {
                controllerScaffoldingParam.setSelectedTableRow(getScaffoldingTable().getSelectedRow());
                controllerScaffoldingParam.setComboBoxDisplayNumberOfData(panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData);
                getControllerScaffolding().setParam(controllerScaffoldingParam);
                getControllerScaffolding().delete();
            } else if (row > 1) {
                controllerScaffoldingParam.setSelectedTableRow(null);
                controllerScaffoldingParam.setSelectedTableRows(getScaffoldingTable().getSelectedRows());
                controllerScaffoldingParam.setComboBoxDisplayNumberOfData(panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData);
                getControllerScaffolding().setParam(controllerScaffoldingParam);
                getControllerScaffolding().delete();
            }
            refreshContent(
                    panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedValue(panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedIndex()),
                    totalPage,
                    AScaffoldingTable.FindMode.DEFAULT,
                    Punctuation.EMPTY
            );
            currentPage = totalPage;
        });

        getScaffoldingTable().getSelectionModel().addListSelectionListener(e -> {
            panelScaffoldingNorth.panelScaffoldingNorthTop.panelScaffoldingActionButton.buttonDelete.setEnabled(true);
            int row = getScaffoldingTable().getSelectedRow();
            if (row > -1) {
                panelScaffoldingNorth.panelScaffoldingNorthTop.panelScaffoldingActionButton.buttonDelete.setEnabled(true);
                panelScaffoldingNorth.panelScaffoldingNorthTop.panelScaffoldingActionButton.buttonUpdate.setEnabled(true);
            } else {
                panelScaffoldingNorth.panelScaffoldingNorthTop.panelScaffoldingActionButton.buttonDelete.setEnabled(false);
                panelScaffoldingNorth.panelScaffoldingNorthTop.panelScaffoldingActionButton.buttonUpdate.setEnabled(false);
            }
        });

        panelScaffoldingNorth.panelScaffoldingNorthBottom.getTxtSearch().addActionListener(e -> {
            currentPage = 0;
            refreshContent(
                    panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedValue(panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedIndex()),
                    0,
                    panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxFilter.getSelectedMode(panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxFilter.getSelectedIndex()),
                    panelScaffoldingNorth.panelScaffoldingNorthBottom.getTxtSearch().getText()
            );
            panelScaffoldingNorth.panelScaffoldingNorthBottom.getTxtSearch().setText(Punctuation.EMPTY);
        });

        panelScaffoldingSouth.panelPaginationButton.buttonNextPage.addActionListener(e -> {
            refreshContent(panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedValue(panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedIndex()),
                    currentPage + 1,
                    AScaffoldingTable.FindMode.DEFAULT,
                    Punctuation.EMPTY
            );
            currentPage += 1;
        });

        panelScaffoldingSouth.panelPaginationButton.buttonPrevPage.addActionListener(e -> {
            refreshContent(
                    panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedValue(panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedIndex()),
                    currentPage - 1,
                    AScaffoldingTable.FindMode.DEFAULT,
                    Punctuation.EMPTY
            );
            currentPage -= 1;
        });

        panelScaffoldingSouth.panelPaginationButton.buttonFirstPage.addActionListener(e -> {
            refreshContent(
                    panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedValue(panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedIndex()),
                    0,
                    AScaffoldingTable.FindMode.DEFAULT,
                    Punctuation.EMPTY
            );
            currentPage = 0;
        });

        panelScaffoldingSouth.panelPaginationButton.buttonLastPage.addActionListener(e -> {
            refreshContent(
                    panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedValue(panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedIndex()),
                    totalPage,
                    AScaffoldingTable.FindMode.DEFAULT,
                    Punctuation.EMPTY
            );
            currentPage = totalPage;
        });
    }

    public void refreshContent(int p_Size, int p_TargetPage, AScaffoldingTable.FindMode p_FindMode, String p_TextToSearch) {
        ControllerScaffoldingParam controllerScaffoldingParam = new ControllerScaffoldingParam();
        controllerScaffoldingParam.setScaffoldingDialog(scaffoldingDialog);
        controllerScaffoldingParam.setScaffoldingTable(getScaffoldingTable());
        controllerScaffoldingParam.setScaffoldingClient(getScaffoldingTable().scaffoldingClient);

        ResponseGenericPaginationDTO responseGenericPaginationDTO = getScaffoldingTable().refreshTableWithWorker(p_Size, p_TargetPage, p_FindMode, p_TextToSearch);
        controllerScaffoldingParam.setLabelIndex(panelScaffoldingSouth.panelPaginationIndex.labelIndex);
        controllerScaffoldingParam.setPanelPaginationButton(panelScaffoldingSouth.panelPaginationButton);
        controllerScaffoldingParam.setComboBoxDisplayNumberOfData(panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData);
        getControllerScaffolding().setParam(controllerScaffoldingParam);
        getControllerScaffolding().refreshTable(responseGenericPaginationDTO);
        totalPage = responseGenericPaginationDTO.getTotalPages()-1;

    }

    public abstract AScaffoldingTable getScaffoldingTable();

    public abstract AScaffoldingController getControllerScaffolding();

    public abstract LabelScaffoldingTitle getLabelScaffoldingTitle();

    public PanelScaffoldingNorth getPanelScaffoldingNorth() {
        return panelScaffoldingNorth;
    }

    /*public abstract AScaffoldingDialog getScaffoldingDialog();*/

    public class Test {
        public void refresh() {
            refreshContent(
                    panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedValue(panelScaffoldingNorth.panelScaffoldingNorthBottom.comboBoxDisplayNumberOfData.getSelectedIndex()),
                    totalPage,
                    AScaffoldingTable.FindMode.DEFAULT,
                    Punctuation.EMPTY
            );
            currentPage = totalPage;
        }
    }
}
