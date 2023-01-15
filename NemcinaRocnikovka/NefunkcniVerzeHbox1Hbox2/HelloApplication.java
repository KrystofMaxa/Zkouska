package com.example.rocnikovkanemcina;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
    @Override
    public void start(Stage stage) throws IOException {
        double fontSize = 43;
        Font font2 = Font.font(fontSize);
        //mam pole prazdnych lable
        // ArrayList<Label> napis = new ArrayList<>();
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 15,15);

        stage.setTitle("Hello!");
        VBox vbox = new VBox();
        pane.getChildren().add(vbox);

        HBox hbox1 = new HBox();
        vbox.getChildren().add(hbox1);
        HBox hbox2 = new HBox();
        vbox.getChildren().add(hbox2);
        VBox[] vboxPole = new VBox[7];
/*
        for (int i = 0; i<4; i++){
            hbox1.getChildren().add(vboxPole[i]);
        }
        for (int i = 4; i<8;i++){
            hbox2.getChildren().add(vboxPole[i]);
        }
        
 */
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
        for(int i = 0; i<9; i++){
            int poradi = sc.nextInt();
            String cz = sc.next();
            String de = sc.next();
            String deM = sc.next();
            String pr = sc.next();
            arr.add(new CelyObjekt(poradi,cz,de,deM,pr));
        }
        dal.setOnAction(actionEvent -> {
          if(l<4) {
              if (p == 0) {
                  // HBox hbox = new HBox();
                  Label napis = new Label();
                  napis.setFont(font2);
                  napis.setMinWidth(10);
                  napis.setMinHeight(10);
                  napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).cesky));
                  vboxPole[l].getChildren().add(napis);
                  //vbox.getChildren().add(hbox);
                  p++;
              } else if (p == 1) {
                  Label napis = new Label();
                  napis.setMinWidth(10);
                  napis.setMinHeight(10);
                  napis.setFont(font2);
                  napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).nemecky));
                  vboxPole[l].getChildren().add(napis);
                  p++;
              } else if (p == 2) {
                  //HBox hbox = new HBox();
                  Label napis = new Label();
                  napis.setMinWidth(10);
                  napis.setMinHeight(10);
                  napis.setFont(font2);
                  napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).nemeckyMinule));
                  vboxPole[l].getChildren().add(napis);
                  //vbox.getChildren().add(hbox);
                  p++;
              } else if (p == 3) {
                  //HBox hbox = new HBox();
                  if (arr.get(Integer.parseInt(poradiSlova.getText())).pravidelnost.equals("N")) {
                      Label napis = new Label();
                      napis.setMinWidth(10);
                      napis.setMinHeight(10);
                      napis.setFont(font2);
                      napis.setText(nepravid + " " + arr.get(Integer.parseInt(poradiSlova.getText())).nemeckyMinule);
                      vboxPole[l].getChildren().add(napis);
                      //   vbox.getChildren().add(hbox);
                  } else {
                      Label napis = new Label();
                      napis.setMinWidth(10);
                      napis.setMinHeight(10);
                      napis.setFont(font2);
                      napis.setText(pravid + " " + arr.get(Integer.parseInt(poradiSlova.getText())).nemeckyMinule);
                      vboxPole[l].getChildren().add(napis);
                      //     vbox.getChildren().add(hbox);
                  }
                  Label ohraniceni = new Label("-------------");
                  vboxPole[l].getChildren().add(ohraniceni);
                  p = 0; l++;
              }
          }else {
              if (p == 0) {
                  // HBox hbox = new HBox();
                  Label napis = new Label();
                  napis.setFont(font2);
                  napis.setMinWidth(10);
                  napis.setMinHeight(10);
                  napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).cesky));
                  vboxPole[l].getChildren().add(napis);
                  //vbox.getChildren().add(hbox);
                  p++;
              } else if (p == 1) {
                  Label napis = new Label();
                  napis.setMinWidth(10);
                  napis.setMinHeight(10);
                  napis.setFont(font2);
                  napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).nemecky));
                  vboxPole[l].getChildren().add(napis);
                  p++;
              } else if (p == 2) {
                  //HBox hbox = new HBox();
                  Label napis = new Label();
                  napis.setMinWidth(10);
                  napis.setMinHeight(10);
                  napis.setFont(font2);
                  napis.setText((arr.get(Integer.parseInt(poradiSlova.getText())).nemeckyMinule));
                  vboxPole[l].getChildren().add(napis);
                  //vbox.getChildren().add(hbox);
                  p++;
              } else if (p == 3) {
                  //HBox hbox = new HBox();
                  if (arr.get(Integer.parseInt(poradiSlova.getText())).pravidelnost.equals("N")) {
                      Label napis = new Label();
                      napis.setMinWidth(10);
                      napis.setMinHeight(10);
                      napis.setFont(font2);
                      napis.setText(nepravid + " " + arr.get(Integer.parseInt(poradiSlova.getText())).nemeckyMinule);
                      vboxPole[l].getChildren().add(napis);
                      //   vbox.getChildren().add(hbox);
                  } else {
                      Label napis = new Label();
                      napis.setMinWidth(10);
                      napis.setMinHeight(10);
                      napis.setFont(font2);
                      napis.setText(pravid + " " + arr.get(Integer.parseInt(poradiSlova.getText())).nemeckyMinule);
                      vboxPole[l].getChildren().add(napis);
                      //     vbox.getChildren().add(hbox);
                  }
                  Label ohraniceni = new Label("-------------");
                  vboxPole[l].getChildren().add(ohraniceni);
                  p = 0;
                  l++;
              }
          } });
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}