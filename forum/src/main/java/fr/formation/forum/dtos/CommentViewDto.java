package fr.formation.forum.dtos;

import java.time.LocalDateTime;

public class CommentViewDto {

    private Long id;

    private String userName;

    private LocalDateTime creationDate;

    private String comment;

    private QuotedCommentViewDto quotedComment;

    public CommentViewDto(Long id, String userName, LocalDateTime creationDate,
	    String comment, QuotedCommentViewDto quotedComment) {
	this.id = id;
	this.userName = userName;
	this.creationDate = creationDate;
	this.comment = comment;
	this.quotedComment = quotedComment;
    }

    public CommentViewDto() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public LocalDateTime getCreationDate() {
	return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
	this.creationDate = creationDate;
    }

    public String getComment() {
	return comment;
    }

    public void setComment(String comment) {
	this.comment = comment;
    }

    public QuotedCommentViewDto getQuotedComment() {
	return quotedComment;
    }

    public void setQuotedComment(QuotedCommentViewDto quotedComment) {
	this.quotedComment = quotedComment;
    }
}
