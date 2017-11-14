package com.tripoin.pos.desktop.swing.component.button.panel.tab.settings.database;

import com.tripoin.pos.desktop.swing.component.base.IResourceBundleLocator;
import com.tripoin.pos.desktop.swing.component.button.base.ButtonSave;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 5/31/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
@Qualifier("btSavePanelTabSettingDatabase")
public class ButtonSavePanelTabSettingDatabase extends ButtonSave implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2246348129016613276L;

    @Autowired
    private IResourceBundleLocator rb;

    @PostConstruct
    @Override
    public void initComponents() {
        super.initComponents();
    }

    @Override
    public IResourceBundleLocator getRb() {
        return rb;
    }
}
