package com.example.pusearch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

// Главный класс -_-
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        // установка сцены
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene1.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.setResizable(false);
        stage.setTitle("PUsearch");
        stage.getIcons().add(new Image(getClass().getResource("icon.png").toString()));
        stage.show();

        // запуск анимаций
        new animatefx.animation.FadeIn((Button)loader.getNamespace().get("s1_1")).setSpeed(0.9).play();
        new animatefx.animation.FadeIn((TextField)loader.getNamespace().get("s1_2")).setSpeed(0.6).play();
        new animatefx.animation.FadeIn((Button)loader.getNamespace().get("s1_3_close")).setSpeed(0.3).play();
    }
}
