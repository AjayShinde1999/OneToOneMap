package com.onetoonemap.controller;

import com.onetoonemap.entity.User;
import com.onetoonemap.service.UserService;
import com.onetoonemap.utils.DeleteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUserDetails(@RequestBody User user) {
        return userService.saveUserDetails(user);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserDetailsById(@PathVariable long id) {
        return userService.getUserDetailsById(id);
    }

    // http://localhost:8080/api/user?page=0&size=10&sortBy=id&sortOrder=asc
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsersDetails(@RequestParam(required = false, defaultValue = "0") int page,
                                         @RequestParam(required = false, defaultValue = "10") int size,
                                         @RequestParam(required = false, defaultValue = "id") String sortBy,
                                         @RequestParam(required = false, defaultValue = "asc") String sortOrder) {
        return userService.getAllUsers(page,size,sortBy,sortOrder);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUserDetailsById(@RequestBody User user, @PathVariable long id) {
        return userService.updateUserDetailsById(user, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeleteResponse deleteUserDetailsById(@PathVariable long id) {
        return userService.deleteUserDetailsById(id);
    }
}
