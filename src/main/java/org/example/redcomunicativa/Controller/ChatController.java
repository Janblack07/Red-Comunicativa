package org.example.redcomunicativa.Controller;

import org.example.redcomunicativa.Entity.Chat;
import org.example.redcomunicativa.Entity.User;
import org.example.redcomunicativa.Repository.UserRepository;
import org.example.redcomunicativa.Servicio.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/{receiverId}")
    public Chat startChat(@PathVariable Long receiverId, Principal principal) {
        User sender = userRepository.findByUsername(principal.getName()).orElseThrow();
        User receiver = userRepository.findById(receiverId).orElseThrow();
        return chatService.startChat(sender, receiver);
    }

    @GetMapping
    public List<Chat> myChats(Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).orElseThrow();
        return chatService.getUserChats(user);
    }
}
