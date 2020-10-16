package fr.formation.forum.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.forum.dtos.TopicCreateDto;
import fr.formation.forum.dtos.TopicViewDto;
import fr.formation.forum.entities.Topic;
import fr.formation.forum.services.TopicService;

@RestController
@RequestMapping("/topics")
@CrossOrigin("*")
public class TopicController {

    private final TopicService service;

    public TopicController(TopicService service) {
	this.service = service;
    }

    @PostMapping
    public Topic create(@RequestBody TopicCreateDto topicDto) {
	return service.create(topicDto);
    }

    @GetMapping("/{id}")
    public TopicViewDto getOne(@PathVariable("id") Long id) {
	return service.getOne(id);
    }
}
