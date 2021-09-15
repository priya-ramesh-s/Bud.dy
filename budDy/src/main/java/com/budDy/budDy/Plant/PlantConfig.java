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
                    "Indoor",
                    "Light watering",
                    "Bright light",
                    "Beginner",
                    5
            );
            Plant anthurium = new Plant(
                    "Anthurium",
                    "Anthurium andraeanum",
                    "Indoor",
                    "Light watering",
                    "Medium light",
                    "Beginner",
                    5
            );
            Plant kentia = new Plant(
                    "Kentia Palm",
                    "Howea forsteriana",
                    "Indoor",
                    "Light watering",
                    "Medium light",
                    "Intermediate",
                    5
            );
            Plant cacti = new Plant(
                    "Cactus",
                    "Cactus",
                    "Indoor",
                    "Light watering",
                    "Bright light",
                    "Beginner",
                    5
            );
            Plant mahogany = new Plant(
                    "Mahogany Fern",
                    "Dryopteris erythrosora",
                    "Outdoor",
                    "Frequent watering",
                    "Shady spot",
                    "Intermediate",
                    5
            );
            Plant paradise = new Plant(
                    "Bird of Paradise",
                    "Strelitzia reginae",
                    "Indoor",
                    "Light watering",
                    "Bright Light",
                    "Intermediate",
                    5
            );
            Plant lemon = new Plant(
                    "Lemon Tree",
                    "Citrus limon",
                    "Outdoor",
                    "Regular Watering",
                    "Bright light",
                    "Intermediate",
                    5
            );
            Plant snake = new Plant(
                    "Snake Plant",
                    "Sansevieria trifasciata",
                    "Indoor",
                    "Light watering",
                    "Bright light",
                    "Beginner",
                    5
            );
            Plant palm = new Plant(
                    "Meditteranean fan palm",
                    "Chamaerops humils",
                    "Outdoor",
                    "Light watering",
                    "Medium light",
                    "Intermediate",
                    5
            );
            Plant bay = new Plant(
                    "Bay tree",
                    "Laurus nobilis",
                    "Outdoor",
                    "Light watering",
                    "Direct sunlight",
                    "Beginner",
                    5
            );
            Plant common_box = new Plant(
                    "Common Box",
                    "Buxus sempervirens",
                    "Outdoor",
                    "Regular watering",
                    "Shady spot",
                    "Intermediate",
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
