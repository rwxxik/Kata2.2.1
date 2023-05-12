package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        userService.addUser(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.addUser(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.addUser(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.addUser(new User("User4", "Lastname4", "user4@mail.ru"));

        User caruser1 = new User("UserCar", "UserCarLastName", "qqqqq@gmail.com");
        caruser1.setCar(new Car("UAZ"));

        userService.addUser(caruser1);

        List<User> users = userService.getListUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            if (user.getCar() != null) {
                System.out.println(user.getCar().getSeries());
                System.out.println(user.getCar().getModel());
            }
            System.out.println();
        }

        System.out.println("User with car (1, UAZ)");
        User user = carService.getUserByCar(1, "UAZ");
        System.out.println("Id = " + user.getId());
        System.out.println("First Name = " + user.getFirstName());
        System.out.println("Last Name = " + user.getLastName());
        System.out.println("Email = " + user.getEmail());
        System.out.println(user.getCar().getSeries());
        System.out.println(user.getCar().getModel());

        context.close();
    }
}
