package fr.formation.forum.dtos;

public class CommentCreateDto {

    private String userName;

    private String comment;

    private Long quotedCommentId;

    public CommentCreateDto(String userName, String comment,
	    Long quotedCommentId) {
	this.userName = userName;
	this.comment = comment;
	this.quotedCommentId = quotedCommentId;
    }

    public CommentCreateDto() {
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getComment() {
	return comment;
    }

    public void setComment(String comment) {
	this.comment = comment;
    }

    public Long getQuotedCommentId() {
	return quotedCommentId;
    }

    public void setQuotedCommentId(Long quotedCommentId) {
	this.quotedCommentId = quotedCommentId;
    }
}
