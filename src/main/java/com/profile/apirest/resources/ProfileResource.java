package com.profile.apirest.resources;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.profile.apirest.models.Profile;
import com.profile.apirest.repository.ProfileRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
	
	@PostMapping("/profile")
		public Profile uploadImage(@RequestParam("myFile") MultipartFile file) throws IOException {
		
		Profile img = new Profile( file.getOriginalFilename(),file.getContentType(),file.getBytes() );
		
		final Profile savedImage = profileRepository.save(img);
		
        System.out.println("Image saved");

        return savedImage;
	}
}
