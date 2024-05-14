package ru.inno.task5se.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude = "accounts")
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "account_pool")
public class AccountPool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "branch_code", length = 50)
    private String branchCode;

    @Column(name = "currency_code", length = 30)
    private String currencyCode;

    @Column(name = "mdm_code", length = 50)
    private String mdmCode;

    @Column(name = "priority_code", length = 30)
    private String priorityCode;

    @Column(name = "registry_type_code", length = 50)
    private String registryTypeCode;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "account_pool_id")
    private List<Account> accounts = new ArrayList<>();

/*
    @Override
    public String toString() {
        return "AccountPool{" +
                "id=" + id +
                ", branchCode='" + branchCode + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", mdmCode='" + mdmCode + '\'' +
                ", priorityCode='" + priorityCode + '\'' +
                ", registryTypeCode='" + registryTypeCode + '\'' +
                ", loginAccounts=" + accounts +
                '}';
    }
*/
}
