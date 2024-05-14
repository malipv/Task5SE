package ru.inno.task5se.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.inno.task5se.enums.States;

@Data
@Entity
@Table(name = "tpp_product_register")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TppProductRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "type"/*, referencedColumnName = "value"*/)
    private TppRefProductRegisterType registerType;

    @Column(name = "account")
    private Integer account;

    @Column(name = "currency_code", length = 30)
    private String currencyCode;

    @Column(name = "state", length = 50)
    private States state;

    @Column(name = "account_number", length = 25)
    private String accountNumber;
}
