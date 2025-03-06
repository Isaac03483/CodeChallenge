package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "driver")
public record Driver(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id,@Column(unique = true) String name, Integer age) {
}
