package com.example.manganoob.Service;

import com.example.manganoob.Model.Roles;
import com.example.manganoob.Model.Users;
import com.example.manganoob.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    public Roles createRole(Roles roles) {
        return rolesRepository.save(roles);
    }
    public Optional<Roles> getRoleById(int id) {
        return rolesRepository.findById(id);
    }

    public Users updateRoleById(int id, Roles roles) {
        if (rolesRepository.existsById(id)) {
            roles.setId(id);
            return this.rolesRepository.save(roles).getUsers();
        } else {
            throw new IllegalArgumentException("Role not found");
        }
    }
    public void deleteRoleById(int id) {
        rolesRepository.deleteById(id);
    }
}
