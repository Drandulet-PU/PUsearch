package com.example.pusearch;

import java.util.HashMap;

public class Data {

    // список топ запросов
    public static HashMap<String, String> buttons = new HashMap<>() {{
        put("• Люк Скайвокер", "Luke Skywalker");
        put("• C-3PO", "C-3PO");
        put("• Дарт Вейдер", "Darth Vader");
        put("• Призрачная угроза", "The Phantom Menace");
        put("• Новая надежда", "A New Hope");
        put("• Империя наносит ответный удар", "The Empire Strikes Back");
        put("• Звезда смерти", "Death Star");
        put("• CR90 корвет", "CR90 corvette");
        put("• Тысячелетний сокол", "Millennium Falcon");
        put("• Снежный спидер", "Snowspeeder");
        put("• Имперский спидер-байк", "Imperial Speeder Bike");
        put("• Дроид-стервятник", "Vulture Droid");
        put("• Человек", "Human");
        put("• Дройд", "Droid");
        put("• Ebuchi", "Wookie");
    }};

    // стиль текста css
    public static String textStyle = "-fx-text-fill: white; -fx-background-color: #333; -fx-font-size: 28; -fx-font-style: italic;";
}
