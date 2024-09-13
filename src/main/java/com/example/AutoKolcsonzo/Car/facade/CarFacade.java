package com.example.AutoKolcsonzo.Car.facade;

import com.example.AutoKolcsonzo.Car.Car;

import java.util.Date;
import java.util.List;

public interface CarFacade {

    List<Car> getFreeCars(Date startDate, Date endDate);

    List<Car> findAll();

    Car getCarById(Long id);

    void saveCar(Car c);

}
