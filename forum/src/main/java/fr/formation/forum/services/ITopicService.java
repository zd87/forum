package fr.formation.forum.services;

import fr.formation.forum.dtos.TopicCreateDto;
import fr.formation.forum.dtos.TopicViewDto;
import fr.formation.forum.entities.Topic;

public interface ITopicService {

    Topic create(TopicCreateDto topicDto);

    TopicViewDto getOne(Long id);
}
