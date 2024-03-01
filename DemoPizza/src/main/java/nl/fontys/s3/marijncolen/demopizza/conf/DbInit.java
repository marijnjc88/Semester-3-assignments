package nl.fontys.s3.marijncolen.demopizza.conf;

import nl.fontys.s3.marijncolen.demopizza.domain.Pizza;
import nl.fontys.s3.marijncolen.demopizza.persistence.impl.PizzaRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DbInit {
    @Qualifier("mockPizza")
    private PizzaRepo pizzaRepo;

    public DbInit(PizzaRepo pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void FillDb() {
        pizzaRepo.save(Pizza.builder().name("Pizza1").price(10.0).build());
        pizzaRepo.save(Pizza.builder().name("Pizza2").price(15.0).build());
        pizzaRepo.save(new Pizza("Pizza3", 20.0));
    }
}
