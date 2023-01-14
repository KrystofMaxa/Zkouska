package com.example.rocnikovkanemcina;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloApplication extends Application {
    int poradi;
    String cesky;
    String nemecky;
    String pravidelnost;
    static int l = 0; static int p = 0; static int k = 0;
    static String pravid = "Er hat";
    static String nepravid = "Er ist";

    static ArrayList<CelyObjekt> arr = new ArrayList<CelyObjekt>();
    static ArrayList<Integer> list = new ArrayList<Integer>();
    @Override
    public void start(Stage stage) throws IOException {

        //mam pole prazdnych lable
       // ArrayList<Label> napis = new ArrayList<>();
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 15,15);

        stage.setTitle("Hello!");
        VBox vbox = new VBox();
        pane.getChildren().add(vbox);

        //textova pole, pro index slovesa a pocetslov
        TextField poradiSlova = new TextField("Index slovesa");
        vbox.getChildren().addAll(poradiSlova);
        Button start = new Button("START");
        Button dal = new Button("DAL");
        vbox.getChildren().add(dal);
//pridat lable
        File file = new File("data.dat");
        Scanner sc = new Scanner(file);
        Scanner kon = new Scanner(System.in);
        for(int i = 0; i<2; i++){
            int poradi = sc.nextInt();
            String cz = sc.next();
            String de = sc.next();
            String pr = sc.next();
            arr.add(new CelyObjekt(poradi,cz,de,pr));
        }
        dal.setOnAction(actionEvent -> {

            if(p==0) {
               // HBox hbox = new HBox();
                Label napis = new Label();

                napis.setMaxSize(200, 300);
                napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).cesky));
                vbox.getChildren().add(napis);
                //vbox.getChildren().add(hbox);
                p++;
            }else if(p==1) {
                //HBox hbox = new HBox();
                Label napis = new Label();
                napis.setMaxSize(200, 300);
                napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).nemecky));
                vbox.getChildren().add(napis);
                //vbox.getChildren().add(hbox);
                p++;
            }else if(p==2) {
                //HBox hbox = new HBox();
                if (arr.get(Integer.parseInt(poradiSlova.getText())).pravidelnost.equals("N")){
                    Label napis = new Label();
                    napis.setMaxSize(200, 300);
                    napis.setText(nepravid + " " + arr.get(Integer.parseInt(poradiSlova.getText())).nemecky);
                    vbox.getChildren().add(napis);
                 //   vbox.getChildren().add(hbox);
                }else {
                    Label napis = new Label();
                    napis.setMaxSize(200, 300);
                    napis.setText(pravid + " " + arr.get(Integer.parseInt(poradiSlova.getText())).nemecky);
                    vbox.getChildren().add(napis);
               //     vbox.getChildren().add(hbox);
                }
                p=0;
            }
        });
        Scene scene = new Scene(pane, 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}