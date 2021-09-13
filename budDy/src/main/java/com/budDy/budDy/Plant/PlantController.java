package com.budDy.budDy.Plant;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "bud-dy/plants")
public class PlantController {

    private PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public List<Plant> listPlants() {
        return plantService.getPlants();
    }

    @PostMapping
    public void addPlant(@RequestBody Plant plant) {
        System.out.println(plant);
        plantService.addNewPlant(plant);
    }

    // localhost:8080/bud-dy/plants/Spearmint
    @DeleteMapping("{plantName}")
    public void deletePlant(@PathVariable("plantName") String plantName) {
        plantService.deletePlant(plantName);
    }

    @PutMapping
    public void updatePlant(@PathVariable("plantName") String plantName, @RequestBody Plant plant) {
        plantService.updatePlant(plantName, plant);
    }
}
