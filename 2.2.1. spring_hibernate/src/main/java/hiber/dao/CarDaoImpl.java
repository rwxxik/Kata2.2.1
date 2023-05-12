package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class CarDaoImpl implements CarDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserByCar(int series, String model) {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery(
                "from Car where series = :series and model = :model");
        query.setParameter("series", series);
        query.setParameter("model", model);
        return query.getSingleResult().getUser();
    }
}
