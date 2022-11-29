package com.andygomez.main.controller;

import com.andygomez.main.entity.User;
import com.andygomez.main.exceptions.BusinessException;
import com.andygomez.main.exceptions.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping("/")
    public ResponseEntity saveUser(@RequestBody User user){
        if (user.getEmail().equals("") || user.getEmail().equals(null)){
            throw new RequestException("P-401","Email is required");
        }
        if (user.getName().equals("") || user.getName().equals(null)){
            throw new RequestException("P-402","Name is required");
        }
        if (user.getEmail().equals("raul@raul.raul")){
            throw new BusinessException("P-300", HttpStatus.INTERNAL_SERVER_ERROR, "Email already exist");
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity updateUser(@PathVariable("id") Long id, @RequestBody User user){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
