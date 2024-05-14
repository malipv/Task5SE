package ru.inno.task5se.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.inno.task5se.entity.TppRefProductRegisterType;

import java.util.Optional;

public interface TppRefProductRegisterTypeRepository extends JpaRepository<TppRefProductRegisterType, Integer> {
    @Query(value = "select internal_id, value, register_type_name, product_class_code, register_type_start_date, register_type_end_date, account_type " +
            "from tpp_ref_product_register_type " +
            "where value = :value", nativeQuery = true)
    public Optional<TppRefProductRegisterType> findByValue(@Param("value") String value);

    @Query(value = "select prt.internal_id, prt.value, prt.register_type_name, prt.product_class_code, prt.register_type_start_date, prt.register_type_end_date, prt.account_type " +
            "from tpp_ref_product_register_type prt, tpp_ref_product_class pc " +
            "where prt.account_type = 'Клиентский' " +
            "and prt.product_class_code = pc.value " +
            "and pc.value = :value", nativeQuery = true)
    public Optional<TppRefProductRegisterType> findByProductClassValue(@Param("value") String value);
}