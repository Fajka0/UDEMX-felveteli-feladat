package com.example.AutoKolcsonzo.Rent.facade;

import com.example.AutoKolcsonzo.Rent.Rent;

import java.util.List;

public interface RentFacade {
    Rent saveRent(Rent rent);

    List<Rent> findAll();
}
