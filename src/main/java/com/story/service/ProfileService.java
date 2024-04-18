package com.story.service;

import com.story.enity.ProfileEntity;
import com.story.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public List<ProfileEntity> getAllProfiles() {
        return profileRepository.findAll();
    }

    public ProfileEntity createProfile(ProfileEntity profile) {
        return profileRepository.save(profile);
    }

    public void deleteProfileById(Long id) {
        profileRepository.deleteById(id);
    }

    public void updateProfileById(Long id, ProfileEntity updatedProfile) {
        // Retrieve the existing profile from the repository
        Optional<ProfileEntity> existingProfileOptional = profileRepository.findById(id);

        if (existingProfileOptional.isPresent()) {
            ProfileEntity existingProfile = existingProfileOptional.get();
            // Update the existing profile with the new data
            existingProfile.setUsername(updatedProfile.getUsername());
            existingProfile.setBio(updatedProfile.getBio());
            // Update other fields as needed

            // Save the updated profile back to the repository
            profileRepository.save(existingProfile);
        } else {
            throw new NotFoundException("Profile not found with id: " + id);
        }
    }
    // Add other service methods as needed
}
