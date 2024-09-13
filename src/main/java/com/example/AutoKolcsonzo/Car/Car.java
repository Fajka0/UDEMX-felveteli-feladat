package com.example.AutoKolcsonzo.Car;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private int price;
    private boolean available;
}
