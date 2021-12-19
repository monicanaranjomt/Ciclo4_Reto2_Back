package com.usa.Reto5;

import com.usa.Reto5.Modelo.Vegetarian;
import com.usa.Reto5.Modelo.User;
import com.usa.Reto5.Modelo.Order;
import com.usa.Reto5.Repositorio.OrderRepositorio;
import com.usa.Reto5.Repositorio.UserRepositorio;
import com.usa.Reto5.Repositorio.VegetarianRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import com.usa.Reto5.Interface.InterfaceOrder;
import com.usa.Reto5.Interface.InterfaceUser;
import com.usa.Reto5.Interface.InterfaceVegetarian;

@SpringBootApplication
public class Reto5Application implements CommandLineRunner{

        

    @Autowired
    private InterfaceVegetarian repository;
    @Autowired
    private InterfaceUser userCrudRepository;
    @Autowired
    private InterfaceOrder interfaceOrder;

    @Autowired
    private UserRepositorio userRepositorio;

    @Autowired
    private OrderRepositorio orderRepositorio;

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
		SpringApplication.run(Reto5Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        repository.deleteAll();
        userCrudRepository.deleteAll();
        interfaceOrder.deleteAll();
}
}