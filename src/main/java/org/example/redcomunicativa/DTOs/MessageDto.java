package org.example.redcomunicativa.DTOs;

import lombok.Data;

@Data
public class MessageDto {
    private Long chatId;
    private String content;
}
