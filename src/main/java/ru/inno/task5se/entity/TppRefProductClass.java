package ru.inno.task5se.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Data
@ToString(exclude = "value")
@Entity
@Table(name = "tpp_ref_product_class")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TppRefProductClass {
    @Id
@Column(name = "internal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer internalId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productClassCode")
    private Set<TppRefProductRegisterType> value;

    @Column(name = "gbi_code", length = 50)
    private String gbiCode;

    @Column(name = "gbi_name", length = 100)
    private String gbiName;

    @Column(name = "product_row_code", length = 50)
    private String productRowCode;

    @Column(name = "product_row_name", length = 100)
    private String productRowName;

    @Column(name = "subclass_code", length = 50)
    private String subclassCode;

    @Column(name = "subclass_name", length = 100)
    private String subclassName;
}