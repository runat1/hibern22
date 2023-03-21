package hiber.service;


import hiber.model.Car;
import org.springframework.transaction.annotation.Transactional;

import hiber.model.User;
import java.util.List;

public interface UserService {
    @Transactional
    void add(User user);
    void add(Car car);
    List<User> listUsers();
    @Transactional
    List<Car> listUsersCar(Car car);
    @Transactional
    List<Car> listUsersCarModelAndSeries(String model, int series);
    Car getOneUserByModelAndSeries(String model, int series);
    Car getOneUserByCar(Car car);


}
