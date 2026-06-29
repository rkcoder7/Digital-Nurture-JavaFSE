package com.cognizant.orm_learn.model;

import java.math.BigDecimal; // 1. You MUST import this!
import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor; // 2. Add this for Hibernate

@Entity
@Table(name="stock")
@Data
@NoArgsConstructor 
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="st_id")
    private Integer id;

    @Column(name="st_code")
    private String code;

 
    @Temporal(TemporalType.DATE)
    @Column(name="st_date")
    private Date date;

    // 3. Change double to BigDecimal
    @Column(name="st_open")
    private BigDecimal open; 

    // 4. Change double to BigDecimal
    @Column(name="st_close")
    private BigDecimal close; 

    // 5. Change long to BigDecimal
    @Column(name="st_volume")
    private BigDecimal volume; 

}