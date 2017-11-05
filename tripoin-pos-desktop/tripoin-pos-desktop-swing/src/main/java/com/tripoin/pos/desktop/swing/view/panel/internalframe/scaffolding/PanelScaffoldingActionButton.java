package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import com.tripoin.pos.desktop.swing.component.button.base.ButtonDelete;
import com.tripoin.pos.desktop.swing.component.button.base.ButtonInsert;
import com.tripoin.pos.desktop.swing.component.button.base.ButtonRefresh;
import com.tripoin.pos.desktop.swing.component.button.base.ButtonUpdate;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelScaffoldingActionButton extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1792669594882762977L;

    @Autowired
    private ButtonRefresh buttonRefresh;

    @Autowired
    private ButtonInsert buttonInsert;

    @Autowired
    private ButtonUpdate buttonUpdate;

    @Autowired
    private ButtonDelete buttonDelete;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new GridLayout(1, 4));
        this.add(buttonRefresh);
        this.add(buttonInsert);
        this.add(buttonUpdate);
        this.add(buttonDelete);
    }

    public ButtonRefresh getButtonRefresh() {
        return buttonRefresh;
    }

    public void setButtonRefresh(ButtonRefresh buttonRefresh) {
        this.buttonRefresh = buttonRefresh;
    }

    public ButtonInsert getButtonInsert() {
        return buttonInsert;
    }

    public void setButtonInsert(ButtonInsert buttonInsert) {
        this.buttonInsert = buttonInsert;
    }

    public ButtonUpdate getButtonUpdate() {
        return buttonUpdate;
    }

    public void setButtonUpdate(ButtonUpdate buttonUpdate) {
        this.buttonUpdate = buttonUpdate;
    }

    public ButtonDelete getButtonDelete() {
        return buttonDelete;
    }

    public void setButtonDelete(ButtonDelete buttonDelete) {
        this.buttonDelete = buttonDelete;
    }
}
