package ru.inno.task5se.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.inno.task5se.entity.Agreement;

import java.util.Optional;

public interface AgreesmentRepository extends JpaRepository<Agreement, Integer> {
    @Query(value = "select id, product_id, general_agreement_id, number " +
            "from agreement " +
            "where number = :number", nativeQuery = true)
    public Optional<Agreement> findByNumber(@Param("number") String number);
}