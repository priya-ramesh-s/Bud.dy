package com.budDy.budDy.Plant;

import com.budDy.budDy.QuizResult.Quiz;
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
    public Plant addPlant(Plant plant) {
        if(plant == null){
            throw new IllegalArgumentException("Plant cannot be null!");
        }
        if (plant.getName() == null ||
                plant.getLatinName() == null ||
                plant.getPlantType() == null ||
                plant.getWater() == null ||
                plant.getLight() == null ||
                plant.getPlantExperience() == null ||
                plant.getRating() == 0) {
            throw new IllegalStateException("Plant cannot have empty fields.");
        }
        Optional<Plant> plantOptional = plantRepository.getPlantByName(plant.getName());
        if (plantOptional.isPresent()){
            throw new IllegalStateException("plant already exists");
        }
        System.out.println(plant);

        return plantRepository.save(plant);

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
        Plant updatePlant = plantRepository.getById(plantId);
        boolean existsById = plantRepository.existsById(plantId);
        if (!existsById){
            throw new IllegalStateException("Plant cannot be updated as plant id does not exist!");
        } else {
            updatePlant.setName(plant.getName());
            updatePlant.setLatinName(plant.getLatinName());
            updatePlant.setPlantType(plant.getPlantType());
            updatePlant.setPlantExperience(plant.getPlantExperience());
            updatePlant.setLight(plant.getLight());
            updatePlant.setWater(plant.getWater());
            updatePlant.setRating(plant.getRating());
            System.out.println(updatePlant);
            plantRepository.save(updatePlant);
        }
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

