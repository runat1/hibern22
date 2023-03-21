package hiber.dao;


import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import hiber.model.User;

import java.util.List;
import java.util.Queue;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
      sessionFactory.getCurrentSession().save(user.getCar());
   }

   @Override
   public void add(Car Car) {
      sessionFactory.getCurrentSession().save(Car);
   }
   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @Override
   @SuppressWarnings("unchecked")
   public List<Car> listUsersCar(Car car) {
      TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car where series ="+car.getSeries()+" and model = '"+car.getModel()+"'");
      return query.getResultList();
   }
   @Override
   @SuppressWarnings("unchecked")
   public List<Car> listUsersCarModelAndSeries(String model, int series) {
      TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car where series ="+series+" and model = '"+model+"'");
      return query.getResultList();
   }
   @Override
   @SuppressWarnings("unchecked")
   public Car getOneUserByModelAndSeries(String model, int series) {
      sessionFactory.openSession();

      TypedQuery<Car> query=sessionFactory.openSession().createQuery("from Car where series ="+series+" and model = '"+model+"'");

      return query.getSingleResult();
   }
   public Car getOneUserByCar(Car car) {
      TypedQuery<Car> query=sessionFactory.openSession().createQuery("from Car where series ="+car.getSeries()+" and model = '"+car.getModel()+"'");
      return query.getSingleResult();
   }
}
