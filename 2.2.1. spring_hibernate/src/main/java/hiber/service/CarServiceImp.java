package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

   @Autowired
   private CarDao carDao;

   @Transactional(readOnly = true)
   @Override
   public User getUserByCar(int series, String model) {
      return carDao.getUserByCar(series, model);
   }
}
