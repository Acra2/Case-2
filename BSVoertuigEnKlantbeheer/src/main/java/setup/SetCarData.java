//package setup;
//
//import entities.Brand;
//import entities.Car;
//import entities.Customer;
//import entities.Model;
//import services.ICarService;
//import services.ICustomerService;
//
//import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
//import javax.ejb.Singleton;
//import javax.ejb.Startup;
//import javax.inject.Inject;
//import java.io.Serializable;
//
///**
// * Created by paisanrietbroek on 22/11/2016.
// */
//
//@Singleton
//@Startup
//public class SetCarData implements Serializable{
//
//    @EJB
//    private ICarService carService;
//
//    @EJB
//    private ICustomerService customerService;
//
//    @PostConstruct
//    public void setData() {
//
//        Customer customer = new Customer();
//        customer.setPhonenumber("0543658587");
//        customer.setEmail("paj.jansen@jansen.nl");
//        customer.setBtwnumber("56587987");
//        customer.setAdress("Leerpark 100 3320 AR Dordrecht");
//        customer.setName("Piet Jansen");
//
//        Car car = new Car();
//        car.setVehicleNumber("112345");
//        car.setDriverEmail("test@mail.com");
//        car.setDriverName("test name");
//        car.setDriverPhoneNumber("1234567897");
//        car.setLicensePlate("license plate");
//        car.setCustomer(customer);
//        car.setMileage(4200);
//
//        Customer customer2 = new Customer();
//        customer2.setPhonenumber("123");
//        customer2.setEmail("email@test.nl");
//        customer2.setBtwnumber("321");
//        customer2.setAdress("Ergens");
//        customer2.setName("Jan");
//
//        Car car1 = new Car();
//        car1.setVehicleNumber("22345");
//        car1.setDriverEmail("test@mail.com");
//        car1.setDriverName("test name");
//        car1.setDriverPhoneNumber("1234567897");
//        car1.setLicensePlate("license plate");
//        car1.setCustomer(customer2);
//        car1.setMileage(4200);
//
//        carService.addCar(car);
//        carService.addCar(car1);
//    }
//}
