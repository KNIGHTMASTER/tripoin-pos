package com.tripoin.pos.desktop.swing.component.dialog.base;

import com.tripoin.pos.desktop.swing.client.base.IScaffoldingClient;
import com.tripoin.pos.desktop.swing.component.base.ICentralizePositionComponent;
import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.button.base.ButtonClear;
import com.tripoin.pos.desktop.swing.component.button.base.ButtonSave;
import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxDisplayNumberOfData;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.controller.panel.AScaffoldingController;
import com.tripoin.pos.desktop.swing.dto.param.ControllerScaffoldingParam;
import com.tripoin.scaffolding.data.dto.response.GenericSingleDATAResponseDTO;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.util.IParameterizedComponent;
import id.co.telkomsigma.tgf.util.UIConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public abstract class AScaffoldingDialog<DATA> extends JDialog implements IComponentInitializer, IComponentAction, IParameterizedComponent<GenericSingleDATAResponseDTO<DATA>> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1978503025665914102L;

    private ComboBoxDisplayNumberOfData comboBoxDisplayNumberOfData;

    protected int preferredHeight;

    protected int preferredWidth;

    protected static final Logger LOGGER = LoggerFactory.getLogger(AScaffoldingDialog.class);

    protected List<Component> disabledTextFields;

    protected List<Component> enabledTextFields;

    private JPanel panelRight;

    private JPanel panelLeft;

    private GenericSingleDATAResponseDTO<DATA> data;

    private ButtonClear buttonClear;
    private ButtonSave buttonSave;

    @Override
    public void initComponents() {
        comboBoxDisplayNumberOfData = new ComboBoxDisplayNumberOfData();
        comboBoxDisplayNumberOfData.initComponents();

        buttonClear = new ButtonClear() {
            private static final long serialVersionUID = -8096061925657746600L;

            @Override
            public IResourceBundleLocator getRb() {
                return AScaffoldingDialog.this.getRb();
            }
        };
        buttonClear.initComponents();

        buttonSave = new ButtonSave() {
            private static final long serialVersionUID = -4667702327720732362L;

            @Override
            public IResourceBundleLocator getRb() {
                return AScaffoldingDialog.this.getRb();
            }
        };
        buttonSave.initComponents();

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image dialogIcon = kit.getImage(getClass().getClassLoader().getResource(getScaffoldingDialogIcon()));
        this.setIconImage(dialogIcon);
        this.setModal(true);
        this.setResizable(true);
        this.setSize(preferredWidth, preferredHeight);
        getCentralizePositionComponent().setDialogToCenter(this);

        panelLeft = new JPanel();
        panelRight = new JPanel();

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(1, 2));
        panelCenter.add(panelLeft);
        panelCenter.add(panelRight);

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 2));
        panelBottom.add(buttonClear);
        panelBottom.add(buttonSave);

        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelBottom, BorderLayout.SOUTH);

        initAction();
    }

    protected DATA getParamContent() {
        return data.getContent();
    }

    public void setFieldsDetail() {
        disabledTextFields = getDisabledModeFields();
        for (int a = 0; a < getParamContentArray().length; a++) {
            if (disabledTextFields.size() > 0) {
                if (disabledTextFields.get(a) instanceof JTextField) {
                    ((JTextField) disabledTextFields.get(a)).setText(getParamContentArray()[a]);
                } else if (disabledTextFields.get(a) instanceof JTextArea) {
                    ((JTextArea) disabledTextFields.get(a)).setText(getParamContentArray()[a]);
                } else if (disabledTextFields.get(a) instanceof JComboBox) {
                    ((JComboBox) disabledTextFields.get(a)).setSelectedItem(getParamContentArray()[a]);
                }
            }
        }
    }

    public void setFieldsUpdate() {
        enabledTextFields = getEnabledModeFields();
        for (int a=0; a<getParamContentArray().length; a++) {
            try{
                if (enabledTextFields.size() > 0) {
                    if (enabledTextFields.get(a) instanceof JTextField) {
                        ((JTextField) enabledTextFields.get(a)).setText(getParamContentArray()[a]);
                    }else if (enabledTextFields.get(a) instanceof  JTextArea) {
                        ((JTextArea) enabledTextFields.get(a)).setText(getParamContentArray()[a]);
                    }else if (enabledTextFields.get(a) instanceof  JComboBox) {
                        ((JComboBox)enabledTextFields.get(a)).setSelectedItem(getParamContentArray()[a]);
                    }
                }
            }catch (Exception e){
                LOGGER.debug("enabled text fields has been ignored");
            }

        }
    }

    @Override
    public void setParam(GenericSingleDATAResponseDTO<DATA> data) {
        this.data = data;
    }

    public void setModeDialog (ScaffoldingDialogMode mode) {
        if (panelLeft.getComponentCount() > 0) {
            for (Component component : panelLeft.getComponents()){
                panelLeft.remove(component);
            }
        }
        if (panelRight.getComponentCount() > 0){
            for (Component component : panelRight.getComponents()){
                panelRight.remove(component);
            }
        }

        switch (mode) {
            case DETAIL:
                this.setTitle(getRb().getValue(getTitles()[0]));
                setButtonEnable(false);
                panelLeft.setLayout(new GridLayout(getNumberOfComponent(), 1));
                for (int a=0; a<getNumberOfComponent(); a++){
                    panelLeft.add(new JLabel(getLabelComponentText()[a]));
                }

                panelRight.setLayout(new GridLayout(getNumberOfComponent(), 1));
                if (disabledTextFields.size() > 0){
                    disabledTextFields.forEach(panelRight::add);
                }
                break;
            case INSERT:
                this.setSize(preferredWidth, preferredHeight-30);
                this.setTitle(getRb().getValue(getTitles()[1]));
                setButtonEnable(true);
                panelLeft.setLayout(new GridLayout(getNumberOfComponent()-1, 1));
                for (int a=0; a<getNumberOfComponent()-1; a++){
                    panelLeft.add(new JLabel(getLabelComponentText()[a+1]));
                }

                panelRight.setLayout(new GridLayout(getNumberOfComponent()-1, 1));
                List<Component> tempTextFields = getEnabledModeFields();
                tempTextFields.remove(0);
                tempTextFields.forEach(panelRight::add);
                break;
            case UPDATE:
                this.setTitle(getRb().getValue(getTitles()[2]));
                setButtonEnable(true);
                panelLeft.setLayout(new GridLayout(getNumberOfComponent(), 1));
                for (int a=0; a<getNumberOfComponent(); a++){
                    panelLeft.add(new JLabel(getLabelComponentText()[a]));
                }

                panelRight.setLayout(new GridLayout(getNumberOfComponent(), 1));
                if (enabledTextFields.size() > 0){
                    JTextField fieldId = ((JTextField)enabledTextFields.get(0));
                    fieldId.setEditable(false);
                    panelRight.add(fieldId);
                    for (int a=1; a<enabledTextFields.size(); a++){
                        panelRight.add(enabledTextFields.get(a));
                    }
                }
                break;
            default:
        }
    }

    @Override
    public void initAction() {
        buttonClear.addActionListener(e -> clearDialogFields());
        buttonSave.addActionListener(e -> {
            ControllerScaffoldingParam controllerScaffoldingParam = new ControllerScaffoldingParam();
            controllerScaffoldingParam.setScaffoldingClient(getScaffoldingClient());
            controllerScaffoldingParam.setData(getDATAtoInsert());
            controllerScaffoldingParam.setScaffoldingDialog(this);
            controllerScaffoldingParam.setScaffoldingTable(getScaffoldingTable());
            controllerScaffoldingParam.setComboBoxDisplayNumberOfData(comboBoxDisplayNumberOfData);
            getControllerScaffolding().setParam(controllerScaffoldingParam);
            if (enabledTextFields.size() == getNumberOfComponent()){
                getControllerScaffolding().update();
            }else {
                getControllerScaffolding().insert();
            }
        });

        this.getRootPane().registerKeyboardAction(e -> {
            this.dispose();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    protected void clearDialogFields() {
        /*for (TextField textField : enabledTextFields){
            textField.setText(UIConstant.Common.Punctuation.EMPTY);
        }*/
        for (Component enabledTextField : enabledTextFields) {
            if (enabledTextField instanceof JTextField) {
                ((JTextField) enabledTextField).setText(UIConstant.Common.Punctuation.EMPTY);
            } else if (enabledTextField instanceof JTextArea) {
                ((JTextArea) enabledTextField).setText(UIConstant.Common.Punctuation.EMPTY);
            }
        }
        enabledTextFields.get(0).requestFocus();
    }

    public void setButtonEnable(boolean p_Enable) {
        buttonClear.setEnabled(p_Enable);
        buttonSave.setEnabled(p_Enable);
    }

    @Override
    public GenericSingleDATAResponseDTO<DATA> getParam() {
        return data;
    }

    public abstract IScaffoldingClient getScaffoldingClient();

    public abstract DATA getDATAtoInsert();

//    public abstract DATA getDATAtoUpdate();
    /**
     *
     * @return String [] title of Dialog.
     * Index 0 : Detail
     * Index 1 : Insert
     * Index 2 : Update
     */
    public abstract String[] getTitles();

    public abstract List<Component> getDisabledModeFields();

    public abstract List<Component> getEnabledModeFields();

    public int getNumberOfComponent() {
        return getLabelComponentText().length;
    }

    public abstract String[] getLabelComponentText();

    public abstract String [] getParamContentArray();

    public abstract AScaffoldingController getControllerScaffolding();

    public abstract AScaffoldingTable getScaffoldingTable();

    public abstract IResourceBundleLocator getRb();

    public abstract ICentralizePositionComponent getCentralizePositionComponent();

    public abstract String getScaffoldingDialogIcon();
}
