package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Вася", "Петров", "user1@mail.ru");
      Car car1 = new Car("Toyota", 3210);
      user1.setEmpCar(car1);
      User user2 = new User("Иван", "Иванов", "user2@mail.ru");
      Car car2 = new Car("Lexus", 5436);
      user2.setEmpCar(car2);
      User user3 = new User("Мария", "Сидорова", "user3@mail.ru");
      Car car3 = new Car("Mazda", 7846);
      user3.setEmpCar(car3);
      User user4 = new User("Ирина", "Козлова", "user4@mail.ru");
      Car car4 = new Car("Audi", 6484);
      user4.setEmpCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      userService.listUsers();

      userService.getUserByCar("Audi", 6484);

      context.close();
   }
}
