package com.hizik;

import com.hizik.service.LibDemoService;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
//        context.getBean(LibDemoService.class).usersDemo();
//        context.getBean(LibDemoService.class).motosDemo();
//        context.getBean(LibDemoService.class).insertMotosByUsersStatus();
//        context.close();

//        try {
//            Console.main(args);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
