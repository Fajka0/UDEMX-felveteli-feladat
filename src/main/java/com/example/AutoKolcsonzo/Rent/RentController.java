package com.example.AutoKolcsonzo.Rent;


import com.example.AutoKolcsonzo.Car.Car;
import com.example.AutoKolcsonzo.Car.facade.CarFacade;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class RentController {

    private final CarFacade carFacade;

    @GetMapping("/home_page/{id}")
    public String getCarDetails(Model model, @PathVariable final Long id,
                                @RequestParam(required = false, name = "startDate")
                                @DateTimeFormat(pattern = "yyyy-MM-dd") final Date startDate,
                                @RequestParam(required = false, name = "endDate")
                                @DateTimeFormat(pattern = "yyyy-MM-dd") final Date endDate) {
        List<Car> cars = carFacade.getFreeCars(startDate, endDate);
        model.addAttribute("cars", cars);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("startDate", formatter.format(startDate));
        model.addAttribute("endDate", formatter.format(endDate));
        model.addAttribute("rentCar", carFacade.getCarById(id));
        return "home_page";
    }

}
