package com.tripoin.pos.desktop.swing.dto;

import java.io.Serializable;

/**
 * Created on 10/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SubSectionHolderDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 7672947241024862012L;

    private String subSectionName;

    public String getSubSectionName() {
        return subSectionName;
    }

    public void setSubSectionName(String subSectionName) {
        this.subSectionName = subSectionName;
    }
}
