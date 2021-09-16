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


   @Query(value = "SELECT * FROM plant WHERE plant_type = ?1 AND plant_experience = ?2 " +
           "ORDER BY rating DESC LIMIT 3", nativeQuery = true)
     Optional<List<Plant>> getTopThreePlants(String plantType, String plantExperience);

   @Query(value  = "SELECT * FROM plant INNER JOIN quiz ON plant.id = quiz.plant_id_3 WHERE quiz.id = ?1",
           nativeQuery = true)
    Optional<Plant> getSavedTopThree(Long quizId);

    @Query(value  = "SELECT * FROM plant INNER JOIN quiz ON plant.id = quiz.plant_id_2 WHERE quiz.id = ?1",
            nativeQuery = true)
    Optional<Plant> getSavedTopTwo(Long quizId);

    @Query(value  = "SELECT * FROM plant INNER JOIN quiz ON plant.id = quiz.plant_id_1 WHERE quiz.id = ?1",
            nativeQuery = true)
    Optional<Plant> getSavedTopOne(Long quizId);

// //write methods to sort and return list WHERE ....


}
