package iuh.fit.se;

import iuh.fit.se.daos.EmployeeDao;
import iuh.fit.se.enties.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"iuh.fit.se.daos","iuh.fit.se.daos.impl"})
public class BaiTap01Application {
    public static void main(String[] args) {
        SpringApplication.run(BaiTap01Application.class, args);
    }
    @Bean
    CommandLineRunner runner (EmployeeDao employeeDao){
        return args -> {
            Employee employee = new Employee("Cao van Bao","21000425");
            employeeDao.save(employee);
            List<Employee> employees = employeeDao.getAll();
            employees.forEach(System.out::println);
            Employee employee2 = employeeDao.getByUserName("Cao Van Bao");
            System.out.println(employee2);
            Employee employeeDirec = employeeDao.getByUserNameDirectMapper("Cao Van Bao");
            System.out.println(employeeDirec);
        };
    }
}
