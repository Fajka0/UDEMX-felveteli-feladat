package com.example.AutoKolcsonzo.Rent.service;

import com.example.AutoKolcsonzo.Rent.Rent;
import com.example.AutoKolcsonzo.Rent.RentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class RentServiceImpl implements RentService {

    private final RentRepository rentRepository;

    public Set<Long> rentsInInterval(final Date startDate, final Date endDate) {
        return rentRepository.getRentsByInterval(startDate, endDate);
    }

    @Override
    public Rent saveRent(final Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

}
