package com.example.manganoob.Repository;

import com.example.manganoob.Model.RolePermission.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE Roles AUTO_INCREMENT = 1 ", nativeQuery = true)
    void AlterTableRoles();

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE Roles", nativeQuery = true)
    void TruncateTableRoles();


}
