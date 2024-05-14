package ru.inno.task5se.dto;

import java.util.List;

public record ProductResponse(
        String instanceId,
        List<String> registerId,
        List<String> supplementaryAgreementId
) {
}