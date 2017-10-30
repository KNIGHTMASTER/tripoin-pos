package com.tripoin.pos.desktop.swing.view.panel.tab.settings.language;

import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.button.panel.tab.settings.language.ButtonSavePanelTabSettingLanguage;
import com.tripoin.pos.desktop.swing.component.combobox.ComboBoxLanguage;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created on 5/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelTabSettingLanguage extends JPanel implements IComponentInitializer, IComponentAction {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4738722781399575192L;

    @Autowired
    private ComboBoxLanguage comboBoxLanguage;

    @Autowired
    @Qualifier("btSavePanelTabSettingLanguage")
    private ButtonSavePanelTabSettingLanguage btSave;

    @Autowired
    private IResourceBundleLocator rb;

    private static final Logger LOGGER = LoggerFactory.getLogger(PanelTabSettingLanguage.class);

    @PostConstruct
    @Override
    public void initComponents() {
        JLabel lblChooseLanguage = new JLabel(rb.getValue("ui.tab.language.label.chooselanguage"));

        this.setLayout(new GridBagLayout());

        this.add(lblChooseLanguage, new GridBagConstraints());
        this.add(comboBoxLanguage, new GridBagConstraints());
        this.add(btSave, new GridBagConstraints());

        initAction();
    }


    @Override
    public void initAction() {
    }
}
