package fr.formation.forum.services;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import fr.formation.forum.dtos.TopicCreateDto;
import fr.formation.forum.dtos.TopicViewDto;
import fr.formation.forum.entities.Topic;
import fr.formation.forum.repositories.TopicRepository;

@Service
public class TopicService implements ITopicService {

    private final ModelMapper mapper;

    private final TopicRepository repository;

    public TopicService(ModelMapper mapper, TopicRepository repository) {
	this.mapper = mapper;
	this.repository = repository;
    }

    @Override
    public Topic create(TopicCreateDto topicDto) {
	Topic newTopic = mapper.map(topicDto, Topic.class);
	newTopic.setCreationDate(LocalDateTime.now());
	return repository.save(newTopic);
    }

    public TopicViewDto getOne(Long id) {
	Topic topic = repository.findById(id).get();
	TopicViewDto topicDto = mapper.map(topic, TopicViewDto.class);
	return topicDto;
    }
}
