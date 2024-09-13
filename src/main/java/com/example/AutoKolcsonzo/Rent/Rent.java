package com.example.AutoKolcsonzo.Rent;

import com.example.AutoKolcsonzo.Car.Car;
import com.example.AutoKolcsonzo.Client.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "rents")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Rent(final Date startDate, final Date endDate, final Car car, final Client client) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.car = car;
        this.client = client;
    }
}