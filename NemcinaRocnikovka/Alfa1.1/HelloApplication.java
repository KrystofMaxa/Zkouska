package com.example.rocnikovkanemcinaalfa_1_1;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static javafx.scene.paint.Color.GOLDENROD;

public class HelloApplication extends Application {
    int poradi;
    String cesky;
    String nemecky;
    String nemeckyMinule;
    String pravidelnost;
    static int l = 0; static int p = 0; static int k = 0;
    static String pravid = "Er hat";
    static String nepravid = "Er ist";

    static ArrayList<CelyObjekt> arr = new ArrayList<CelyObjekt>();
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static ArrayList<VBox> arrVbox = new ArrayList<VBox>();
    @Override
    public void start(Stage stage) throws IOException {
        double fontSize = 43;
        Font font2 = Font.font(fontSize);
        //mam pole prazdnych lable
        // ArrayList<Label> napis = new ArrayList<>();
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 15,15);
        pane.setStyle("-fx-background-color: #4bccb1;");
        stage.setTitle("Minulý čas u sloves (Alfa.1.1)");
        VBox vboxHlavni = new VBox();
        pane.getChildren().add(vboxHlavni);
        /*ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(2000, 1000);
        scroll.setContent(vboxHlavni);
        scroll.setStyle("-fx-background-color: #b9a55a;");
        pane.getChildren().add(scroll);

         */
        //textova pole, pro index slovesa a pocetslov
        TextField poradiSlova = new TextField("Index slovesa");
        vboxHlavni.getChildren().addAll(poradiSlova);
        Button dal = new Button("DAL");
        String pozadi =  "-fx-background-color: #b9a55a;" +
                "-fx-border-color: black;" +
                "-fx-border-width: 2;";
        dal.setStyle(pozadi);
        vboxHlavni.getChildren().add(dal);


        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
        HBox hbox3 = new HBox();
        vboxHlavni.getChildren().addAll(hbox1,hbox2,hbox3);


//pridat lable
        File file = new File("data.dat");
        Scanner sc = new Scanner(file);
        for(int i = 0; i<9; i++){
            int poradi = sc.nextInt();
            String cz = sc.next();
            String de = sc.next();
            String deM = sc.next();
            String pr = sc.next();
            arr.add(new CelyObjekt(poradi,cz,de,deM,pr));
        }

        for (int i = 0; i<(4);i++){
            VBox vboxArr = new VBox();
            hbox1.getChildren().add(vboxArr);
            arrVbox.add(vboxArr);
        }
        for (int i = 0; i<(4);i++){
            VBox vboxArr = new VBox();
            hbox2.getChildren().add(vboxArr);
            arrVbox.add(vboxArr);
        }
        for (int i = 0; i<(8);i++){
            VBox vboxArr = new VBox();
            hbox3.getChildren().add(vboxArr);
            arrVbox.add(vboxArr);
        }

        dal.setOnAction(actionEvent -> {
            if(l<5) {
                if (p == 0) {
                    // HBox hbox = new HBox();
                    Label napis = new Label();
                    napis.setFont(font2);
                    napis.setMinWidth(10);
                    napis.setMinHeight(10);
                    napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).cesky));
                    arrVbox.get(l).getChildren().add(napis);
                    //vboxHlavni.getChildren().add(hbox);
                    p++;
                } else if (p == 1) {
                    Label napis = new Label();
                    napis.setMinWidth(10);
                    napis.setMinHeight(10);
                    napis.setFont(font2);
                    napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).nemecky));
                    arrVbox.get(l).getChildren().add(napis);
                    p++;
                } else if (p == 2) {
                    //HBox hbox = new HBox();
                    Label napis = new Label();
                    napis.setMinWidth(10);
                    napis.setMinHeight(10);
                    napis.setFont(font2);
                    napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).nemeckyMinule));
                    arrVbox.get(l).getChildren().add(napis);
                    //vboxHlavni.getChildren().add(hbox);
                    p++;
                } else if (p == 3) {
                    //HBox hbox = new HBox();
                    if (arr.get(Integer.parseInt(poradiSlova.getText())).pravidelnost.equals("N")) {
                        Label napis = new Label();
                        napis.setMinWidth(500);
                        napis.setMinHeight(50);
                        napis.setFont(font2);
                        napis.setText(nepravid + " " + arr.get(Integer.parseInt(poradiSlova.getText())).nemeckyMinule);
                        arrVbox.get(l).getChildren().add(napis);
                        //   vboxHlavni.getChildren().add(hbox);
                    } else {
                        Label napis = new Label();
                        napis.setMinWidth(500);
                        napis.setMinHeight(50);
                        napis.setFont(font2);
                        napis.setText(pravid + " " + arr.get(Integer.parseInt(poradiSlova.getText())).nemeckyMinule);
                        arrVbox.get(l).getChildren().add(napis);
                        //     vboxHlavni.getChildren().add(hbox);
                    }
                    Label ohraniceni = new Label("-------------");
                    arrVbox.get(l).getChildren().add(ohraniceni);
                    p = 0; l++;
                }
            }else if (l<9){
                if (p == 0) {
                    // HBox hbox = new HBox();
                    Label napis = new Label();
                    napis.setFont(font2);
                    napis.setMinWidth(10);
                    napis.setMinHeight(10);
                    napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).cesky));
                    arrVbox.get(l).getChildren().add(napis);
                    //vboxHlavni.getChildren().add(hbox);
                    p++;
                } else if (p == 1) {
                    Label napis = new Label();
                    napis.setMinWidth(10);
                    napis.setMinHeight(10);
                    napis.setFont(font2);
                    napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).nemecky));
                    arrVbox.get(l).getChildren().add(napis);
                    p++;
                } else if (p == 2) {
                    //HBox hbox = new HBox();
                    Label napis = new Label();
                    napis.setMinWidth(10);
                    napis.setMinHeight(10);
                    napis.setFont(font2);
                    napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).nemeckyMinule));
                    arrVbox.get(l).getChildren().add(napis);
                    //vboxHlavni.getChildren().add(hbox);
                    p++;
                } else if (p == 3) {
                    //HBox hbox = new HBox();
                    if (arr.get(Integer.parseInt(poradiSlova.getText())).pravidelnost.equals("N")) {
                        Label napis = new Label();
                        napis.setMinWidth(500);
                        napis.setMinHeight(50);
                        napis.setFont(font2);
                        napis.setText(nepravid + " " + arr.get(Integer.parseInt(poradiSlova.getText())).nemeckyMinule);
                        arrVbox.get(l).getChildren().add(napis);
                        //   vboxHlavni.getChildren().add(hbox);
                    } else {
                        Label napis = new Label();
                        napis.setMinWidth(500);
                        napis.setMinHeight(50);
                        napis.setFont(font2);
                        napis.setText(pravid + " " + arr.get(Integer.parseInt(poradiSlova.getText())).nemeckyMinule);
                        arrVbox.get(l).getChildren().add(napis);
                        //     vboxHlavni.getChildren().add(hbox);
                    }
                    Label ohraniceni = new Label("-------------");
                    arrVbox.get(l).getChildren().add(ohraniceni);
                    p = 0;
                    l++;
                }
            }else {
                if (p == 0) {
                    // HBox hbox = new HBox();
                    Label napis = new Label();
                    napis.setFont(font2);
                    napis.setMinWidth(10);
                    napis.setMinHeight(10);
                    napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).cesky));
                    arrVbox.get(l).getChildren().add(napis);
                    //vboxHlavni.getChildren().add(hbox);
                    p++;
                } else if (p == 1) {
                    Label napis = new Label();
                    napis.setMinWidth(10);
                    napis.setMinHeight(10);
                    napis.setFont(font2);
                    napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).nemecky));
                    arrVbox.get(l).getChildren().add(napis);
                    p++;
                } else if (p == 2) {
                    //HBox hbox = new HBox();
                    Label napis = new Label();
                    napis.setMinWidth(10);
                    napis.setMinHeight(10);
                    napis.setFont(font2);
                    napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).nemeckyMinule));
                    arrVbox.get(l).getChildren().add(napis);
                    //vboxHlavni.getChildren().add(hbox);
                    p++;
                } else if (p == 3) {
                    //HBox hbox = new HBox();
                    if (arr.get(Integer.parseInt(poradiSlova.getText())).pravidelnost.equals("N")) {
                        Label napis = new Label();
                        napis.setMinWidth(500);
                        napis.setMinHeight(50);
                        napis.setFont(font2);
                        napis.setText(nepravid + " " + arr.get(Integer.parseInt(poradiSlova.getText())).nemeckyMinule);
                        arrVbox.get(l).getChildren().add(napis);
                        //   vboxHlavni.getChildren().add(hbox);
                    } else {
                        Label napis = new Label();
                        napis.setMinWidth(500);
                        napis.setMinHeight(50);
                        napis.setFont(font2);
                        napis.setText(pravid + " " + arr.get(Integer.parseInt(poradiSlova.getText())).nemeckyMinule);
                        arrVbox.get(l).getChildren().add(napis);
                        //     vboxHlavni.getChildren().add(hbox);
                    }
                    Label ohraniceni = new Label("-------------");
                    arrVbox.get(l).getChildren().add(ohraniceni);
                    p = 0;
                    l++;
                }
            }
        });

        Scene scene = new Scene(pane, 500, 500);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}