package com.example.manganoob.Repository;

import com.example.manganoob.Model.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionsRepository extends JpaRepository<Permissions, Integer> {
}
