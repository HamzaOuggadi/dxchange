package gg.astrub.astrub.repositories;

import gg.astrub.astrub.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface MessageRepository extends JpaRepository<Message, Long> {
}
