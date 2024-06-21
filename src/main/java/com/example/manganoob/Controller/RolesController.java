package com.example.manganoob.Controller;

import com.example.manganoob.Model.Roles;
import com.example.manganoob.Service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/manga-noob/roles")
public class RolesController {
    @Autowired
    private RolesService rolesService;

   @PostMapping("/")
   public Roles addRole(@RequestBody Roles role) {
        return rolesService.createRole(role);
    }
    @GetMapping
    public List<Roles> getAllRole() {
        return rolesService.getAllRoles();
    }
    @GetMapping("{id}")
    public ResponseEntity<Roles> getRoleById(@PathVariable int id) {
        Optional<Roles> optionalRoles = rolesService.getRoleById(id);
        if (optionalRoles.isPresent()) {
            return ResponseEntity.ok(optionalRoles.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<Roles> updateRole(@PathVariable int id, @RequestBody Roles role) {
       Optional<Roles> optionalRoles = rolesService.getRoleById(id);
       if (optionalRoles.isPresent()) {
           Roles updateRoles = optionalRoles.get();
           updateRoles.setRole_name(role.getRole_name());
           Roles rolesUpdate = rolesService.updateRoleById(id,updateRoles).getRoles();
           return ResponseEntity.ok(rolesUpdate);
       }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Roles> deleteRoleById(@PathVariable int id) {
        Optional<Roles> optionalRoles = rolesService.getRoleById(id);
        if (optionalRoles.isPresent()) {
            rolesService.deleteRoleById(id);
        }else {
            throw new IllegalArgumentException("Role not found");
        }
        return ResponseEntity.ok().build();
    }

}
