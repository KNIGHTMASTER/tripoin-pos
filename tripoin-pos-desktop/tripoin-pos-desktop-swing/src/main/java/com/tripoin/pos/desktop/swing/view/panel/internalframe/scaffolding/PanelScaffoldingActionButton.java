package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import com.tripoin.pos.desktop.swing.component.button.base.ButtonDelete;
import com.tripoin.pos.desktop.swing.component.button.base.ButtonInsert;
import com.tripoin.pos.desktop.swing.component.button.base.ButtonRefresh;
import com.tripoin.pos.desktop.swing.component.button.base.ButtonUpdate;
import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class PanelScaffoldingActionButton extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1792669594882762977L;

    protected ButtonRefresh buttonRefresh;
    protected ButtonUpdate buttonUpdate;
    protected ButtonInsert buttonInsert;
    protected ButtonDelete buttonDelete;

    @Override
    public void initComponents() {
        buttonRefresh = getButtonRefresh();
        buttonUpdate = getButtonUpdate();
        buttonInsert = getButtonInsert();
        buttonDelete = getButtonDelete();

        this.setLayout(new GridLayout(1, 4));

        this.add(getButtonRefresh());
        this.add(getButtonInsert());
        this.add(getButtonUpdate());
        this.add(getButtonDelete());
    }

    public abstract ButtonRefresh getButtonRefresh();
    public abstract ButtonInsert getButtonInsert();
    public abstract ButtonUpdate getButtonUpdate();
    public abstract ButtonDelete getButtonDelete();
}
