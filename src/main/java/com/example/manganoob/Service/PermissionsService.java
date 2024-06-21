package com.example.manganoob.Service;

import com.example.manganoob.Model.Permissions;
import com.example.manganoob.Model.Roles;
import com.example.manganoob.Model.Users;
import com.example.manganoob.Repository.PermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionsService {
    @Autowired
    private PermissionsRepository permissionsRepository;

    public List<Permissions> getAllPermissions() {
        return permissionsRepository.findAll();
    }
    public Optional <Permissions> getPermissionById(int id) {
        return permissionsRepository.findById(id);
    }
    public Permissions createPermission(Permissions permissions) {
        return permissionsRepository.save(permissions);
    }
    public Permissions updatePermissionById(int id, Permissions permissions) {
        if (permissionsRepository.existsById(id)) {
            permissions.setId(id);
            return this.permissionsRepository.save(permissions);
        } else {
            throw new IllegalArgumentException("Permission not found");
        }
    }
    public void deletePermissionById(int id) {
        permissionsRepository.deleteById(id);
    }


}
