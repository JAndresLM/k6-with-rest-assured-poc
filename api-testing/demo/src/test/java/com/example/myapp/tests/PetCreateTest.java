package com.example.myapp.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import com.example.myapp.actions.Robot;
import com.example.myapp.models.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SerenityJUnit5Extension.class)
public class PetCreateTest {
    Robot robot;

    @BeforeEach
    public void setUp(){
        this.robot = new Robot("http://localhost:8080/api/v3");
    }

    // TODO
    // Add Negative Scenarios


    @Test
    public void testPetsCanBeAddedSuccessfully(){
        Pet pet = new Pet("Raito", "available");
        Pet currentPet = this.robot.post("/pet", pet, Pet.class);
        assertEquals(pet.getId(), currentPet.getId());
        //TODO Validate data and schema
    }

    // The idea of the wrapper is to avoid code dupplication like this
    /*@Test
    public void testPetsCreation(){
        Pet pet = new Pet("Kitty", "available");

        Pet currentPet = given()
                .baseUri("http://localhost:8080/api/v3")
                .basePath("/pet")
                .body(pet, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).post().getBody().as(Pet.class, ObjectMapperType.GSON);
        
        assertEquals(pet.getId(), currentPet.getId());
    }*/
}
