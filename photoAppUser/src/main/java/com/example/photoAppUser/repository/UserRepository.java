package com.example.photoAppUser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.photoAppUser.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{

	AppUser findByEmail(String email);

}
