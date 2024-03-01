package nl.fontys.s3.marijncolen.demopizza.persistence.impl;

import nl.fontys.s3.marijncolen.demopizza.domain.Pizza;

import java.util.List;

public interface PizzaRepo {
    public void save(Pizza pizza);
    public List<Pizza> getAll();
}
