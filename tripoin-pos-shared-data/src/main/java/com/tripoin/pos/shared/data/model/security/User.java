package com.tripoin.pos.shared.data.model.security;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "sec_user_details")
public class User extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -289635473022726494L;

    private Integer enabled;
    private Date ExpiredDate;
    private Date credentialsExpiredDate;
    private Integer nonLocked;
    private Role role;

    @Column(name = "enabled")
    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "expired_date")
    public Date getExpiredDate() {
        return ExpiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        ExpiredDate = expiredDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "credentials_expired_date")
    public Date getCredentialsExpiredDate() {
        return credentialsExpiredDate;
    }

    public void setCredentialsExpiredDate(Date credentialsExpiredDate) {
        this.credentialsExpiredDate = credentialsExpiredDate;
    }

    @Column(name = "non_locked")
    public Integer getNonLocked() {
        return nonLocked;
    }

    public void setNonLocked(Integer nonLocked) {
        this.nonLocked = nonLocked;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String tableName() {
        return "sec_user_details";
    }
}
