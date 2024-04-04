package com.onetoonemap.service.impl;

import com.onetoonemap.entity.User;
import com.onetoonemap.repository.UserRepository;
import com.onetoonemap.service.UserService;
import com.onetoonemap.utils.DeleteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUserDetails(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserDetailsById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers(int page, int size, String sortBy, String sortOrder) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortOrder.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy));
        Page<User> pageUsers = userRepository.findAll(pageRequest);
        return pageUsers.getContent();
    }

    @Override
    public User updateUserDetailsById(User user, long id) {
        User existingUser = userRepository.findById(id).get();
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public DeleteResponse deleteUserDetailsById(long id) {
        userRepository.deleteById(id);
        DeleteResponse response = new DeleteResponse();
        response.setMessage("Deleted Successfully");
        return response;
    }
}
