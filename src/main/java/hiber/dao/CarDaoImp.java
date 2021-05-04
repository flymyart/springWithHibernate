package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> listCars() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }


    @Override
    public User getUserOnModelAndSeries(Car car) {
        String hql = "FROM User user where user.car.model = :paramModel and user.car.series = :paramSeries ";
        Query<User> query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("paramModel", car.getModel());
        query.setParameter("paramSeries", car.getSeries());
        return query.setMaxResults(1).getSingleResult();
    }

}
