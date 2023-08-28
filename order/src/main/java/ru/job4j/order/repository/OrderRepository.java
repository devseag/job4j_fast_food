package ru.job4j.order.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.order.model.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    @Override
    List<Order> findAll();
}