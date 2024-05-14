package ru.inno.task5se.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude = "agreements")
@Entity
@Table(name = "tpp_product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TppProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_code_id")
    private Integer productCodeId;

    @Column(name = "client_id")
    private Integer client_id;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "number", length = 50)
    private String number;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private List<Agreement> agreements = new ArrayList<>();


//лишние поля

/*
    @Column(name = "priority")
    private Long priority;

    @Column(name = "date_of_conclusion")
    private Timestamp dateOfConclusion;

    @Column(name = "start_date_time")
    private Timestamp startDateTime;

    @Column(name = "end_date_time")
    private Timestamp endDateTime;

    @Column(name = "days")
    private Long days;

    @Column(name = "penalty_rate")
    private BigDecimal penaltyRate;

    @Column(name = "nso")
    private BigDecimal nso;

    @Column(name = "threshold_amount")
    private BigDecimal thresholdAmount;

    @Column(name = "requisite_type", length = 50)
    private String requisiteType;

    @Column(name = "interest_rate_type", length = 50)
    private String interestRateType;

    @Column(name = "tax_rate")
    private BigDecimal taxRate;

    @Column(name = "reasone_close", length = 100)
    private String reasoneClose;

    @Column(name = "state", length = 50)
    private String state;
*/


}