package com.example.smallwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.smallwebapp.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

//	 User findbyUserId(String userId);

//	User findbyUserId(String userId);

}
