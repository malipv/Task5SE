package ru.inno.task5se.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.inno.task5se.entity.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "select ac.account_pool_id, ac.bussy, ac.id, ac.account_number " +
            "from account ac join account_pool ap on ac.account_pool_id = ap.id " +
            "where ap.branch_code = :branch_code " +
            "and ap.currency_code = :currency_code " +
            "and ap.mdm_code = :mdm_code " +
            "and ap.priority_code = :priority_code " +
            "and ap.registry_type_code = :registry_type_code " +
            "LIMIT 1",
            nativeQuery = true)
    public Optional<Account> getAccount(
            @Param("branch_code") String branchCode,
            @Param("currency_code") String currencyCode,
            @Param("mdm_code") String mdmCode,
            @Param("priority_code") String priorityCode,
            @Param("registry_type_code") String registryTypeCode);
}