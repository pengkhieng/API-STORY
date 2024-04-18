package com.story.service.Impl;


import com.story.enity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileServiceImpl extends JpaRepository<ProfileEntity, Long> {
}