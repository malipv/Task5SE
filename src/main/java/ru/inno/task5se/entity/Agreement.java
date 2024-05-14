package ru.inno.task5se.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "agreement")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id", unique = true, nullable = false)
    private TppProduct tppProduct;

    @Column(name = "general_agreement_id")
    private String generalAgreementId;

    @Column(name = "number")
    private String number;

// убрал поля не влияющие на результат
/*
    @Column(name = "supplementary_agreement_id", length = 50)
    private String supplementaryAgreementId;

    @Column(name = "arrangement_type", length = 50)
    private String arrangementType;

    @Column(name = "sheduler_job_id")
    private Long shedulerJobId;

    @Column(name = "opening_date")
    private Timestamp openingDate;

    @Column(name = "closing_date")
    private Timestamp closingDate;

    @Column(name = "cancel_date")
    private Timestamp cancelDate;

    @Column(name = "validity_duration")
    private Long validityDuration;

    @Column(name = "cancellation_reason", length = 100)
    private String cancellationReason;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "interest_calculation_date")
    private Timestamp interestCalculationDate;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "coefficient")
    private BigDecimal coefficient;

    @Column(name = "coefficient_action", length = 50)
    private String coefficientAction;

    @Column(name = "minimum_interest_rate")
    private BigDecimal minimumInterestRate;

    @Column(name = "minimum_interest_rate_coefficient")
    private BigDecimal minimumInterestRateCoefficient;

    @Column(name = "minimum_interest_rate_coefficient_action", length = 50)
    private String minimumInterestRateCoefficientAction;

    @Column(name = "maximal_interest_rate")
    private BigDecimal maximalInterestRate;

    @Column(name = "maximal_interest_rate_coefficient")
    private BigDecimal maximalInterestRateCoefficient;

    @Column(name = "maximal_interest_rate_coefficient_action", length = 50)
    private String maximalInterestRateCoefficientAction;
*/
}