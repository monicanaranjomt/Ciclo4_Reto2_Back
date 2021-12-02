/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usa.Reto2.Interface;

import com.usa.Reto2.Modelo.Vegetarian;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Viviana Naranjo
 */
public interface InterfaceVegetarian extends MongoRepository<Vegetarian, String>{
    
}
