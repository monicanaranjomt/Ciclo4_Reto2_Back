package com.usa.Reto3.Repositorio;

import com.usa.Reto3.Interface.InterfaceOrder;
import com.usa.Reto3.Modelo.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Viviana Naranjo
 */
@Repository
public class OrderRepositorio {
    @Autowired
    private InterfaceOrder interfaceOrder;

    public List<Order> getAll() {
        return (List<Order>) interfaceOrder.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return interfaceOrder.findById(id);
    }

    public Order create(Order order) {
        return interfaceOrder.save(order);
    }

    public void update(Order order) {
        interfaceOrder.save(order);
    }

    public void delete(Order order) {
        interfaceOrder.delete(order);
    }
    
    public Optional<Order> lastUserId(){
        return interfaceOrder.findTopByOrderByIdDesc();
    }
    
    public List<Order> findByZone(String zona) {
        return interfaceOrder.findByZone(zona);
    }

}
