package ru.inno.task5se.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = "value")
@Entity
@Table(name = "tpp_ref_account_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TppRefAccountType {
    @Id
    @Column(name = "internal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer internalId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountType")
    private List<TppRefProductRegisterType> value;
}