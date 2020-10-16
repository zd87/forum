package fr.formation.forum.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import fr.formation.forum.dtos.CommentCreateDto;
import fr.formation.forum.dtos.CommentViewDto;
import fr.formation.forum.dtos.QuotedCommentViewDto;
import fr.formation.forum.entities.Comment;
import fr.formation.forum.entities.Topic;
import fr.formation.forum.repositories.CommentRepository;
import fr.formation.forum.repositories.TopicRepository;

@Service
public class CommentService implements ICommentService {

    private final ModelMapper mapper;

    private final CommentRepository commentRepository;

    private final TopicRepository topicRepository;

    public CommentService(ModelMapper mapper,
	    CommentRepository commentRepository,
	    TopicRepository topicRepository) {
	this.mapper = mapper;
	this.commentRepository = commentRepository;
	this.topicRepository = topicRepository;
    }

    @Override
    public void create(Long id, CommentCreateDto commentDto) {
	Comment newComment = new Comment(commentDto.getUserName(),
		commentDto.getComment());
	Topic topic = topicRepository.findById(id).get();
	newComment.setTopic(topic);
	newComment.setCreationDate(LocalDateTime.now());
	if (commentDto.getQuotedCommentId() != null) {
	    Comment quotedComment = commentRepository
		    .findById(commentDto.getQuotedCommentId()).get();
	    newComment.setQuotedComment(quotedComment);
	}
	commentRepository.save(newComment);
    }

    @Override
    public List<CommentViewDto> getAll(Long id) {
	List<Comment> comments = commentRepository.findByTopicId(id);
	List<CommentViewDto> commentsDto = new ArrayList<>();
	comments.forEach(comment -> {
	    CommentViewDto convertedDto = mapper.map(comment,
		    CommentViewDto.class);
	    if (comment.getQuotedComment() != null) {
		QuotedCommentViewDto quotedComment = mapper.map(
			comment.getQuotedComment(), QuotedCommentViewDto.class);
		convertedDto.setQuotedComment(quotedComment);
	    }
	    commentsDto.add(convertedDto);
	});
	return commentsDto;
    }
}
