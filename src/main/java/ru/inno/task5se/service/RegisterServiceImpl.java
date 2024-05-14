package ru.inno.task5se.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inno.task5se.dto.RegisterRequest;
import ru.inno.task5se.dto.RegisterResponse;
import ru.inno.task5se.entity.TppProductRegister;
import ru.inno.task5se.enums.States;
import ru.inno.task5se.exception.ExemplarNotFoundException;
import ru.inno.task5se.exception.FindDublException;
import ru.inno.task5se.repository.AccountRepository;
import ru.inno.task5se.repository.TppProductRegisterRepository;
import ru.inno.task5se.repository.TppRefProductRegisterTypeRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    private final TppProductRegisterRepository registerRepository;
    @Autowired
    private final TppRefProductRegisterTypeRepository registerTypeRepository;
    @Autowired
    private final AccountRepository accountRepository;

    @Override
    public RegisterResponse addProductRegister(RegisterRequest registerRequest) {

        var checkProductRegisterDubl = registerRepository.findByProductIdAndType(registerRequest.instanceId(), registerRequest.registryTypeCode());
        if (checkProductRegisterDubl.isPresent()) {
            throw new FindDublException("Параметр registryTypeCode тип регистра "
                            + registerRequest.registryTypeCode()
                    + " уже существует для ЭП с ИД "
                            + checkProductRegisterDubl.get().getId()
            );
        }


        var registerType = registerTypeRepository.findByValue(registerRequest.registryTypeCode());
        if (registerType.isEmpty()) {
            throw new ExemplarNotFoundException(
                    "Код Продукта "
                            + registerRequest.registryTypeCode()
                    + " не найдено в Каталоге продуктов для данного типа Регистра"
            );
        }

        var account = accountRepository.getAccount(
            registerRequest.branchCode(),
            registerRequest.currencyCode(),
            registerRequest.mdmCode(),
            registerRequest.priorityCode(),
            registerRequest.registryTypeCode()
        );

        TppProductRegister register = new TppProductRegister();
        register.setRegisterType(registerType.get());
        register.setProductId(registerRequest.instanceId());
        register.setAccount(account.get().getId());
        register.setState(States.OPEN);
        register.setAccountNumber(account.get().getAccountNumber());
        var registerRes = registerRepository.save(register);

        RegisterResponse res = new RegisterResponse(String.valueOf(registerRes.getId()));
        return res;
    }
}
