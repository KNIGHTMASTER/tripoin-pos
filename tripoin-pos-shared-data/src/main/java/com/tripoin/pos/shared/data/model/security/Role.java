package com.tripoin.pos.shared.data.model.security;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;
import java.util.Set;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "sec_role")
public class Role extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -3078840603630298526L;

    private Set<User> users;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String tableName() {
        return "sec_role";
    }
}
