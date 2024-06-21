package com.example.manganoob.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity

public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String permission_name;
    private Date created_at;
    private Date updated_at;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "permissions")
    private Set<PermissionRole> permissionRole;

    public Permissions() {}
    public Permissions(String permission_name, Date created_at, Date updated_at) {
        this.permission_name = permission_name;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Set<PermissionRole> getPermissionRole() {
        return permissionRole;
    }

    public void setPermissionRole(Set<PermissionRole> permissionRole) {
        this.permissionRole = permissionRole;
    }
}
