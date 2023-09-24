package com.authoriazation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authoriazation.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {

	AppUser findByEmail(String email);

}
