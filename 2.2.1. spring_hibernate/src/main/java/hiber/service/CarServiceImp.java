package hiber.service;


import hiber.dao.CarDao;
import hiber.dao.CarDaoImp;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class CarServiceImp  implements CarService {
    private CarDao carDao;

    @Autowired
    public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public User getUserByCar(String model, int series) {
        return carDao.getUserByCar(model,series);
    }
}
