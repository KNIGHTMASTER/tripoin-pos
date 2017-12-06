package com.tripoin.pos.shared.data.dto.response.security;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

import java.util.Date;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class UserResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5673310125543905955L;
    private Integer enabled;
    private Date expiredDate;
    private Date credentialsExpiredDate;
    private Integer nonLocked;
    private RoleResponseDTO role;

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Date getCredentialsExpiredDate() {
        return credentialsExpiredDate;
    }

    public void setCredentialsExpiredDate(Date credentialsExpiredDate) {
        this.credentialsExpiredDate = credentialsExpiredDate;
    }

    public Integer getNonLocked() {
        return nonLocked;
    }

    public void setNonLocked(Integer nonLocked) {
        this.nonLocked = nonLocked;
    }

    public RoleResponseDTO getRole() {
        return role;
    }

    public void setRole(RoleResponseDTO role) {
        this.role = role;
    }
}
