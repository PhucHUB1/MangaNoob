package com.example.manganoob.Repository;

import com.example.manganoob.Model.RolePermission.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

    void resetAutoIncrement();

}
