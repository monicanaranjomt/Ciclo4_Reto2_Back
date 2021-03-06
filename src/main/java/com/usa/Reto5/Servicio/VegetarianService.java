package com.usa.Reto5.Servicio;

import com.usa.Reto5.Modelo.Vegetarian;
import com.usa.Reto5.Repositorio.VegetarianRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Viviana Naranjo
 */
@Service
public class VegetarianService {
   @Autowired
    private VegetarianRepositorio clotheRepository;
   
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Vegetarian> getAll() {
        return clotheRepository.getAll();
    }

   public Optional<Vegetarian> getClothe(String reference) {
        return clotheRepository.getClothe(reference);
    }

    public Vegetarian create(Vegetarian accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return clotheRepository.create(accesory);
        }
    }

    public Vegetarian update(Vegetarian accesory) {

        if (accesory.getReference() != null) {
            Optional<Vegetarian> accesoryDb = clotheRepository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                clotheRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    //Reto 5
    public List<Vegetarian> productByPrice(double precio) {
        return clotheRepository.productByPrice(precio);
    }

    //Reto 5
    public List<Vegetarian> findByDescriptionLike(String description) {
        return clotheRepository.findByDescriptionLike(description);
    }
    
}

