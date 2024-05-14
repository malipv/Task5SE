package ru.inno.task5se.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.inno.task5se.entity.TppProductRegister;

import java.util.Optional;

public interface TppProductRegisterRepository extends JpaRepository<TppProductRegister, Integer> {
    @Query(value = "SELECT id, product_id, type, account, currency_code, state, account_number " +
            "FROM tpp_product_register " +
            "where product_id = :product_id " +
            "and type = :type"
            , nativeQuery = true)
    public Optional<TppProductRegister> findByProductIdAndType(@Param("product_id") Integer productId, @Param("type") String type);
}