package fr.formation.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.forum.entities.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
