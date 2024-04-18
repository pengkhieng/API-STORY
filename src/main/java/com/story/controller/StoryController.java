package com.story.controller;

import com.story.enity.StoryEntity;
import com.story.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stories")
public class StoryController {
    @Autowired
    private StoryService storyService;

    @GetMapping
    public ResponseEntity<List<StoryEntity>> getAllStories() {
        List<StoryEntity> stories = storyService.getAllStories();
        return ResponseEntity.ok(stories);
    }

    @PostMapping
    public ResponseEntity<StoryEntity> createStory(@RequestBody StoryEntity story) {
        StoryEntity createdStory = storyService.createStory(story);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStory);
    }

    // Add other CRUD endpoints and error handling
}

