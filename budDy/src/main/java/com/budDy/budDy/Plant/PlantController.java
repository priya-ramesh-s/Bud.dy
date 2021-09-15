package com.budDy.budDy.Plant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "buddy/plants")
public class PlantController {

    private PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }


    @GetMapping
    public List<Plant> getPlants() {
        return plantService.getPlants();
    }

    //Adding new plants //create a method in Service class from .addPlant
    @PostMapping
    public void addPlant(@RequestBody Plant plant) {
        plantService.addPlant(plant);
    }

    @DeleteMapping (path = "{plantId}")
    public void deletePlant(@PathVariable("plantId") Long plantId){
        plantService.deletePlant(plantId);
    }

    @PutMapping (path = "{plantId}")
    public void updatePlant(@PathVariable("plantId") Long plantId, @RequestBody Plant plant){
        plantService.updatePlant(plantId, plant);
    }
}
