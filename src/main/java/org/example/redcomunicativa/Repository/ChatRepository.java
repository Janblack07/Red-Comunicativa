package org.example.redcomunicativa.Repository;

import org.example.redcomunicativa.Entity.Chat;
import org.example.redcomunicativa.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findBySenderOrReceiver(User sender, User receiver);

    Optional<Chat> findBySenderAndReceiver(User sender, User receiver);
}
