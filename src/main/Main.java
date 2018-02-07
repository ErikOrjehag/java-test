package main;

import java.util.Optional;
import java.util.Properties;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.LinkedList;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            ToggleGroup group = new ToggleGroup();
            JFXRadioButton noProxy = new JFXRadioButton("No Proxy");
            noProxy.setId("NoProxy");
            noProxy.setToggleGroup(group);
            noProxy.setSelected(true);
            JFXRadioButton useSystemProxySettings = new JFXRadioButton("Use system proxy setting");
            useSystemProxySettings.setToggleGroup(group);

            VBox root = new VBox();
            root.setPadding(new Insets(5, 5, 5, 5));
            VBox.setMargin(noProxy, new Insets(5, 5, 5, 5));
            VBox.setMargin(useSystemProxySettings, new Insets(5, 5, 5, 5));
            root.setSpacing(15);
            root.setMinSize(100, 100);
            root.getChildren().addAll(noProxy, useSystemProxySettings);

            //Parent root = FXMLLoader.load(getClass().getResource("ConnectionSetting.fxml"));


            JFXButton bookmarks = new JFXButton("Bookmarks");
            JFXButton history = new JFXButton("history");
            JFXButton b1 = new JFXButton("button");

            JFXTextField field = new JFXTextField();
            VBox.setMargin(field, new Insets(20, 20, 20, 20));
            field.setLabelFloat(true);
            field.setPromptText("Text input field");

            VBox b = new VBox();
            b.setPadding(new Insets(10, 10, 10, 10));
            b.setSpacing(10);
            b.getChildren().addAll(b1, bookmarks, history, field);








            b1.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setGraphic(root);
                alert.setTitle("Proxy Setting");
                alert.setHeaderText("Configure Proxy to Access Internet");


                Optional<ButtonType> result = alert.showAndWait();
                Properties systemProperties = System.getProperties();
                if (result.get() == ButtonType.OK) {
                    if(group.getSelectedToggle().equals(noProxy)){
                        System.out.println("No Proxy");

                        //Remove Proxy for Http
                        systemProperties.setProperty("http.proxyHost","");
                        systemProperties.setProperty("http.proxyPort","");

                        //Remove Proxy for Https
                        systemProperties.setProperty("https.proxyHost","");
                        systemProperties.setProperty("https.proxyPort","");

                    }
                    if(group.getSelectedToggle().equals(useSystemProxySettings)){
                        System.out.println("Use system proxy");

                        //Set Proxy for Http
                        systemProperties.setProperty("http.proxyHost","172.16.0.2");
                        systemProperties.setProperty("http.proxyPort","8080");

                        //Set Proxy for Https
                        systemProperties.setProperty("https.proxyHost","172.16.0.2");
                        systemProperties.setProperty("https.proxyPort","8080");
                    }
                    System.out.println("Ok click!");
                } else {
                    System.out.println("Cancel Click!");
                }
            });

            Scene scene = new Scene(b,400,400);
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int getFirstElement(LinkedList<Integer> list) {
        return list.get(0);
    }

    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}