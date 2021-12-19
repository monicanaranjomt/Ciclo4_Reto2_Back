
package com.usa.Reto5.Interface;

import org.springframework.data.mongodb.repository.Query;
import java.util.List;
import com.usa.Reto5.Modelo.Vegetarian;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Viviana Naranjo
 */
public interface InterfaceVegetarian extends MongoRepository<Vegetarian, String>{
    
        //Reto 5
    public List<Vegetarian> findByPriceLessThanEqual(double precio);

    //Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Vegetarian> findByDescriptionLike(String description);
}
