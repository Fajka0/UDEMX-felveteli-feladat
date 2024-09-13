package com.example.AutoKolcsonzo.Car.facade;

import com.example.AutoKolcsonzo.Car.Car;
import com.example.AutoKolcsonzo.Car.CarRepository;
import com.example.AutoKolcsonzo.Rent.service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarFacadeImpl implements CarFacade {
    private final CarRepository carRepository;
    private RentService rentService;

    @Override
    public List<Car> getFreeCars(final Date startDate, final Date endDate) {
        final List<Car> allCar = carRepository.findAll();
        final Set<Long> allRentInIntervall = rentService.rentsInInterval(startDate, endDate);

        return allCar.stream()
                .filter(car -> !allRentInIntervall.contains(car.getId()) && car.isAvailable())
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(final Long id) {
        return carRepository.findById(id).orElseThrow();
    }

    @Override
    public void saveCar(final Car c) {
        carRepository.save(c);
    }
}
