package com.usa.Reto5.Repositorio;

import com.usa.Reto5.Modelo.Vegetarian;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.Reto5.Interface.InterfaceVegetarian;

/**
 *
 * @author Viviana Naranjo
 */
@Repository
public class VegetarianRepositorio {
@Autowired
    private InterfaceVegetarian repository;

    public List<Vegetarian> getAll() {
        return repository.findAll();
    }

    public Optional<Vegetarian> getClothe(String reference) {
        return repository.findById(reference);
    }
    public Vegetarian create(Vegetarian clothe) {
        return repository.save(clothe);
    }

    public void update(Vegetarian clothe) {
        repository.save(clothe);
    }
    
    public void delete(Vegetarian clothe) {
        repository.delete(clothe);
    }
    
    
    //Reto 5
    public List<Vegetarian> productByPrice(double precio) {
        return repository.findByPriceLessThanEqual(precio);
    }

    //Reto 5
    public List<Vegetarian> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
}
