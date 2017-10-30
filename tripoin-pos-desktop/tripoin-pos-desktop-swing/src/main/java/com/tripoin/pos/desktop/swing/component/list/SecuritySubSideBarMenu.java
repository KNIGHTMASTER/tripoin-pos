package com.tripoin.pos.desktop.swing.component.list;

import com.tripoin.pos.desktop.swing.view.internalframe.InternalFrameRole;
import com.tripoin.pos.desktop.swing.view.internalframe.InternalFrameUser;
import com.tripoin.pos.desktop.swing.view.internalframe.SideBarInternalFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 10/29/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class SecuritySubSideBarMenu extends MultipleListSideBarMenu {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4393760998277041502L;

    @Autowired
    private InternalFrameUser internalFrameUser;

    @Autowired
    private InternalFrameRole internalFrameRole;

    @PostConstruct
    @Override
    public void initComponents() {
        super.initComponents();
    }

    @Override
    public Map<String, SideBarInternalFrame> getMapPreventionInternalFrame() {
        Map<String, SideBarInternalFrame> result = new HashMap<>();
        result.put(getListData()[0], internalFrameRole);
        result.put(getListData()[1], internalFrameUser);
        return result;
    }

    @Override
    public String[] getListData() {
        return new String[] {"Role", "User"};
    }
}
