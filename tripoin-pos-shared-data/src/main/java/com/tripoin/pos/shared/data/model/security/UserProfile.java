package com.tripoin.pos.shared.data.model.security;

import com.tripoin.pos.shared.data.model.master.Address;
import com.tripoin.pos.shared.data.model.master.Branch;
import com.tripoin.pos.shared.data.model.master.Contact;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "user_profile")
public class UserProfile extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5346245787982057050L;

    private Address address;
    private Contact contact;
    private User user;
    private Branch branch;

    @OneToOne
    @JoinColumn(name = "address_id")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToOne
    @JoinColumn(name = "contact_id")
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @OneToOne
    @JoinColumn(name = "user_detail_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne
    @JoinColumn(name = "branch_id")
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String tableName() {
        return "user_profile";
    }
}
