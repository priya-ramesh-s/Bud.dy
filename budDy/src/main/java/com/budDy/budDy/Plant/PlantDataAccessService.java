package com.budDy.budDy.Plant;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlantDataAccessService {
    private static List<Plant> plantDB;

    public PlantDataAccessService() {
        Plant aloeVera = new Plant("Aloe Vera", "A.vera", "indoor", "medium", "medium", "intermediate", 5);
        Plant spearmint = new Plant("Spearmint", "Mentha spicata", "outdoor", "medium", "medium", "intermediate", 5);

        plantDB = new ArrayList<Plant>();
        plantDB.add(aloeVera);
        plantDB.add(spearmint);

    }

    public List<Plant> listAllPlants() {
        return plantDB;
    }

    public void insertPlant(Plant plant) {
        plantDB.add(plant);
    }

    public void removePlant(Plant plant) {
        plantDB.remove(plant);
    }
}
