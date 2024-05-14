package ru.inno.task5se.service;

import ru.inno.task5se.dto.RegisterRequest;
import ru.inno.task5se.dto.RegisterResponse;

public interface RegisterService {
    public RegisterResponse addProductRegister(RegisterRequest registerRequest);
}
