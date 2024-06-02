package com.unisatc.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.unisatc.marketplace.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{
    UserDetails findByLogin(String login);
}