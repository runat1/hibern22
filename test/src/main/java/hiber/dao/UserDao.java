package hiber.dao;



import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   void add(Car Car);
   List<User> listUsers();
   List<Car> listUsersCar(Car car);
   List<Car> listUsersCarModelAndSeries(String model, int series);
   Car getOneUserByModelAndSeries(String model, int series);
   Car getOneUserByCar(Car car);


}
