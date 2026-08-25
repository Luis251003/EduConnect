package com.luis.springboot.EduConnect.DTOs;

import java.time.LocalDateTime;

public record ErrorResponseDTO(
        LocalDateTime timestamp,
        int status,
        String error,
        String message
) {
}
