package com.example.myapp.tests;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.example.myapp.actions.Robot;
import com.example.myapp.models.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

@ExtendWith(SerenityJUnit5Extension.class)
public class PetGetTest{

    Robot robot;

    @BeforeEach
    public void setUp(){
        this.robot = new Robot("http://localhost:8080/api/v3");
    }

    @Test
    public void testPetCanBeRetrievedById(){
        Pet expectedPet = new Pet("Kumi", "available");
        Pet currentPet = this.robot.get("/pet/1", Pet.class);
        assertEquals(expectedPet, currentPet);
    }

    //TODO
    // Add Negative Scenarios
}