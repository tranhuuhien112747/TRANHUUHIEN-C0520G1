package com.code.furamacasestudy.model.login;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    private Long roleId;
    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private Set<User> userSet;

    public Role() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
