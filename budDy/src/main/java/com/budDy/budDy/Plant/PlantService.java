package com.budDy.budDy.Plant;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService {
    private PlantDataAccessService plantDataAccessService;

    public PlantService(PlantDataAccessService plantDataAccessService){
        this.plantDataAccessService = plantDataAccessService;
    }

    public List<Plant> getPlants(){
        return plantDataAccessService.listAllPlants();
    }

    public void addNewPlant(Plant plant) {
        plantDataAccessService.insertPlant(plant);
    }

    public void deletePlant(String plantName) {
        List<Plant> plants = plantDataAccessService.listAllPlants();
        boolean exists = false;
        for (Plant p: plants) {
            if(p.getName().equals(plantName)){
                exists = true;
                plantDataAccessService.removePlant(p);
            }
        }
        if (!exists) {
            throw new IllegalStateException(plantName + " was not found so cannot be removed.");
        }
    }

    public void updatePlant (String plantName, Plant plant) {
        List<Plant> plants = plantDataAccessService.listAllPlants();
        boolean exists = false;
        for (Plant p: plants) {
            if (p.getName().equals(plantName)){
                exists = true;
                p.setPlantType(plant.getPlantType());
                p.setWater(plant.getWater());
                p.setLight(plant.getLight());
                p.setExperience(plant.getExperience());
                p.setRating(plant.getRating());
            }
        }
        if (!exists){
            throw new IllegalStateException(plantName + "not found");
        }
    }
}
