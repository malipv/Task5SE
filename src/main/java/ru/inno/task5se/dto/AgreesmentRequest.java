package ru.inno.task5se.dto;

public record AgreesmentRequest(
        String generalAgreementId,
        String supplementaryAgreementId,
        String arrangementType,
        String number,
        String openingDate
) {
}