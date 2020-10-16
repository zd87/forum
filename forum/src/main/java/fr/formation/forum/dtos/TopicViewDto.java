package fr.formation.forum.dtos;

import java.time.LocalDateTime;

public class TopicViewDto {

    private Long id;

    private String name;

    private String description;

    private LocalDateTime creationDate;

    public TopicViewDto(Long id, String name, String description,
	    LocalDateTime creationDate) {
	this.id = id;
	this.name = name;
	this.description = description;
	this.creationDate = creationDate;
    }

    public TopicViewDto() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public LocalDateTime getCreationDate() {
	return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
	this.creationDate = creationDate;
    }
}
