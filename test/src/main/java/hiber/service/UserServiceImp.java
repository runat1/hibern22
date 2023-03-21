package hiber.service;

import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hiber.dao.UserDao;
import hiber.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }
   public void add(Car car) {
      userDao.add(car);
   }
   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }
   @Transactional(readOnly = true)
   @Override
   public List<Car> listUsersCar(Car car){
      return userDao.listUsersCar(car);
   }
   @Transactional(readOnly = true)
   @Override
   public List<Car> listUsersCarModelAndSeries(String model, int series){
      return userDao.listUsersCarModelAndSeries(model,series);
   }
   public Car getOneUserByModelAndSeries(String model, int series){
      return userDao.getOneUserByModelAndSeries(model,series);
   }
   public Car getOneUserByCar(Car car){
      return userDao.getOneUserByCar(car);
   }


}
