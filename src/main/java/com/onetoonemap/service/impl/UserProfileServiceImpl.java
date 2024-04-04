package com.onetoonemap.service.impl;

import com.onetoonemap.entity.User;
import com.onetoonemap.entity.UserProfile;
import com.onetoonemap.repository.UserProfileRepository;
import com.onetoonemap.repository.UserRepository;
import com.onetoonemap.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;


    @Override
    public UserProfile saveUserProfileDetails(UserProfile userProfile, long userId) {
        User user = userRepository.findById(userId).get();
        UserProfile existingProfile = userProfileRepository.findByUser(user);

        if (existingProfile == null) {
            userProfile.setUser(user);
            return userProfileRepository.save(userProfile);
        } else {
            throw new IllegalStateException("user profile already exists for this user");
        }
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return userProfileRepository.findAll();
    }
}
