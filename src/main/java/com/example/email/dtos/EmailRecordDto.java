package com.example.email.dtos;

import java.util.UUID;

public record EmailRecordDto(UUID userId, UUID emailId, String emailTo, String subject, String text) {
}
