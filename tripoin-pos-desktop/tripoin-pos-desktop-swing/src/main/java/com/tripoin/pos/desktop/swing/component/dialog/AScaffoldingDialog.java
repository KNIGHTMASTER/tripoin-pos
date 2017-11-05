package com.tripoin.pos.desktop.swing.component.dialog;

import com.tripoin.pos.desktop.swing.client.IScaffoldingClient;
import com.tripoin.pos.desktop.swing.component.base.ICentralizePositionComponent;
import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.button.base.ButtonClear;
import com.tripoin.pos.desktop.swing.component.button.base.ButtonSave;
import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.desktop.swing.component.textfield.DisabledTextField;
import com.tripoin.pos.desktop.swing.controller.panel.AControllerScaffolding;
import com.tripoin.pos.desktop.swing.dto.param.ControllerScaffoldingParam;
import com.tripoin.scaffolding.data.dto.response.GenericSingleDATAResponseDTO;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.util.IParameterizedComponent;
import id.co.telkomsigma.tgf.util.UIConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.swing.*;
import java.awt.*;
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

    @Autowired
    private ICentralizePositionComponent centralizePositionComponent;

    @Autowired
    protected IResourceBundleLocator rb;

    @Value("${splashscreen.icon.imageurl}")
    private String scaffoldingDetailIcon;

    @Autowired
    private ButtonSave buttonSave;

    @Autowired
    private ButtonClear buttonClear;

    protected int preferredHeight;

    protected int preferredWidth;

    protected static final Logger LOGGER = LoggerFactory.getLogger(AScaffoldingDialog.class);

    protected List<DisabledTextField> disabledTextFields;

    protected List<TextField> enabledTextFields;

    private JPanel panelRight;

    private JPanel panelLeft;

    private GenericSingleDATAResponseDTO<DATA> data;

    @Override
    public void initComponents() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image dialogIcon = kit.getImage(getClass().getClassLoader().getResource(scaffoldingDetailIcon));
        this.setIconImage(dialogIcon);
        this.setModal(true);
        this.setResizable(true);
        this.setSize(preferredWidth, preferredHeight);
        centralizePositionComponent.setDialogToCenter(this);

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
        for (int a = 0; a < getParamContentArray().length; a++) {
            if (disabledTextFields.size() > 0) {
                disabledTextFields.get(a).setText(getParamContentArray()[a]);
            }
        }
    }

    public void setFieldsUpdate() {
        enabledTextFields = getEnabledModeFields();
        for (int a=0; a<getParamContentArray().length; a++) {
            try{
                if (enabledTextFields.size() > 0) {
                    enabledTextFields.get(a).setText(getParamContentArray()[a]);
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
                this.setTitle(rb.getValue(getTitles()[0]));
                setButtonEnable(false);
                panelLeft.setLayout(new GridLayout(getNumberOfComponent(), 1));
                for (int a=0; a<getNumberOfComponent(); a++){
                    panelLeft.add(new JLabel(getLabelComponentText()[a]));
                }

                panelRight.setLayout(new GridLayout(getNumberOfComponent(), 1));
                for (DisabledTextField disabledTextField : getDisabledModeFields()){
                    panelRight.add(disabledTextField);
                }
                break;
            case INSERT:
                this.setSize(preferredWidth, preferredHeight-30);
                this.setTitle(rb.getValue(getTitles()[1]));
                setButtonEnable(true);
                panelLeft.setLayout(new GridLayout(getNumberOfComponent()-1, 1));
                for (int a=0; a<getNumberOfComponent()-1; a++){
                    panelLeft.add(new JLabel(getLabelComponentText()[a+1]));
                }

                panelRight.setLayout(new GridLayout(getNumberOfComponent()-1, 1));
                List<TextField> tempTextFields = getEnabledModeFields();
                tempTextFields.remove(0);
                for (TextField textField : tempTextFields){
                    panelRight.add(textField);
                }
                break;
            case UPDATE:
                this.setTitle(rb.getValue(getTitles()[2]));
                setButtonEnable(true);
                panelLeft.setLayout(new GridLayout(getNumberOfComponent(), 1));
                for (int a=0; a<getNumberOfComponent(); a++){
                    panelLeft.add(new JLabel(getLabelComponentText()[a]));
                }

                panelRight.setLayout(new GridLayout(getNumberOfComponent(), 1));
                if (enabledTextFields.size() > 0){
                    TextField fieldId = enabledTextFields.get(0);
                    fieldId.setEditable(false);
                    panelRight.add(fieldId);
                    for (TextField enabledTextField : enabledTextFields.subList(1, enabledTextFields.size())) {
                        panelRight.add(enabledTextField);
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
            getControllerScaffolding().setParam(controllerScaffoldingParam);
            if (enabledTextFields.size() == getNumberOfComponent()){
                getControllerScaffolding().update();
            }else {
                getControllerScaffolding().insert();
            }
        });
    }

    protected void clearDialogFields() {
        for (TextField textField : enabledTextFields){
            textField.setText(UIConstant.Common.Punctuation.EMPTY);
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

    public abstract List<DisabledTextField> getDisabledModeFields();

    public abstract List<TextField> getEnabledModeFields();

    public abstract int getNumberOfComponent();

    public abstract String[] getLabelComponentText();

    public abstract String [] getParamContentArray();

    public abstract AControllerScaffolding getControllerScaffolding();

    public abstract AScaffoldingTable getScaffoldingTable();

    public ButtonSave getButtonSave() {
        return buttonSave;
    }

    public void setButtonSave(ButtonSave buttonSave) {
        this.buttonSave = buttonSave;
    }

    public ButtonClear getButtonClear() {
        return buttonClear;
    }

    public void setButtonClear(ButtonClear buttonClear) {
        this.buttonClear = buttonClear;
    }
}
