package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.IdGeneratorType;

@Entity
@Table(name="requests")
@Getter
@Setter

public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="userName")
    private String userName;

    @Column(name="courseName")
    private String courseName;

    @Column(name="commentary")
    private String commentary;

    @Column(name="phone")
    private String phone;

    @Column(name="handled")
    private boolean handled;

}
