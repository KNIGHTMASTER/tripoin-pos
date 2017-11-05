package com.tripoin.pos.shared.data;

import com.tripoin.pos.shared.data.util.ExtractableValueDTO;

import java.io.Serializable;

/**
 * Created on 11/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CompanyTableDTO extends ExtractableValueDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8669008868142138581L;

    private Long id;
    private String code;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CompanyTableDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public String [] extractValues(){
        return new String[] {String.valueOf(id), code, name};
    }
}
