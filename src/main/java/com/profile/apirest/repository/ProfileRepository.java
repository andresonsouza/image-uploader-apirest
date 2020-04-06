package com.profile.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profile.apirest.models.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

	Profile findById(long id);
	
}
