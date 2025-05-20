package com.example.sim;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.InputStream;
import java.sql.Time;

import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.animation.KeyFrame;


public class HelloController {
    @FXML
    private Label hungerLabel;
    @FXML
    private Label happinessLabel;
    @FXML
    private Image Image_Center_Image;
    @FXML
    private Button Play;
    @FXML
    private Pane Animal_Img;
    @FXML
    private VBox Buttons;
    @FXML
    private ImageView Center_Image;
    @FXML
    private Button ButtonGen;
    @FXML
    private Button Feed;
    private int i;
    public void initialize(){
      Timeline timeline = new Timeline(
              new KeyFrame(Duration.seconds(1), event -> {
                  updateStats();
              })
     );
      timeline.setCycleCount(Timeline.INDEFINITE);
      timeline.play();
   }
    private void updateStats() {
        if (Petone.getHunger() > 0) {
            Petone.setHunger(Petone.getHunger() - 1);
        }
        if (Petone.getHappiness() > 0) {
            Petone.setHappiness(Petone.getHappiness() - 1); // Decrease happiness by 1
        }

        happinessLabel.setText("Happiness: " + Petone.getHappiness());
        hungerLabel.setText("Hunger: " + Petone.getHunger());

        if (Petone.getHunger() <= 0 || Petone.getHappiness() <= 0) {
            Image sadUop = new Image(getClass().getResource("/com/example/sim/images/UopSad.png").toExternalForm());
            Center_Image.setImage(sadUop);
        } else {
            Image HapUop = new Image(getClass().getResource("/com/example/sim/images/UopHappy.png").toExternalForm());
            Center_Image.setImage(HapUop);
        }

        if (Petone.getHunger() <= 0 || Petone.getHappiness() <= 0) {
            i=i+1;
            System.out.print(i);
            if (i > 9) {
                Image GoneUop = new Image(getClass().getResource("/com/example/sim/images/UopGone.png").toExternalForm());
                Center_Image.setImage(GoneUop);
            }
        }
    }
    private Image sadUop;
    private Image HapUop;
    private Uop Petone;

    @FXML
    protected void GenerateUopClick() {
        Petone = new Uop();
        Petone.setHappiness(20);
        Petone.setHunger(20);
        ButtonGen.setVisible(false);
        Feed.setVisible(true);
        Play.setVisible(true);
        Center_Image.setVisible(true);
        initialize();
    }

    @FXML
    public void petclick() {
        int Hap =Petone.petPlay();
    }

    @FXML
    public void feedClick() {
        int hungerOne = Petone.feed();
        }

}
