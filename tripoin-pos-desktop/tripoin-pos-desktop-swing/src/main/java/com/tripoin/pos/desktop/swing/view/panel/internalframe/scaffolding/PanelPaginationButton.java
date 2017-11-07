package com.tripoin.pos.desktop.swing.view.panel.internalframe.scaffolding;

import com.tripoin.pos.desktop.swing.component.button.scaffolding.ButtonFirstPage;
import com.tripoin.pos.desktop.swing.component.button.scaffolding.ButtonLastPage;
import com.tripoin.pos.desktop.swing.component.button.scaffolding.ButtonNextPage;
import com.tripoin.pos.desktop.swing.component.button.scaffolding.ButtonPrevPage;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created on 11/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelPaginationButton extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 9028180633160356656L;

    @Autowired
    private ButtonNextPage buttonNextPage;

    @Autowired
    private ButtonPrevPage buttonPrevPage;

    @Autowired
    private ButtonLastPage buttonLastPage;

    @Autowired
    private ButtonFirstPage buttonFirstPage;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new GridLayout(1, 4));
        this.add(buttonFirstPage);
        this.add(buttonPrevPage);
        this.add(buttonNextPage);
        this.add(buttonLastPage);
    }

    public ButtonNextPage getButtonNextPage() {
        return buttonNextPage;
    }

    public void setButtonNextPage(ButtonNextPage buttonNextPage) {
        this.buttonNextPage = buttonNextPage;
    }

    public ButtonPrevPage getButtonPrevPage() {
        return buttonPrevPage;
    }

    public void setButtonPrevPage(ButtonPrevPage buttonPrevPage) {
        this.buttonPrevPage = buttonPrevPage;
    }

    public ButtonLastPage getButtonLastPage() {
        return buttonLastPage;
    }

    public void setButtonLastPage(ButtonLastPage buttonLastPage) {
        this.buttonLastPage = buttonLastPage;
    }

    public ButtonFirstPage getButtonFirstPage() {
        return buttonFirstPage;
    }

    public void setButtonFirstPage(ButtonFirstPage buttonFirstPage) {
        this.buttonFirstPage = buttonFirstPage;
    }
}
