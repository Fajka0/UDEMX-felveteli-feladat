package com.example.AutoKolcsonzo.Car;

import com.example.AutoKolcsonzo.Car.facade.CarFacade;
import com.example.AutoKolcsonzo.Car.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class CarController {

    private final CarFacade carFacade;

    @GetMapping("/home_page")
    public String showCareers(Model model, @RequestParam(required = false, name = "startDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd") final Date startDate,
                              @RequestParam(required = false, name = "endDate")
                               @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<Car> cars = carFacade.getFreeCars(startDate, endDate);
        model.addAttribute("cars", cars);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("startDate", formatter.format(startDate));
        model.addAttribute("endDate", formatter.format(endDate));
        return "home_page";
    }

}
