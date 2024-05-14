package ru.inno.task5se.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

@Data
@ToString(exclude = "productRegisters")
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tpp_ref_product_register_type")
public class TppRefProductRegisterType {
    @Column(name = "internal_id")
    private Integer internalId;

    @Id
    @Column(name = "value", length = 100, nullable = false, unique = true)
    private String value;

    @OneToMany(mappedBy = "registerType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TppProductRegister> productRegisters = new ArrayList<>();

    @Column(name = "register_type_name", length = 100, nullable = false)
    private String registerTypeName;

    @Column(name = "product_class_code")
    private String productClassCode;

    @Column(name = "register_type_start_date")
    private Timestamp registerTypeStartDate;    //String -> Timestamp

    @Column(name = "register_type_end_date")
    private Timestamp registerTypeEndDate;      //String -> Timestamp

    @Column(name = "account_type")
    private String accountType;
}