package com.example.manganoob.Repository;

import com.example.manganoob.Model.RolePermission.PermissionRole;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRolesRepository extends JpaRepository<PermissionRole,Integer>{


}

