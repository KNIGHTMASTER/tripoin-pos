package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import com.tripoin.pos.desktop.swing.component.button.scaffolding.ButtonFirstPage;
import com.tripoin.pos.desktop.swing.component.button.scaffolding.ButtonLastPage;
import com.tripoin.pos.desktop.swing.component.button.scaffolding.ButtonNextPage;
import com.tripoin.pos.desktop.swing.component.button.scaffolding.ButtonPrevPage;
import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 11/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class PanelPaginationButton extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 9028180633160356656L;

    public ButtonNextPage buttonNextPage;
    public ButtonPrevPage buttonPrevPage;
    public ButtonLastPage buttonLastPage;
    public ButtonFirstPage buttonFirstPage;

    @Override
    public void initComponents() {
        buttonNextPage = getButtonNextPage();
        buttonPrevPage = getButtonPrevPage();
        buttonLastPage = getButtonLastPage();
        buttonFirstPage = getButtonFirstPage();

        this.setLayout(new GridLayout(1, 4));

        this.add(buttonFirstPage);
        this.add(buttonPrevPage);
        this.add(buttonNextPage);
        this.add(buttonLastPage);
    }

    public abstract ButtonNextPage getButtonNextPage();
    public abstract ButtonPrevPage getButtonPrevPage();
    public abstract ButtonLastPage getButtonLastPage();
    public abstract ButtonFirstPage getButtonFirstPage();
}
