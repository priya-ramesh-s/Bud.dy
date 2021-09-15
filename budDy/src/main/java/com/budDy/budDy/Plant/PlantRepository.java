package com.budDy.budDy.Plant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//accessing database when using JPA, in the brackets, it specifies what type of object the repository is working
// with and the id for the type we are working with
//this interface is responsible for data access
@Repository
public interface PlantRepository
        extends JpaRepository<Plant, Long> {

    //SELECT * FROM plant WHERE name = ""
//    @Query("select p from Plant p where p.name = ?1")
    Optional<Plant> getPlantByName(String name);

    @Query("SELECT * FROM plant WHERE plantType = ?1 AND experience = ?2 ORDER BY rating DESC LIMIT 3")
    List<Plant> getTopThree(PlantType plantType, PlantExperience experience);

}
