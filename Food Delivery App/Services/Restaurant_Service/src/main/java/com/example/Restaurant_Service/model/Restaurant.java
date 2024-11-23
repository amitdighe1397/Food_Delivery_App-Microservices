package com.example.Restaurant_Service.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "restaurants")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String location;
    private Double rating;
    @Column(name = "created_at")
    private Timestamp createdAt;

}

