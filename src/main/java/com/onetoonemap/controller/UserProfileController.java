package com.onetoonemap.controller;

import com.onetoonemap.entity.UserProfile;
import com.onetoonemap.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserProfile saveUserProfileDetails(@RequestBody UserProfile userProfile, @PathVariable long userId){
       return userProfileService.saveUserProfileDetails(userProfile,userId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserProfile> getAllUserProfilesDetails(){
        return userProfileService.getAllUsers();
    }
}
