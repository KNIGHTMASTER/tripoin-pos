package com.tripoin.pos.desktop.swing.component.menuitem;

import org.springframework.stereotype.Component;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public abstract class MenuItemRefresh extends AMenuItem {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5439629453199502646L;

    @Override
    public String getCaption() {
        return "menuitem.refresh";
    }
}
