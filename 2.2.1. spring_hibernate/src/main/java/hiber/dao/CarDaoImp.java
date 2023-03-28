package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.TypedQuery;
@Repository
public class CarDaoImp implements CarDao {
    private SessionFactory sessionFactory;

    @Autowired
    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserByCar(String model, int series) {
        String hql ="FROM User u WHERE u.car.model = :model AND u.car.series = :series";

        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("model",model);
        query.setParameter("series",series);
        User user = query.getSingleResult();

        return user;
    }

}
