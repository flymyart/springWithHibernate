package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarService {
    User add(Car car);
    List<Car> listCars();
    User getUserOnModelAndSeries(Car car);
}
