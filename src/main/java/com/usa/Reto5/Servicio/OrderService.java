package com.usa.Reto5.Servicio;

import com.usa.Reto5.Modelo.Order;
import com.usa.Reto5.Repositorio.OrderRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Viviana Naranjo
 */
@Service
public class OrderService {
    
     @Autowired
    private OrderRepositorio orderRepositorio;

    public List<Order> getAll() {
        return orderRepositorio.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepositorio.getOrder(id);
    }

    public Order create(Order order) {
        
        //obtiene el maximo id existente en la coleccion
        Optional<Order> orderIdMaxima = orderRepositorio.lastUserId();
        
        //si el id de la orden que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (order.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (orderIdMaxima.isEmpty())
                order.setId(1);
            //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo de la orden
            else
                order.setId(orderIdMaxima.get().getId() + 1);
        }
        
        Optional<Order> e = orderRepositorio.getOrder(order.getId());
        if (e.isEmpty()) {
            return orderRepositorio.create(order);            
        }else{
            return order;
        }        
    }

    public Order update(Order order) {

        if (order.getId() != null) {
            Optional<Order> orderDb = orderRepositorio.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepositorio.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepositorio.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    //Ordenes de pedido asociadas a los asesores de una zona
    public List<Order> findByZone(String zona) {
        return orderRepositorio.findByZone(zona);
    }
    //Reto 4--
    
    // Ordenes de un asesor
    public List<Order> ordersSalesManByID(Integer id){
        return orderRepositorio.ordersSalesManByID(id);
    }
    // Ordenes de un asesor x Estado
    public List<Order> ordersSalesManByState(String state, Integer id){
        return orderRepositorio.ordersSalesManByState(state, id);
    }
    //Reto 4: Ordenes de un asesor x fecha
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        return orderRepositorio.ordersSalesManByDate(dateStr,id);
    }
}


