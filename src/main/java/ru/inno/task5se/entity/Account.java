package ru.inno.task5se.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "account_pool_id")
    private AccountPool accountPool;

    @Column(name = "account_number", length = 25)
    private String accountNumber;

    @Column(name = "bussy")
    private Boolean bussy;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", bussy=" + bussy +
                '}';
    }
}