package org.example.redcomunicativa.Servicio;

import org.example.redcomunicativa.Entity.Chat;
import org.example.redcomunicativa.Entity.Message;
import org.example.redcomunicativa.Entity.User;
import org.example.redcomunicativa.Repository.ChatRepository;
import org.example.redcomunicativa.Repository.MessageRepository;
import org.example.redcomunicativa.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private UserRepository userRepository;


    public Page<Message> getMessages(Long chatId, int page, int size) {
        return messageRepository.findByChatIdOrderBySentAtDesc(chatId, PageRequest.of(page, size));
    }

    public Message sendMessage(Long chatId, Long senderId, String content) {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new RuntimeException("Chat no encontrado"));
        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Message message = new Message();
        message.setChat(chat);
        message.setSender(sender);
        message.setContent(content);
        message.setSentAt(LocalDateTime.now());

        return messageRepository.save(message);
    }
}
