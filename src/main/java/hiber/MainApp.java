package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      Car car1 = new Car(123, "VW Zuk");
      car1.setUser(user1);
      carService.add(car1);

      user1.setCar(car1);
      userService.add(user1);

      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      Car car2 = new Car(321, "Audi TT");
      car2.setUser(user2);
      carService.add(car2);

      user2.setCar(car2);
      userService.add(user2);

      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      Car car3 = new Car(568, "Honda CR-V");
      car3.setUser(user3);
      carService.add(car3);

      user3.setCar(car3);
      userService.add(user3);

      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      Car car4 = new Car(888, "Lexus");
      car4.setUser(user4);
      carService.add(car4);

      user4.setCar(car4);
      userService.add(user4);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar().getModel());
         System.out.println();
      }

      String model = "Audi TT";
      int series = 321;
      Car setCar = new Car();
      setCar.setModel(model);
      setCar.setSeries(series);
      User getUser = carService.getUserOnModelAndSeries(setCar);
      System.out.println("User = " + getUser.getLastName() + " " + getUser.getFirstName());


      context.close();
   }
}
