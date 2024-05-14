package ru.inno.task5se.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.inno.task5se.entity.TppProduct;

import java.util.Optional;

public interface TppProductRepository extends JpaRepository<TppProduct, Integer> {
    @Query(value = "select id, product_code_id, client_id, type, number " +
            "from tpp_product " +
            "where number = :number", nativeQuery = true)
    public Optional<TppProduct> findByNumber(@Param("number") String number);
}