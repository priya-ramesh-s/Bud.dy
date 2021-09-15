package com.budDy.budDy.Plant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {

    private PlantRepository plantRepository;

    @Autowired
    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    //returns a list from db. Look into the .findAll function, there is a sorting
    public List<Plant> getPlants() {
        return plantRepository.findAll();
    }

    //adds new plant to db
    public void addPlant(Plant plant) {
        Optional<Plant> plantOptional = plantRepository.getPlantByName(plant.getName());
        if (plantOptional.isPresent()){
            throw new IllegalStateException("plant already exists");
        }
        plantRepository.save(plant);
        System.out.println(plant);
    }


    public void deletePlant(Long plantId) {
       boolean existsById = plantRepository.existsById(plantId);
       if (!existsById) {
           throw new IllegalStateException("plant ID" + plantId + "was not found");
       } else {
           plantRepository.deleteById(plantId);
       }
    }


    public void updatePlant(Long plantId, Plant plant) {
    }
}


    //THIS IS OUR DATABASE WHEN RETRIEVED FROM A LIST
//    public List<Plant> getPlants(){
//        return plantDataAccessService.listAllPlants();
//    }
//
//    public void addNewPlant(Plant plant) {
//        plantDataAccessService.insertPlant(plant);
//    }
//
//    public void deletePlant(String plantName) {
//        List<Plant> plants = plantDataAccessService.listAllPlants();
//        boolean exists = false;
//        for (Plant p: plants) {
//            if(p.getName().equals(plantName)){
//                exists = true;
//                plantDataAccessService.removePlant(p);
//            }
//        }
//        if (!exists) {
//            throw new IllegalStateException(plantName + " was not found so cannot be removed.");
//        }
//    }
//
//    public void updatePlant (String plantName, Plant plant) {
//        List<Plant> plants = plantDataAccessService.listAllPlants();
//        boolean exists = false;
//        for (Plant p: plants) {
//            if (p.getName().equals(plantName)){
//                exists = true;
//                p.setPlantType(plant.getPlantType());
//                p.setWater(plant.getWater());
//                p.setLight(plant.getLight());
//                p.setExperience(plant.getExperience());
//                p.setRating(plant.getRating());
//            }
//        }
//        if (!exists){
//            throw new IllegalStateException(plantName + "not found");
//        }
//    }

