package fr.formation.forum.dtos;

public class TopicCreateDto {

    private String name;

    private String description;

    public TopicCreateDto(String name, String description) {
	this.name = name;
	this.description = description;
    }

    public TopicCreateDto() {
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
}
