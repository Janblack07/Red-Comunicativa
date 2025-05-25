package org.example.redcomunicativa.Servicio;

import org.example.redcomunicativa.Entity.Chat;
import org.example.redcomunicativa.Entity.User;
import org.example.redcomunicativa.Repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    public Chat startChat(User sender, User receiver) {
        return chatRepository.findBySenderAndReceiver(sender, receiver)
                .orElseGet(() -> {
                    Chat chat = new Chat();
                    chat.setSender(sender);
                    chat.setReceiver(receiver);
                    chat.setCreatedAt(LocalDateTime.now());
                    return chatRepository.save(chat);
                });
    }

    public List<Chat> getUserChats(User user) {
        return chatRepository.findBySenderOrReceiver(user, user);
    }

    public Chat getChatById(Long id) {
        return chatRepository.findById(id).orElse(null);
    }
}
