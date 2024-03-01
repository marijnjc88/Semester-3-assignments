package nl.fontys.s3.marijncolen.demopizza.controller;

import lombok.AllArgsConstructor;
import nl.fontys.s3.marijncolen.demopizza.domain.Pizza;
import nl.fontys.s3.marijncolen.demopizza.persistence.impl.PizzaRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("pizzas")
public class PizzaController {
    private final PizzaRepo repo;

    @GetMapping
    public List<Pizza> getAllPizzas() {
        return repo.getAll();
    }
}
