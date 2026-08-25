package com.luis.springboot.EduConnect.DTOs;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public record ValidationResponseDTO (
        LocalDateTime timestamp,
        int status,
        String error,
        Map<String, List<String>> body
){
}
