package org.example.redcomunicativa.Repository;

import org.example.redcomunicativa.Entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Page<Message> findByChatIdOrderBySentAtDesc(Long chatId, Pageable pageable);
}
