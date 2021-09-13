package com.budDy.budDy.Plant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlantConfig {

    @Bean //bean annotations make the method below run
    CommandLineRunner commandLineRunner(PlantRepository repository){
        return args -> {
            Plant fiddle_leaf_fig = new Plant(
                    "Fiddle Leaf Fig",
                    "Ficus lyrata",
                    PlantType.INDOOR,
                    "Light watering",
                    "Medium light",
                    PlantExperience.BEGINNER,
                    5
            );
            Plant anthurium = new Plant(
                    "Anthurium",
                    "Anthurium andraeanum",
                    PlantType.INDOOR,
                    "Light watering",
                    "Medium light",
                    PlantExperience.BEGINNER,
                    5
            );

            //to add to database (invoke the repository and .saveAll method passing through
            //plants you want to add to database) you can see the sql Hibernate is running
            repository.saveAll(
                    List.of(fiddle_leaf_fig, anthurium)
            );
        };
    }
}
