package com.example.demo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@javax.persistence.Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address address;





}
