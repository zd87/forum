package fr.formation.forum.dtos;

public class QuotedCommentViewDto {

    private Long id;

    private String comment;

    public QuotedCommentViewDto(Long id, String comment) {
	this.id = id;
	this.comment = comment;
    }

    public QuotedCommentViewDto() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getComment() {
	return comment;
    }

    public void setComment(String comment) {
	this.comment = comment;
    }
}
