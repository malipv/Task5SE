package ru.inno.task5se.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.task5se.entity.AccountPool;

public interface AccountPoolRepository extends JpaRepository<AccountPool, Integer> {
}