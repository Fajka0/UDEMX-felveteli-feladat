package com.example.AutoKolcsonzo.Admin;


import com.example.AutoKolcsonzo.Car.Car;
import com.example.AutoKolcsonzo.Car.facade.CarFacade;
import com.example.AutoKolcsonzo.Rent.facade.RentFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class AdminControler {

    private final CarFacade carFacade;
    private final RentFacade rentFacade;

    @GetMapping("/admin")
    public String fillPage(Model model) {
        model.addAttribute("cars", carFacade.findAll());
        model.addAttribute("rents", rentFacade.findAll());
        return "admin";
    }

    @GetMapping("/admin/newcar")
    public String saveNewCar(Model model,
                             @RequestParam(required = false, name = "price") final int price,
                             @RequestParam(required = false, name = "type") final String type) {
        carFacade.saveCar(new Car(null, type, price, true));
        model.addAttribute("cars", carFacade.findAll());
        model.addAttribute("rents", rentFacade.findAll());
        return "admin";
    }

    @GetMapping("/editCar")
    public String editCar(Model model,
                          @RequestParam(required = false, name = "id") final Long id) {
        model.addAttribute("car", carFacade.getCarById(id));
        model.addAttribute("rents", rentFacade.findAll());
        return "editCar";
    }

    @GetMapping("/admin/save")
    public String backToAdmin(Model model,
                              @RequestParam(required = false, name = "carId") final Long id,
                              @RequestParam(required = false, name = "price") final int price,
                              @RequestParam(required = false, name = "type") final String type,
                              @RequestParam(required = false, name = "available") final Boolean available) {
        final boolean isAvailable = (available != null) ? available : false;
        carFacade.saveCar(new Car(id, type, price, isAvailable));
        model.addAttribute("cars", carFacade.findAll());
        model.addAttribute("rents", rentFacade.findAll());
        return "admin";
    }
}
