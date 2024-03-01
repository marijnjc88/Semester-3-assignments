package nl.fontys.s3.marijncolen.demopizza.persistence.impl;

import nl.fontys.s3.marijncolen.demopizza.domain.Pizza;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

@Repository
// Make this the primary PizzaRepo implementation; docker automatically takes this one if none specified
@Primary
public class PizzaRepoImpl implements PizzaRepo {
    private final List<Pizza> pizzas;

    public PizzaRepoImpl(List<Pizza> pizzas) {
        this.pizzas = new ArrayList<>();
    }

    @Override
    public void save(Pizza pizza) {
        pizzas.add(pizza);
    }

    @Override
    public List<Pizza> getAll() {
        return Collections.unmodifiableList(pizzas);
    }
}
