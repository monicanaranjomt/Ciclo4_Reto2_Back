package com.usa.Reto4.Repositorio;

import com.usa.Reto4.Modelo.Vegetarian;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.Reto4.Interface.InterfaceVegetarian;

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
}
