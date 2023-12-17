package com.example.pusearch;

import java.util.ArrayList;

// на самом деле это POJO подходит гораздо лучше
public class DTO {
    public static class people {
        // объявляем переменные
        public String name;
        public String height;
        public String mass;
        public String hair_color;
        public String skin_color;
        public String eye_color;
        public String birth_year;
        public String gender;
        public String homeworld;
        public ArrayList<String> films;
        public ArrayList<String> species;
        public ArrayList<String> vehicles;
        public ArrayList<String> starships;
        public String created;
        public String edited;
        public String url;

        public people() {
            super();
        }

        // заполняем класс
        public people(String name, String height, String mass, String hair_color, String skin_color, String eye_color, String birth_year, String gender, String homeworld, ArrayList<String> films, ArrayList<String> species, ArrayList<String> vehicles, ArrayList<String> starships, String created, String edited, String url) {
            this.name = name;
            this.height = height;
            this.mass = mass;
            this.hair_color = hair_color;
            this.skin_color = skin_color;
            this.eye_color = eye_color;
            this.birth_year = birth_year;
            this.gender = gender;
            this.homeworld = homeworld;
            this.films = films;
            this.species = species;
            this.vehicles = vehicles;
            this.starships = starships;
            this.created = created;
            this.edited = edited;
            this.url = url;
        }

        // выводим нужную информацию
        public String getData() {
            String data = new String(
                    "\tname: " + name + '\n' +
                            "\theight: " + height + '\n' +
                            "\tmass: " + mass + '\n' +
                            "\thair_color: " + hair_color + '\n' +
                            "\tskin_color: " + skin_color + '\n' +
                            "\teye_color: " + eye_color + '\n' +
                            "\tbirth_year: " + birth_year + '\n' +
                            "\tgender: " + gender + "\n\n"
            );
            return data;
        }
    }

    public static class films {
        public String title;
        public int episode_id;
        public String opening_crawl;
        public String director;
        public String producer;
        public String release_date;
        public ArrayList<String> characters;
        public ArrayList<String> planets;
        public ArrayList<String> starships;
        public ArrayList<String> vehicles;
        public ArrayList<String> species;
        public String created;
        public String edited;
        public String url;

        public films() {
            super();
        }

        public films(String title, int episode_id, String opening_crawl, String director, String producer, String release_date, ArrayList<String> characters, ArrayList<String> planets, ArrayList<String> starships, ArrayList<String> vehicles, ArrayList<String> species, String created, String edited, String url) {
            this.title = title;
            this.episode_id = episode_id;
            this.opening_crawl = opening_crawl;
            this.director = director;
            this.producer = producer;
            this.release_date = release_date;
            this.characters = characters;
            this.planets = planets;
            this.starships = starships;
            this.vehicles = vehicles;
            this.species = species;
            this.created = created;
            this.edited = edited;
            this.url = url;
        }

        public String getData() {
            String data = new String(
                    "\ttitle: " + title + '\n' +
                            "\tdirector: " + director + '\n' +
                            "\trelease date: " + release_date + "\n\n"


            );
            return data;
        }
    }

    public static class vehicles {
        public String name;
        public String model;
        public String manufacturer;
        public String cost_in_credits;
        public String length;
        public String max_atmosphering_speed;
        public String crew;
        public String passengers;
        public String cargo_capacity;
        public String consumables;
        public String vehicle_class;
        public ArrayList<String> pilots;
        public ArrayList<String> films;
        public String created;
        public String edited;
        public String url;

        public vehicles() {
            super();
        }
        public vehicles(String name, String model, String manufacturer, String cost_in_credits, String length, String max_atmosphering_speed, String crew, String passengers, String cargo_capacity, String consumables, String vehicle_class, ArrayList<String> pilots, ArrayList<String> films, String created, String edited, String url) {
            this.name = name;
            this.model = model;
            this.manufacturer = manufacturer;
            this.cost_in_credits = cost_in_credits;
            this.length = length;
            this.max_atmosphering_speed = max_atmosphering_speed;
            this.crew = crew;
            this.passengers = passengers;
            this.cargo_capacity = cargo_capacity;
            this.consumables = consumables;
            this.vehicle_class = vehicle_class;
            this.pilots = pilots;
            this.films = films;
            this.created = created;
            this.edited = edited;
            this.url = url;
        }

        public String getData() {
            String data = new String(
                    "\tname: " + name + '\n' +
                            "\tmodel: " + model + '\n' +
                            "\tcost in credits: " + cost_in_credits + '\n' +
                            "\tmax atmosphering speed: " + max_atmosphering_speed + '\n' +
                            "\tcrew: " + crew + '\n' +
                            "\tpassengers: " + passengers + "\n\n"
            );
            return data;
        }
    }

    public static class starships{
        public String name;
        public String model;
        public String manufacturer;
        public String cost_in_credits;
        public String length;
        public String max_atmosphering_speed;
        public String crew;
        public String passengers;
        public String cargo_capacity;
        public String consumables;
        public String hyperdrive_rating;
        public String MGLT;
        public String starship_class;
        public ArrayList<String> pilots;
        public ArrayList<String> films;
        public String created;
        public String edited;
        public String url;

        public starships() {
            super();
        }

        public starships(String name, String model, String manufacturer, String cost_in_credits, String length, String max_atmosphering_speed, String crew, String passengers, String cargo_capacity, String consumables, String hyperdrive_rating, String mGLT, String starship_class, ArrayList<String> pilots, ArrayList<String> films, String created, String edited, String url) {
            this.name = name;
            this.model = model;
            this.manufacturer = manufacturer;
            this.cost_in_credits = cost_in_credits;
            this.length = length;
            this.max_atmosphering_speed = max_atmosphering_speed;
            this.crew = crew;
            this.passengers = passengers;
            this.cargo_capacity = cargo_capacity;
            this.consumables = consumables;
            this.hyperdrive_rating = hyperdrive_rating;
            this.MGLT = MGLT;
            this.starship_class = starship_class;
            this.pilots = pilots;
            this.films = films;
            this.created = created;
            this.edited = edited;
            this.url = url;
        }

        public String getData() {
            String data = new String(
                    "\tname: " + name + '\n' +
                            "\tmodel: " + model + '\n' +
                            "\tcost in credits: " + cost_in_credits + '\n' +
                            "\tmax atmosphering speed: " + max_atmosphering_speed + '\n' +
                            "\tcrew: " + crew + '\n' +
                            "\tpassengers: " + passengers + "\n\n"
            );
            return data;
        }
    }

    public static class species{
        public String name;
        public String classification;
        public String designation;
        public String average_height;
        public String skin_colors;
        public String hair_colors;
        public String eye_colors;
        public String average_lifespan;
        public String homeworld;
        public String language;
        public ArrayList<String> people;
        public ArrayList<String> films;
        public String created;
        public String edited;
        public String url;

        public species() {
            super();
        }

        public species(String name, String classification, String designation, String average_height, String skin_colors, String hair_colors, String eye_colors, String average_lifespan, String homeworld, String language, ArrayList<String> people, ArrayList<String> films, String created, String edited, String url) {
            this.name = name;
            this.classification = classification;
            this.designation = designation;
            this.average_height = average_height;
            this.skin_colors = skin_colors;
            this.hair_colors = hair_colors;
            this.eye_colors = eye_colors;
            this.average_lifespan = average_lifespan;
            this.homeworld = homeworld;
            this.language = language;
            this.people = people;
            this.films = films;
            this.created = created;
            this.edited = edited;
            this.url = url;
        }

        public String getData() {
            String data = new String(
                    "\tname: " + name + '\n' +
                            "\tclassification: " + classification + '\n' +
                            "\tdesignation: " + designation + '\n' +
                            "\taverage height: " + average_height + '\n' +
                            "\tskin colors: " + skin_colors + '\n' +
                            "\thair colors: " + hair_colors + '\n' +
                            "\teye_colors: " + eye_colors + '\n' +
                            "\taverage lifespan: " + average_lifespan + '\n' +
                            "\tlanguage: " + language + "\n\n"
            );
            return data;
        }
    }
}
