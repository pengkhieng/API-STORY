package com.story.service;

import com.story.enity.StoryEntity;
import com.story.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {
    @Autowired
    private StoryRepository storyRepository;

    public List<StoryEntity> getAllStories() {
        return storyRepository.findAll();
    }

    public StoryEntity createStory(StoryEntity story) {
        return storyRepository.save(story);
    }

    // Add other service methods as needed
}
