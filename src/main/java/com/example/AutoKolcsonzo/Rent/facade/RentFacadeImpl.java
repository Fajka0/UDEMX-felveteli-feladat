package com.example.AutoKolcsonzo.Rent.facade;

import com.example.AutoKolcsonzo.Rent.Rent;
import com.example.AutoKolcsonzo.Rent.RentRepository;
import com.example.AutoKolcsonzo.Rent.service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RentFacadeImpl implements RentFacade {
    private final RentService rentService;

    public Rent saveRent(final Rent rent) {
        return rentService.saveRent(rent);
    }

    @Override
    public List<Rent> findAll() {
        return rentService.findAll();
    }

}
