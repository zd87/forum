package fr.formation.forum.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45)
    private String userName;

    @Column(length = 500, nullable = false)
    private String comment;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "quoted_comment_id", foreignKey = @ForeignKey(name = "fk_quoted_comment"))
    private Comment quotedComment;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false, foreignKey = @ForeignKey(name = "fk_topic"))
    private Topic topic;

    public Comment(String userName, String comment) {
	this.userName = userName;
	this.comment = comment;
    }

    public Comment() {
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

    public String getComment() {
	return comment;
    }

    public void setComment(String comment) {
	this.comment = comment;
    }

    public Comment getQuotedComment() {
	return quotedComment;
    }

    public void setQuotedComment(Comment quotedComment) {
	this.quotedComment = quotedComment;
    }

    public LocalDateTime getCreationDate() {
	return creationDate;
    }

    public void setCreationDate(LocalDateTime createDate) {
	this.creationDate = createDate;
    }

    public Topic getTopic() {
	return topic;
    }

    public void setTopic(Topic topic) {
	this.topic = topic;
    }
}
