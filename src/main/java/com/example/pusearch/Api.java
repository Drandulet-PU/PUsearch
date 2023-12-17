package com.example.pusearch;

import io.restassured.http.ContentType;
import io.restassured.path.json.exception.JsonPathException;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class Api {

    // запуск всех потоков
    public static class searchAll extends Thread {
        private String request;
        private HashMap<String, String> result = new HashMap<String, String>();

        // принимаем запрос
        public void putValue(String r) {
            request = r;
        }

        // запуск всех потоков
        @Override
        public void run() {
            searchPeople people = new searchPeople();
            people.putValue(request);
            people.start();
            searchFilms films = new searchFilms();
            films.putValue(request);
            films.start();
            searchVehicles vehicles = new searchVehicles();
            vehicles.putValue(request);
            vehicles.start();
            searchStarships starships = new searchStarships();
            starships.putValue(request);
            starships.start();
            searchSpecies species = new searchSpecies();
            species.putValue(request);
            species.start();
            try {
                people.join();
                films.join();
                vehicles.join();
                starships.join();
                species.join();
            } catch (InterruptedException e) {}

            // собираем ответы в hashmap
            result.put("• species:\n\n", species.getValue());
            result.put("• starships:\n\n", starships.getValue());
            result.put("• vehicles:\n\n", vehicles.getValue());
            result.put("• films:\n\n", films.getValue());
            result.put("• people:\n\n", people.getValue());
        }

        // возвращаем ответ hashmap
        public HashMap<String, String> getValue() {
            return result;
        }
    }

    // запрос для поиска people
    public static class searchPeople extends Thread {
        private String result;
        private String request;

        // получаем запрос
        public void putValue(String r) {
            request = r;
        }

        // получаем ответ str
        @Override
        public void run() {
            try {
                List<DTO.people> response = given()
                        .when()
                        .contentType(ContentType.JSON)
                        .get("https://swapi.dev/api/people/?search=" + request)
                        .then()
                        .extract().body().jsonPath().getList("results", DTO.people.class);
                result = response.stream().map(DTO.people::getData).collect(Collectors.joining());
                if (!result.isEmpty()) { result = result.substring(0 , result.length() - 1);}

            }catch (JsonPathException e) { result = "ERROR\n"; }
        }

        // возвращаем ответ
        public String getValue() {
            return result;
        }
    }

    // запрос для поиска films
    public static class searchFilms extends Thread {
        private String result;
        private String request;

        public void putValue(String r) {
            request = r;
        }

        @Override
        public void run() {
            try {
                List<DTO.films> response = given()
                        .when()
                        .contentType(ContentType.JSON)
                        .get("https://swapi.dev/api/films/?search=" + request)
                        .then()
                        .extract().body().jsonPath().getList("results", DTO.films.class);
                result = response.stream().map(DTO.films::getData).collect(Collectors.joining());
                if (!result.isEmpty()) { result = result.substring(0 , result.length() - 1);}

            }catch (JsonPathException e) { result = "ERROR\n"; }
        }

        public String getValue() {
            return result;
        }
    }

    // запрос для поиска vehicles
    public static class searchVehicles extends Thread {
        private String result;
        private String request;

        public void putValue(String r) {
            request = r;
        }

        @Override
        public void run() {
            try {
                List<DTO.vehicles> response = given()
                        .when()
                        .contentType(ContentType.JSON)
                        .get("https://swapi.dev/api/vehicles/?search=" + request)
                        .then()
                        .extract().body().jsonPath().getList("results", DTO.vehicles.class);
                result = response.stream().map(DTO.vehicles::getData).collect(Collectors.joining());
                if (!result.isEmpty()) { result = result.substring(0 , result.length() - 1);}

            }catch (JsonPathException e) { result = "ERROR\n"; }
        }

        public String getValue() {
            return result;
        }
    }

    // запрос для поиска starships
    public static class searchStarships extends Thread {
        private String result;
        private String request;

        public void putValue(String r) {
            request = r;
        }

        @Override
        public void run() {
            try {
                List<DTO.starships> response = given()
                        .when()
                        .contentType(ContentType.JSON)
                        .get("https://swapi.dev/api/starships/?search=" + request)
                        .then()
                        .extract().body().jsonPath().getList("results", DTO.starships.class);
                result = response.stream().map(DTO.starships::getData).collect(Collectors.joining());
                if (!result.isEmpty()) { result = result.substring(0 , result.length() - 1);}

            }catch (JsonPathException e) { result = "ERROR\n"; }
        }

        public String getValue() {
            return result;
        }
    }

    // запрос для поиска species
    public static class searchSpecies extends Thread {
        private String result;
        private String request;

        public void putValue(String r) {
            request = r;
        }

        @Override
        public void run() {
            try {
                List<DTO.species> response = given()
                        .when()
                        .contentType(ContentType.JSON)
                        .get("https://swapi.dev/api/species/?search=" + request)
                        .then()
                        .extract().body().jsonPath().getList("results", DTO.species.class);
                result = response.stream().map(DTO.species::getData).collect(Collectors.joining());
                if (!result.isEmpty()) { result = result.substring(0 , result.length() - 1);}

            }catch (JsonPathException e) { result = "ERROR\n"; }
        }

        public String getValue() {
            return result;
        }
    }

}
