package fr.formation.forum.services;

import java.util.List;

import fr.formation.forum.dtos.CommentCreateDto;
import fr.formation.forum.dtos.CommentViewDto;

public interface ICommentService {

    void create(Long id, CommentCreateDto commentDto);

    List<CommentViewDto> getAll(Long id);
}
