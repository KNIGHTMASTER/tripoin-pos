package com.tripoin.pos.desktop.swing.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 10/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SectionHolderDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -3394653016133012345L;

    private String sectionName;
    private List<SubSectionHolderDTO> subSectionData;

    public List<SubSectionHolderDTO> getSubSectionData() {
        return subSectionData;
    }

    public void setSubSectionData(List<SubSectionHolderDTO> subSectionData) {
        this.subSectionData = subSectionData;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
