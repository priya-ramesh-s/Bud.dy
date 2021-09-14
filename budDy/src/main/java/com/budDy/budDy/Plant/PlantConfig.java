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
                    "Bright light",
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
            Plant kentia = new Plant(
                    "Kentia Palm",
                    "Howea forsteriana",
                    PlantType.INDOOR,
                    "Light watering",
                    "Medium light",
                    PlantExperience.INTERMEDIATE,
                    5
            );
            Plant cacti = new Plant(
                    "Cactus",
                    "Cactus",
                    PlantType.INDOOR,
                    "Light watering",
                    "Bright light",
                    PlantExperience.BEGINNER,
                    5
            );
            Plant mahogany = new Plant(
                    "Mahogany Fern",
                    "Dryopteris erythrosora",
                    PlantType.OUTDOOR,
                    "Frequent watering",
                    "Shady spot",
                    PlantExperience.INTERMEDIATE,
                    5
            );
            Plant paradise = new Plant(
                    "Bird of Paradise",
                    "Strelitzia reginae",
                    PlantType.INDOOR,
                    "Light watering",
                    "Bright Light",
                    PlantExperience.INTERMEDIATE,
                    5
            );
            Plant lemon = new Plant(
                    "Lemon Tree",
                    "Citrus limon",
                    PlantType.OUTDOOR,
                    "Regular Watering",
                    "Bright light",
                    PlantExperience.INTERMEDIATE,
                    5
            );
            Plant snake = new Plant(
                    "Snake Plant",
                    "Sansevieria trifasciata",
                    PlantType.INDOOR,
                    "Light watering",
                    "Bright light",
                    PlantExperience.BEGINNER,
                    5
            );
            Plant palm = new Plant(
                    "Meditteranean fan palm",
                    "Chamaerops humils",
                    PlantType.OUTDOOR,
                    "Light watering",
                    "Medium light",
                    PlantExperience.INTERMEDIATE,
                    5
            );
            Plant bay = new Plant(
                    "Bay tree",
                    "Laurus nobilis",
                    PlantType.OUTDOOR,
                    "Light watering",
                    "Direct sunlight",
                    PlantExperience.BEGINNER,
                    5
            );
            Plant common_box = new Plant(
                    "Common Box",
                    "Buxus sempervirens",
                    PlantType.OUTDOOR,
                    "Regular watering",
                    "Shady spot",
                    PlantExperience.INTERMEDIATE,
                    5
            );


            //to add to database (invoke the repository and .saveAll method passing through
            //plants you want to add to database)
            repository.saveAll(
                    List.of(fiddle_leaf_fig, anthurium, kentia, cacti, mahogany, paradise, lemon, snake, palm, bay,
                            common_box)
            );
        };
    }
}
