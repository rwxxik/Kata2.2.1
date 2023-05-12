package hiber.service;

import hiber.model.User;

public interface CarService {
    User getUserByCar(int series, String model);
}
