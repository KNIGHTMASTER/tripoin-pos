package com.tripoin.pos.desktop.swing.controller.tab;

import com.tripoin.pos.desktop.swing.component.dialog.base.DialogProgress;
import com.tripoin.pos.desktop.swing.view.tab.TabSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 7/7/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ControllerTabSettings {

/*
    @Autowired
    IRuntimeExecutor runtimeExecutor;

    @Value("${daemon.path}")
    String daemonPath;

    @Value("${daemon.filename}")
    String daemonFileName;

    @Value("${app.property.path}")
    String propertyPath;
*/

    @Autowired
    private DialogProgress dialogProgress;

    public void tabSettingChangePerformed(TabSettings tabSettings){
        if (tabSettings.getSelectedIndex() ==2){
            /*JLabel lblServiceStatus = tabSettings.getPanelTabSettingDaemon().getPanelTabSettingDaemonInception().getPanelTabSettingDaemonTop().getPanelTabSettingDaemonRight().getLblServiceStatus();
            if (runtimeExecutor.findPIDofJavaProcess(daemonFileName) != null){
                lblServiceStatus.setText("ON");
                lblServiceStatus.setBackground(Color.YELLOW);
            }else {
                lblServiceStatus.setText("OFF");
                lblServiceStatus.setBackground(Color.BLUE);
            }*/
        }
    }
}
