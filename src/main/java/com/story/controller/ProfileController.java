package com.story.controller;

import com.story.enity.ProfileEntity;
import com.story.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<ProfileEntity>> getAllProfiles() {
        List<ProfileEntity> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @PostMapping
    public ResponseEntity<ProfileEntity> createProfile(@RequestBody ProfileEntity profile) {
        ProfileEntity createdProfile = profileService.createProfile(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProfile);
    }

    @DeleteMapping("/{id}") // Changed the mapping to accept an ID parameter
    public ResponseEntity<Void> deleteProfileById(@PathVariable Long id) {
        profileService.deleteProfileById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateProfileById(@PathVariable Long id, @RequestBody ProfileEntity updatedProfile) {
        profileService.updateProfileById(id, updatedProfile);
        return ResponseEntity.noContent().build();
    }

    // Add other CRUD endpoints and error handling
}
