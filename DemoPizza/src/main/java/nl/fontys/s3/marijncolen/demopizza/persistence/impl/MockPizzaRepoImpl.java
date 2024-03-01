package nl.fontys.s3.marijncolen.demopizza.persistence.impl;

import nl.fontys.s3.marijncolen.demopizza.domain.Pizza;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
@Qualifier("mockRepo")
public class MockPizzaRepoImpl implements PizzaRepo {
    private final List<Pizza> pizzas;

    public MockPizzaRepoImpl(List<Pizza> pizzas) {
        this.pizzas = new ArrayList<>();
        System.out.println("MOCK!!!!!!!!!!");
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
