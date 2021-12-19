
package com.usa.Reto5.Interface;

import com.usa.Reto5.Modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Viviana Naranjo
 */
public interface InterfaceUser extends MongoRepository<User, Integer> {
     Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    
     //Para seleccionar el usuario con el id maximo
    Optional<User> findTopByOrderByIdDesc();
    
    //Reto 5
    List<User> findByMonthBirthtDay(String monthBirthtDay);
}