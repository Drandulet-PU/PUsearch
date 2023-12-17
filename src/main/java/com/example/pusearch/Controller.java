package com.example.pusearch;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.util.Duration;

import java.util.HashMap;
import java.io.IOException;

public class Controller {
    private Stage stage;
    private Scene scene;
    private FXMLLoader loader;
    @FXML
    private VBox s1_top;
    @FXML
    private Button s1_3_close;
    @FXML
    private ScrollPane s1_0;


    //проверяем закрыт или открыт заголовок по id
    @FXML
    public void top(javafx.event.ActionEvent event){
        // проверяем закрыт или открыт заголовок по id
        if (((Node) event.getSource()).getId().equals("s1_3_close")) {
            // меняем id
            s1_3_close.setId("s1_3_open");

            // добавление кнопок
            for (String key: Data.buttons.keySet()){
                s1_top.getChildren().add(new Button(key) {{
                    setStyle(Data.textStyle);
                    setOnAction(e -> gettext(e));
                    setId(Data.buttons.get(key));
                }});
            }

            // анимации
            new Timeline(new KeyFrame(Duration.seconds(0.25), new KeyValue(s1_0.vvalueProperty(), 0.35))).play();
            new animatefx.animation.FadeIn(s1_top).setSpeed(1.5).play();

        }else{
            // не асинхронные анимации
            new Timeline(new KeyFrame(Duration.seconds(0.5), new KeyValue(s1_0.vvalueProperty(), -0.5))).play();
            Timeline timeline = new animatefx.animation.FadeOut(s1_top).getTimeline();
            timeline.setOnFinished(e -> {s1_3_close.setId("s1_3_close"); s1_top.getChildren().clear();});
            timeline.setRate(2.1);
            timeline.play();
        }
    }

    // переключение на 1 сцену
    @FXML
    public void to1(javafx.event.ActionEvent event){
        try {
            loader = new FXMLLoader(getClass().getResource("scene1.fxml"));
            Parent root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            new animatefx.animation.FadeIn((Button)loader.getNamespace().get("s1_1")).setSpeed(0.9).play();
            new animatefx.animation.FadeIn((TextField)loader.getNamespace().get("s1_2")).setSpeed(0.6).play();
            new animatefx.animation.FadeIn((Button)loader.getNamespace().get("s1_3_close")).setSpeed(0.3).play();

        }catch (IOException e){}
    }

    // переключение на 2 сцену
    @FXML
    public void to2(javafx.event.ActionEvent event){
        try {
            loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
            Parent root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            new animatefx.animation.FadeIn((AnchorPane)loader.getNamespace().get("s2_0")).setSpeed(0.9).play();
            new animatefx.animation.FadeIn((Button)loader.getNamespace().get("s2_1")).setSpeed(0.9).play();
            new animatefx.animation.FadeIn((Text)loader.getNamespace().get("s2_2")).setSpeed(0.6).play();

        }catch (IOException e){}
    }

    // переключение на 3 сцену
    @FXML
    public void to3(javafx.event.ActionEvent event){
        try {
            loader = new FXMLLoader(getClass().getResource("scene3.fxml"));
            Parent root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            new animatefx.animation.FadeIn((Button)loader.getNamespace().get("s3_1")).setSpeed(0.9).play();
            new animatefx.animation.FadeIn((AnchorPane)loader.getNamespace().get("s3_3")).setSpeed(0.9).play();
            new animatefx.animation.FadeIn((TextField)loader.getNamespace().get("s3_2")).setSpeed(0.6).play();
            new animatefx.animation.FadeIn((Text)loader.getNamespace().get("s3_loading")).setSpeed(0.3).play();
            new animatefx.animation.FadeIn((Text)loader.getNamespace().get("s3_mega")).setSpeed(0.3).play();

        }catch (IOException e) {}
    }

    // получаем запрос
    @FXML
    public void gettext(javafx.event.ActionEvent event) {
        Object soruce = event.getSource();
        String request;

        if (soruce instanceof Button) {
            request = ((Button) soruce).getId();

        }else{request = ((TextField) soruce).getText();}

        to3(event);
        search(request);
    }

    // запускаем поиск
    @FXML
    public void search(String request){
        // запускаем отдельный поток что бы не занимать main thread
        Api.searchAll t = new Api.searchAll();
        t.putValue(request);
        t.start();

        // крутим анимацию загрузки пока идет поиск
        Timeline timeline = new animatefx.animation.Tada((Text) loader.getNamespace().get("s3_mega")).getTimeline();
        timeline.setOnFinished(e -> {
            if (t.isAlive()) {
                timeline.play();

            }else {
                ((Text) loader.getNamespace().get("s3_loading")).setText("");
                ((Text) loader.getNamespace().get("s3_mega")).setText("");
                putTitles(t.getValue());
            }
        });
        timeline.setRate(0.5);
        timeline.play();
    }

    // выводим заголовки
    @FXML
    public void putTitles(HashMap<String, String> data) {
        // создаем контейнер для заголовков
        VBox result = (VBox) loader.getNamespace().get("s3_result");

        // добавляем кнопки
        for (String key: data.keySet()) {
            if (!data.get(key).equals("")){
                result.getChildren().add(new Button(key) {{
                    setStyle(Data.textStyle); setOnAction(e -> putText(e, data)); setId("close");
                }});
            }
        }
    }

    // вывод и скрытие текста под заголовками
    @FXML
    public void putText(javafx.event.ActionEvent event, HashMap<String, String> data){
        VBox result = (VBox) loader.getNamespace().get("s3_result");

        //проверяем закрыт или открыт заголовок по id
        if (((Button) event.getSource()).getId().equals("close")) {
            // меняем id
            ((Button) event.getSource()).setId("open");

            // находим позицию заголовка в vbox
            int index = result.getChildren().indexOf((Button) event.getSource()) + 1;

            // находим информацию используя заголовок как ключ
            Text text = new Text(data.get(((Button) event.getSource()).getText()));
            text.setStyle("-fx-font-size: 28; -fx-fill: white;");
            text.wrappingWidthProperty().set(800.0);

            // выводим
            result.getChildren().add(index, text);

            new animatefx.animation.FadeIn(text).setSpeed(1.5).play();

        }else{
            ((Button) event.getSource()).setId("close");

            int index = result.getChildren().indexOf((Button) event.getSource()) + 1;

            // не асинхронные анимации
            Timeline timeline = new animatefx.animation.FadeOut(result.getChildren().get(index)).getTimeline();
            timeline.setOnFinished(e -> { result.getChildren().remove(index); });
            timeline.setRate(2.1);
            timeline.play();
        }
    }
}
