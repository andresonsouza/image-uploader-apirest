package com.profile.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profile.apirest.models.Profile;
import com.profile.apirest.repository.ProfileRepository;

@RestController
@RequestMapping("/api")
public class ProfileResource {

	@Autowired
	ProfileRepository profileRepository;

	@GetMapping("/profiles")
	public List<Profile> listaProfiles() {
		return profileRepository.findAll();
	}
	
	@GetMapping("/profile/{id}")
	public Profile listaProfileId(@PathVariable(value="id") long id) {
		return profileRepository.findById(id);
	}
}
