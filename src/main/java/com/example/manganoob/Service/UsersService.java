package com.example.manganoob.Service;

import com.example.manganoob.Model.Users;
import com.example.manganoob.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
    public Optional<Users> getUserById(int id) {
        return usersRepository.findById(id);
    }
    public Users addUser(Users user) {
        return usersRepository.save(user);
    }
    public void deleteUserById(int id) {
        usersRepository.deleteById(id);
    }
    public Users updateUserById(int id, Users users) {
        if (usersRepository.existsById(id)) {
            users.setUser_id(id);
            return this.usersRepository.save(users);
        } else {
            throw new IllegalArgumentException("User not found");
        }

    }
}
