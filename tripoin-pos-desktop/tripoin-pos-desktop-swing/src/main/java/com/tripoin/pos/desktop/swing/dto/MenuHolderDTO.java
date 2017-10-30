package com.tripoin.pos.desktop.swing.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 10/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class MenuHolderDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2616451881890843658L;

    private String menuName;
    private List<SectionHolderDTO> sectionData;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<SectionHolderDTO> getSectionData() {
        return sectionData;
    }

    public void setSectionData(List<SectionHolderDTO> sectionData) {
        this.sectionData = sectionData;
    }
}

