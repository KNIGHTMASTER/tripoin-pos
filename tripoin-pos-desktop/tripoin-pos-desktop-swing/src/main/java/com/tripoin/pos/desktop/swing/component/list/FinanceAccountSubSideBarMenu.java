package com.tripoin.pos.desktop.swing.component.list;

import com.tripoin.pos.desktop.swing.view.internalframe.InternalFrameBank;
import com.tripoin.pos.desktop.swing.view.internalframe.InternalFrameFinanceAccount;
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
public class FinanceAccountSubSideBarMenu extends MultipleListSideBarMenu {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4393760998277041502L;

    @Autowired
    private InternalFrameFinanceAccount internalFrameFinanceAccount;

    @Autowired
    private InternalFrameBank internalFrameBank;

    @PostConstruct
    @Override
    public void initComponents() {
        super.initComponents();
    }

    @Override
    public Map<String, SideBarInternalFrame> getMapPreventionInternalFrame() {
        Map<String, SideBarInternalFrame> result = new HashMap<>();
        result.put(getListData()[0], internalFrameFinanceAccount);
        result.put(getListData()[1], internalFrameBank);
        return result;
    }

    @Override
    public String[] getListData() {
        return new String[]{"Finance Account", "Bank"};
    }
}
