package com.example.AutoKolcsonzo.Rent.service;

import com.example.AutoKolcsonzo.Rent.Rent;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface RentService {

    Set<Long> rentsInInterval(Date startDate, Date endDate);

    Rent saveRent(Rent rent);

    List<Rent> findAll();
}
