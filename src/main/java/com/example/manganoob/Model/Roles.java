package com.example.manganoob.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity

public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String role_name;
    private Date created_at;
    private Date updated_at;

    @OneToOne(mappedBy = "roles")
    private Users users;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "roles")
    private Set<PermissionRole> permissionRole;

    public Roles() {
    }

    public Roles(String role_name, Date created_at, Date updated_at) {
        this.role_name = role_name;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Set<PermissionRole> getPermissionRole() {
        return permissionRole;
    }

    public void setPermissionRole(Set<PermissionRole> permissionRole) {
        this.permissionRole = permissionRole;
    }


}