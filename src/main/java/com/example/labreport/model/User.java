package com.example.labreport.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String surname;

    @Column(name = "hospital_no")
    private String hospitalNo;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;




    @OneToMany(mappedBy = "user")
    private List<Report> reports;


    public User() {
    }

    public User(String username, String password, String role, String name, String surname, String hospitalNo) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.hospitalNo = hospitalNo;
    }
    public User(String username, String password, String role, String name, String surname, String hospitalNo, List<Report> reports) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.hospitalNo = hospitalNo;
        this.reports = reports;
    }




}
