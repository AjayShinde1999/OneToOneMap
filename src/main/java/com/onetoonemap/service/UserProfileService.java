package com.onetoonemap.service;

import com.onetoonemap.entity.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile saveUserProfileDetails(UserProfile userProfile, long userId);

    List<UserProfile> getAllUsers();

}
