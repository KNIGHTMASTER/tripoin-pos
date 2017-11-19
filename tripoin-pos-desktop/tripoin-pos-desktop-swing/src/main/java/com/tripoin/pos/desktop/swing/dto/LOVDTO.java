package com.tripoin.pos.desktop.swing.dto;

import java.io.Serializable;

/**
 * Created on 11/15/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class LOVDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 7011263190021629940L;

    public LOVDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LOVDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
