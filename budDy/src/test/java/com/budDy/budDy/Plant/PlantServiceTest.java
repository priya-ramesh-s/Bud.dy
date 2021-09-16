package com.budDy.budDy.Plant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.eq;

public class PlantServiceTest {
    @Mock
    private PlantRepository plantRepository;

    private PlantService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new PlantService(plantRepository);
    }

    @Test
    void itCanAddNewPlant() {
        Plant plant = new Plant("Rubber Plant", "Ficus elastica", "Indoor", "Light", "Dark", "Intermediate", 2);
        Mockito.when(plantRepository.save(eq(plant))).thenReturn(plant);

        Mockito.when(plantRepository.findAll()).thenReturn(List.of(
                new Plant("Aloe Vera", "A.vera", "indoor", "medium", "medium", "intermediate", 5),
                new Plant("Spearmint", "Mentha spicata", "outdoor", "medium", "medium", "intermediate", 5)
        ));

        Plant result = underTest.addPlant(plant);
        ArgumentCaptor<Plant> plantArgumentCaptor = ArgumentCaptor.forClass(Plant.class);
        Mockito.verify(plantRepository).save(plantArgumentCaptor.capture());

        Plant expectedPlant = plantArgumentCaptor.getValue();

        assertThat(expectedPlant).isEqualTo(plant);
        assertThat(result).isEqualTo(plant);
    }

    @Test
    void cannotAddPlantThatAlreadyExists() {
        Plant plant = new Plant("Rubber Plant", "Ficus elastica", "Indoor", "Light", "Dark", "Intermediate", 2);
        Plant plant1 = new Plant("Rubber Plant", "Ficus elastica", "Indoor", "Light", "Dark", "Intermediate", 2);
        Optional<Plant> plant2 = Optional.of(plant1);

        Mockito.when(plantRepository.getPlantByName(plant.getName())).thenReturn(Optional.of(plant1));
        assertThatThrownBy(() -> {
            underTest.addPlant(plant);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("plant already exists");
        Mockito.verify(plantRepository, Mockito.never()).save(plant);
    }

    @Test
    void shouldThrowWhenPlantNameIsNull() {
        Plant plant = new Plant(null, "Ficus elastica", "Indoor", "Light", "Dark", "Intermediate", 2);
        assertThatThrownBy(() -> {
            underTest.addPlant(plant);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("Plant cannot have empty fields.");
        Mockito.verifyNoInteractions(plantRepository);
    }

    @Test
    void shouldThrowWhenPlantLatinNameIsNull() {
        Plant plant = new Plant("Rubber Plant", null, "Indoor", "Light", "Dark", "Intermediate", 2);
        assertThatThrownBy(() -> {
            underTest.addPlant(plant);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("Plant cannot have empty fields.");
        Mockito.verifyNoInteractions(plantRepository);
    }
    @Test
    void shouldThrowWhenPlantTypeIsNull() {
        Plant plant = new Plant("Rubber Plant", "Ficus elastica", null, "Light", "Dark", "Intermediate", 2);
        assertThatThrownBy(() -> {
            underTest.addPlant(plant);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("Plant cannot have empty fields.");
        Mockito.verifyNoInteractions(plantRepository);
    }

    @Test
    void shouldThrowWhenWaterIsNull() {
        Plant plant = new Plant("Rubber Plant", "Ficus elastica", "Indoor", null, "Dark", "Intermediate", 2);
        assertThatThrownBy(() -> {
            underTest.addPlant(plant);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("Plant cannot have empty fields.");
        Mockito.verifyNoInteractions(plantRepository);
    }

    @Test
    void shouldThrowWhenLightIsNull() {
        Plant plant = new Plant("Rubber Plant", "Ficus elastica", "Indoor", "Light", null, "Intermediate", 2);
        assertThatThrownBy(() -> {
            underTest.addPlant(plant);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("Plant cannot have empty fields.");
        Mockito.verifyNoInteractions(plantRepository);
    }

    @Test
    void shouldThrowWhenExperienceIsNull() {
        Plant plant = new Plant("Rubber Plant", "Ficus elastica", "Indoor", "Light", "Dark", null, 2);
        assertThatThrownBy(() -> {
            underTest.addPlant(plant);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("Plant cannot have empty fields.");
        Mockito.verifyNoInteractions(plantRepository);
    }

    @Test
    void shouldThrowWhenRatingIsZero() {
        Plant plant = new Plant("Rubber Plant", "Ficus elastica", "Indoor", "Light", "Dark", "Intermediate", 0);
        assertThatThrownBy(() -> {
            underTest.addPlant(plant);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("Plant cannot have empty fields.");
        Mockito.verifyNoInteractions(plantRepository);
    }

    @Test
    void shouldThrowWhenPlantIsNull() {
        assertThatThrownBy(() -> {
            underTest.addPlant(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Plant cannot be null!");
        Mockito.verifyNoInteractions(plantRepository);
    }

//    @Test
//    void canDeletePlantWhenPlantExists() {
//        Plant plant = new Plant("Rubber Plant", "Ficus elastica", "Indoor", "Light", "Dark", "Intermediate", 2);
//        plant.setId(1L);
//        Mockito.when(plantRepository.existsById(plant.getId())).thenReturn(true);
//        Mockito.verify(plantRepository).deleteById(plant.getId());
//        underTest.deletePlant(plant.getId());
//
////        boolean result = underTest.deletePlant(plant.getName());
////        assertThat(result).isEqualTo(true);
//    }

//    public void whenGivenId_shouldDeleteUser_ifFound(){
//        User user = new User();
//        user.setName(“Test Name”);
//        user.setId(1L);
//        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
//        deleteUserService.deleteUser(user.getId());
//        verify(userRepository).deleteById(user.getId());
//    }

    @Test
    void cannotDeletePlantWhenPlantDoesNotExist(){
        Plant plant = new Plant("Rubber Plant", "Ficus elastica", "Indoor", "Light", "Dark", "Intermediate", 2);
        Long plantId = plant.getId();
        Mockito.when(plantRepository.findAll()).thenReturn(List.of(
                new Plant("Aloe Vera", "A.vera", "indoor", "medium", "medium", "intermediate", 5),
                new Plant("Spearmint", "Mentha spicata", "outdoor", "medium", "medium", "intermediate", 5)
        ));
        assertThatThrownBy(() -> {
            underTest.deletePlant(plantId);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("plant ID" + plantId + "was not found");
        Mockito.verify(plantRepository, Mockito.never()).delete(plant);
    }
        @Test
    void cannotUpdatePlantWhenPlantDoesNotExist(){
        Plant plant = new Plant("Rubber Plant", "Ficus elastica", "Indoor", "Light", "Dark", "Intermediate", 2);
        Long plantId = plant.getId();
        Mockito.when(plantRepository.findAll()).thenReturn(List.of(
                new Plant("Aloe Vera", "A.vera", "indoor", "medium", "medium", "intermediate", 5),
                new Plant("Spearmint", "Mentha spicata", "outdoor", "medium", "medium", "intermediate", 5)
        ));
        assertThatThrownBy(() -> {
            underTest.updatePlant(plantId, plant);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("Plant cannot be updated as plant id does not exist!");
        Mockito.verify(plantRepository, Mockito.never()).save(plant);

    }
    @Test
    void canGetListFromPlantDatabase(){
        Mockito.when(plantRepository.findAll()).thenReturn(List.of(
                new Plant("Aloe Vera", "A.vera", "indoor", "medium", "medium", "intermediate", 5),
                new Plant("Spearmint", "Mentha spicata", "outdoor", "medium", "medium", "intermediate", 5)
        ));
        List<Plant> allPlants = underTest.getPlants();
        assertThat(allPlants).isEqualTo(plantRepository.findAll());
    }
}
