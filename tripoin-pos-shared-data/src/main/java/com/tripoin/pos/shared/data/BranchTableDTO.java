package com.tripoin.pos.shared.data;

import com.tripoin.pos.shared.data.util.ExtractableValueDTO;

import java.io.Serializable;

/**
 * Created on 11/10/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class BranchTableDTO extends ExtractableValueDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 3804645856350751959L;

    private Long id;
    private String code;
    private String name;
    private String remarks;
    private CompanyTableDTO company;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public CompanyTableDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyTableDTO company) {
        this.company = company;
    }

    @Override
    public String[] extractValues() {
        return new String[]{String.valueOf(id), code, name, remarks, String.valueOf(company.getId())};
    }

    @Override
    public String toString() {
        return "BranchTableDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
