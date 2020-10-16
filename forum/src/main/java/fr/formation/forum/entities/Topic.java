package fr.formation.forum.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    public Topic(String name, String description, LocalDateTime createDate) {
	this.name = name;
	this.description = description;
	this.creationDate = createDate;
    }

    public Topic() {
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

    public void setCreationDate(LocalDateTime createDate) {
	this.creationDate = createDate;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "name: " + name + ", description: " + description
		+ ", creation date: " + creationDate;
    }
}
