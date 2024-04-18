package com.story.service.Impl;


import com.story.enity.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryServiceImpl extends JpaRepository<StoryEntity, Long> {
}