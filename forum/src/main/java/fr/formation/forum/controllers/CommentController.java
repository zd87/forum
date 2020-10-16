package fr.formation.forum.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.forum.dtos.CommentCreateDto;
import fr.formation.forum.dtos.CommentViewDto;
import fr.formation.forum.services.CommentService;

@RestController
@RequestMapping("topics/{id}/comments")
@CrossOrigin("*")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@PathVariable Long id,
	    @RequestBody CommentCreateDto commentDto) {
	service.create(id, commentDto);
    }

    @GetMapping
    public List<CommentViewDto> getAll(@PathVariable Long id) {
	return service.getAll(id);
    }
}
