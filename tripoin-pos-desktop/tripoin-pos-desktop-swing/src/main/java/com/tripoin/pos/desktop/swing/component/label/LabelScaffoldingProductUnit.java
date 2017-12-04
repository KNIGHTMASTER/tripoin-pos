package com.tripoin.pos.desktop.swing.component.label;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class LabelScaffoldingProductUnit extends LabelScaffoldingTitle {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5847934870527555079L;

    @PostConstruct
    @Override
    public void initComponents() {
        super.initComponents();
    }

    @Override
    public String getCaption() {
        return "ui.scaffolding.title.productunit";
    }
}
