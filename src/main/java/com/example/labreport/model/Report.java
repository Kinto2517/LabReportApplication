package com.example.labreport.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reports")
@Getter
@Setter
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;

    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "report_img", columnDefinition = "BLOB")
    private byte[] report_img;


    //Patient - Report

    @Column(name = "patient_name")
    private String patient_name;

    @Column(name = "patient_surname")
    private String patient_surname;

    @Column(name = "patient_tc")
    private Long patient_tc;


    //User - Report
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "Choose user for report")
    private User user;



    public Report() {
    }

    public Report(String title, LocalDateTime date, String description, byte[] report_img, String patient_name, String patient_surname, Long patient_tc, User user) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.report_img = report_img;
        this.patient_name = patient_name;
        this.patient_surname = patient_surname;
        this.patient_tc = patient_tc;
        this.user = user;
    }






}
