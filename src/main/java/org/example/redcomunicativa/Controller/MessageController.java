package org.example.redcomunicativa.Controller;

import org.example.redcomunicativa.DTOs.MessageDto;
import org.example.redcomunicativa.Entity.Message;
import org.example.redcomunicativa.Entity.User;
import org.example.redcomunicativa.Repository.UserRepository;
import org.example.redcomunicativa.Servicio.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Message sendMessage(@RequestBody MessageDto dto, Principal principal) {
        User sender = userRepository.findByUsername(principal.getName()).orElseThrow();
        return messageService.sendMessage(dto.getChatId(), sender.getId(), dto.getContent());
    }

    @GetMapping("/{chatId}")
    public Page<Message> getMessages(
            @PathVariable Long chatId,
            @RequestParam int page
    ) {
        return messageService.getMessages(chatId, page, 8);
    }
}
