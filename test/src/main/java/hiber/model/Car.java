package hiber.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idCar;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;
    @OneToOne(mappedBy = "car",cascade = CascadeType.ALL)
    private User user;


    public Car(String model, int series){
        this.model=model;
        this.series=series;
    }

    public Car() {

    }

    public void setModel(String model){
        this.model=model;
    }
    public void setSeries(int series){
        this.series=series;
    }
    public String getModel(){
        return model;
    }
    public int getSeries(){
        return series;
    }
    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long id) {
        this.idCar = id;
    }
    public void setUser(User user){
        this.user=user;
    }
    public User getUser(){
        return user;
    }
    public Long getId() {
        return user.getId();
    }

    public void setId(Long id) {
        user.setId(id);
    }

    public String getFirstName() {
        return user.getFirstName();
    }

    public void setFirstName(String firstName) {
        user.setFirstName(firstName);
    }

    public String getLastName() {
        return user.getLastName();
    }

    public void setLastName(String lastName) {
        user.setLastName(lastName);
    }

    public String getEmail() {
        return user.getEmail();
    }

    public void setEmail(String email) {
        user.setEmail(email);
    }

}
