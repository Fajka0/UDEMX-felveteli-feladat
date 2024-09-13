package com.example.AutoKolcsonzo.Client;

import com.example.AutoKolcsonzo.Car.facade.CarFacade;
import com.example.AutoKolcsonzo.Client.service.ClientServiceImpl;
import com.example.AutoKolcsonzo.Rent.Rent;
import com.example.AutoKolcsonzo.Rent.facade.RentFacade;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ClientController {

    private final ClientServiceImpl clientServiceImpl;
    private final RentFacade rentFacade;
    private final CarFacade carFacade;

    @GetMapping("/submit_rent")
    public String saveRent(@RequestParam(required = false, name = "name") final String name,
                           @RequestParam(required = false, name = "email") final String email,
                           @RequestParam(required = false, name = "address") final String address,
                           @RequestParam(required = false, name = "phone") final String phone,
                           @RequestParam(required = false, name = "carId") final Long carId,
                           @RequestParam(required = false, name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") final Date startDate,
                           @RequestParam(required = false, name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") final Date endDate) {

        Client newClient = new Client( name, email, address, phone);

        Optional<Client> existingClient = clientServiceImpl.findAll().stream()
                .filter(c -> equalsClients(c, newClient))
                .findFirst();

        Client client = existingClient.orElseGet(() -> clientServiceImpl.saveClient(newClient));

        rentFacade.saveRent(new Rent( startDate, endDate, carFacade.getCarById(carId), client));

        return "submit_rent";
    }

    private boolean equalsClients(Client c1, Client c2) {
        return c1.getName().equals(c2.getName()) &&
                c1.getAddress().equals(c2.getAddress()) &&
                c1.getEmail().equals(c2.getEmail()) &&
                c1.getPhone().equals(c2.getPhone());
    }
}
