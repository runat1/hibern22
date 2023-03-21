package hiber;


import hiber.model.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;

import javax.persistence.NonUniqueResultException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.*;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        Car car = new Car("pfdfd", 22);
        Car car1 = new Car("pfdfd", 25);
        User user = new User("User3", "Lastname2", "user2@mail.ru", "daoi", 12);
        userService.add(user);
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", "pielot", 45));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", car));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", car1));
        System.out.println("мы считаем, что series уникальная, а try на тот случай если все будет не так радужно)");
        try {
            Car carChek= userService.getOneUserByModelAndSeries("pielot", 45);
            Car carChek2=userService.getOneUserByCar(car);
            outOne(carChek2);
            outOne(carChek);
        } catch (NonUniqueResultException e) {
            List<Car> users4 = userService.listUsersCar(car);
            List<Car> users2 = userService.listUsersCarModelAndSeries("pfdfd", 22);
            out(users2);
            out(users4);
        }
        context.close();
    }
   public static void out(List<Car>list){
       for (Car check2 : list) {
           System.out.println("Id = " + check2.getId());
           System.out.println("First Name = " + check2.getFirstName());
           System.out.println("Last Name = " + check2.getLastName());
           System.out.println("Email = " + check2.getEmail());
           System.out.println("Model Car = "+check2.getModel());
           System.out.println("Series Car =  " + check2.getSeries());
           System.out.println();
       }
   }
    public static void outOne(Car check2){
            System.out.println("Id = " + check2.getId());
            System.out.println("First Name = " + check2.getFirstName());
            System.out.println("Last Name = " + check2.getLastName());
            System.out.println("Email = " + check2.getEmail());
            System.out.println("Model Car = "+check2.getModel());
            System.out.println("Series Car =  " + check2.getSeries());
            System.out.println();

    }
}
