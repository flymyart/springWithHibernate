package hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    @Column(name = "series")
    private int series;

    @Column(name = "model")
    private String model;

    @OneToOne(optional = false, mappedBy = "car")
    private User user;

    public Car() {}

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public int getId() {
        return carId;
    }

    public void setId(int id) {
        this.carId = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getSeries() {
        return series;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUsers() {
        return user;
    }
}
