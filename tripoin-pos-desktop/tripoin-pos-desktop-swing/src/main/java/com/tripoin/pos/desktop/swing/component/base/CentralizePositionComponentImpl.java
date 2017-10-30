package com.tripoin.pos.desktop.swing.component.base;

import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 5/29/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class CentralizePositionComponentImpl implements ICentralizePositionComponent {

    @Override
    public void setComponentToCenter(Component p_Component) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        p_Component.setLocation(dim.width / 2 - p_Component.getSize().width / 2, dim.height / 2 - p_Component.getSize().height/2);
    }

    @Override
    public void setDialogToCenter(JDialog p_JDialog) {
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - p_JDialog.getWidth()) / 2;
        final int y = (screenSize.height - p_JDialog.getHeight()) / 2;
        p_JDialog.setLocation(x, y);
    }

    @Override
    public void setIFrameToCenter(JInternalFrame p_JInternalFrame) {
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        Dimension jInternalFrameSize = p_JInternalFrame.getSize();
        p_JInternalFrame.setLocation(
                (screenSize.width - jInternalFrameSize.width)/5,
                (screenSize.height- jInternalFrameSize.height)/2
        );
    }

    @Override
    public void setIFrameToCenter(JInternalFrame p_JInternalFrame, int p_XDivider, int p_YDivider) {
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        Dimension jInternalFrameSize = p_JInternalFrame.getSize();
        p_JInternalFrame.setLocation(
                (screenSize.width - jInternalFrameSize.width)/p_XDivider,
                (screenSize.height- jInternalFrameSize.height)/p_YDivider
        );
    }

    @Override
    public void setIFrameToPosition(JInternalFrame p_JInternalFrame, int p_XPosition, int p_YPosition) {
        p_JInternalFrame.setLocation(p_XPosition, p_YPosition);
    }

    @Override
    public void setDialogCustomToCenter(JDialog p_JDialog, int p_XDivider, int p_YDivider) {
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - p_JDialog.getWidth()) / p_XDivider;
        final int y = (screenSize.height - p_JDialog.getHeight()) / p_YDivider;
        p_JDialog.setLocation(x, y);
    }
}
