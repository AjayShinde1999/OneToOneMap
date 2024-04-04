package com.onetoonemap.repository;

import com.onetoonemap.entity.User;
import com.onetoonemap.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {

    UserProfile findByUser(User user);
}
