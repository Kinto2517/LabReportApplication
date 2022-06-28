package com.example.labreport.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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


    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String surname;

    @OneToMany(mappedBy = "user")
    private List<Report> reports;


    public User() {
    }

    public User(String username, String password, String role, String name, String surname) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.reports = reports;
    }




}
