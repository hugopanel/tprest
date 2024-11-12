package com.example.tprest.web;

import com.example.tprest.data.Car;
import com.example.tprest.data.Dates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {
    private List<Car> carsList = new ArrayList<>();

    Logger logger = LoggerFactory.getLogger(CarController.class);

    public CarController() {
        carsList.add(
                new Car("11AA22", "Porsche", 1000)
        );
        carsList.add(
                new Car("33BB44", "Alpine", 500)
        );
        carsList.add(new Car("55CC66", "Volvo", 300));
        carsList.add(new Car("77DD88", "Lada", 2));
    }

    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars() {
        return carsList;
    }

    @GetMapping("/cars/{plaque}")
    @ResponseStatus
    @ResponseBody
    public Car getCar(@PathVariable("plaque") String plateNumber) {
        return carsList.stream().filter(car -> car.getPlateNumber().equals(plateNumber)).findFirst().orElse(null);
    }

    @PutMapping(value="/cars/{plaque}")
    public Car rent(
            @PathVariable("plaque") String plateNumber,
            @RequestParam(value="rent", required = true) boolean rent,
            @RequestBody(required = false) Dates dates
    )
    {
        if (rent) {
            logger.info("Plate number: " + plateNumber);
            logger.info("Rent: " + rent);
            logger.info("Dates: " + dates);
            return null;
        } else {
            return carsList.stream().filter(car -> car.getPlateNumber().equals(plateNumber)).findFirst().orElse(null);
        }
    }
}
