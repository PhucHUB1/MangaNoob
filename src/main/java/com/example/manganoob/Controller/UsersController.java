package com.example.manganoob.Controller;

import com.example.manganoob.Model.Users;
import com.example.manganoob.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/manga-noob/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/")
    public Users addUser(@RequestBody Users user) {
        return usersService.addUser(user);
    }
    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }
    @GetMapping("{id}")
    public ResponseEntity<Users>  getUserById(@PathVariable int id) {
        Optional<Users> optionalUser = usersService.getUserById(id);
      if (optionalUser.isPresent()) {
          return ResponseEntity.ok(optionalUser.get());
      }else {
          return ResponseEntity.notFound().build();
      }
    }
    @PutMapping("{id}")
    public ResponseEntity<Users> updateUserById(@PathVariable int id, @RequestBody Users user) {
        Optional<Users> Optionaluser = usersService.getUserById(id);
        if (Optionaluser.isPresent()) {
            Users updateUser = Optionaluser.get();
            updateUser.setName(user.getName());
            updateUser.setEmail(user.getEmail());
            updateUser.setPassword(user.getPassword());
            updateUser.setImage(user.getImage());
            Users updateUsers = usersService.updateUserById(id, updateUser);
            return ResponseEntity.ok(updateUsers);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Users> deleteUserById(@PathVariable int id) {
        Optional<Users> optionalUser = usersService.getUserById(id);
        if (optionalUser.isPresent()) {
            usersService.deleteUserById(id);
        }else {
            throw new IllegalArgumentException("User not found");
        }
        return ResponseEntity.ok().build();
    }


}
