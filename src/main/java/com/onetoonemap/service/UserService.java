package com.onetoonemap.service;

import com.onetoonemap.entity.User;
import com.onetoonemap.utils.DeleteResponse;

import java.util.List;

public interface UserService {

    User saveUserDetails(User user);

    User getUserDetailsById(long id);


    User updateUserDetailsById(User user, long id);

    DeleteResponse deleteUserDetailsById(long id);

    List<User> getAllUsers(int page, int size, String sortBy, String sortOrder);
}
