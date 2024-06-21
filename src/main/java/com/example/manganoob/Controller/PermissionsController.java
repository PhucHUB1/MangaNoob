package com.example.manganoob.Controller;

import com.example.manganoob.Model.RolePermission.Permissions;
import com.example.manganoob.Service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/manga-noob/permissions")
public class PermissionsController {
    @Autowired
    private PermissionsService permissionsService;

    @PostMapping("/")
    public Permissions createPermission(@RequestBody Permissions permissions) {
        return permissionsService.createPermission(permissions);
    }
    @GetMapping
    public List<Permissions> getAllPermissions() {
        return permissionsService.getAllPermissions();
    }
    @GetMapping("{id}")
    public ResponseEntity<Permissions> getPermissionsById(@PathVariable int id) {
        Optional<Permissions> optionalPermissions = permissionsService.getPermissionById(id);
        if (optionalPermissions.isPresent()) {
            return ResponseEntity.ok(optionalPermissions.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<Permissions> updatePermissionById(@PathVariable int id, @RequestBody Permissions permissions) {
        Optional<Permissions> optionalPermissions = permissionsService.getPermissionById(id);
        if (optionalPermissions.isPresent()) {
            Permissions updatePermission = optionalPermissions.get();
            updatePermission.setPermission_name(permissions.getPermission_name());
            Permissions permissionsUpdate = permissionsService.updatePermissionById(id, updatePermission);
            return ResponseEntity.ok(permissionsUpdate);
        }
            return ResponseEntity.notFound().build();
    }
//    @DeleteMapping("{id}")
//    public ResponseEntity<Permissions> deletePermissionById(@PathVariable int id) {
//        Optional<Permissions> optionalPermissions = permissionsService.getPermissionById(id);
//        if (optionalPermissions.isPresent()) {
//            permissionsService.deletePermissionById(id);
//        }else {
//            throw new IllegalArgumentException("Permission not found");
//        }
//        return ResponseEntity.ok().build();
//
//    }

}

