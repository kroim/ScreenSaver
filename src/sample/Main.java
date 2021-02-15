package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;


import java.awt.*;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Application {
    Rectangle rectangle = GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getDefaultScreenDevice().getDefaultConfiguration().getBounds();

    private Circle circle1 = new Circle();
    private Circle circle2 = new Circle();
    private ImagePattern imagePattern1;
    private ImagePattern imagePattern2;
    private Image image1;
    private Image image2;
    private RotateTransition rotateTransition1 = new RotateTransition();
    private RotateTransition rotateTransition2 = new RotateTransition();
    @Override
    public void start(Stage primaryStage) throws Exception{
//        JsonRW jsonRW = new JsonRW();
        PropRW propRw = new PropRW();
        File file1 = new File("image1.png");
        image1 = new Image(file1.toURI().toString());
        imagePattern1 = new ImagePattern(image1);
        circle1.setCenterX((rectangle.width)/2);
        circle1.setCenterY((rectangle.height)/2 - 50);
        circle1.setFill(imagePattern1);
        circle1.setRadius((rectangle.height)/2-50);
        rotateTransition1.setNode(circle1);

        File file2 = new File("image2.png");
        image2 = new Image(file2.toURI().toString());
        imagePattern2 = new ImagePattern(image2);
        circle2.setCenterX((rectangle.width)/2);
        circle2.setCenterY((rectangle.height)/2 - 50);
        circle2.setFill(imagePattern2);
        circle2.setRadius((rectangle.height)/2 - 50);
        rotateTransition2.setNode(circle2);

        Group group = new Group();
        group.getChildren().add(circle1);
        group.getChildren().add(circle2);

        if(propRw.top_on == 1){
            circle1.toFront();
        }else {
            circle2.toFront();
        }
        rotateTransition1.setCycleCount(-1);
        rotateTransition2.setCycleCount(-1);

        rotateTransition1.setByAngle(360);
        rotateTransition2.setByAngle(360);
        rotateTransition1.setInterpolator(Interpolator.LINEAR);
        rotateTransition2.setInterpolator(Interpolator.LINEAR);
        if (propRw.tmp.equals("m")){
            rotateTransition1.setDuration(Duration.minutes(propRw.disk1_speed));
            rotateTransition2.setDuration(Duration.minutes(propRw.disk2_speed));
        }else if(propRw.tmp.equals("h")){
            rotateTransition1.setDuration(Duration.hours(propRw.disk1_speed));
            rotateTransition2.setDuration(Duration.hours(propRw.disk2_speed));
        }else {
            rotateTransition1.setDuration(Duration.minutes(propRw.disk1_speed));
            rotateTransition2.setDuration(Duration.minutes(propRw.disk2_speed));
        }
        rotateTransition1.setFromAngle(propRw.disk1_an);
        rotateTransition2.setFromAngle(propRw.disk2_an);
        rotateTransition1.play();
        rotateTransition2.play();


        Scene mainScene = new Scene(group, rectangle.width, rectangle.height);
        mainScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ESCAPE){
                    System.exit(1);
                }
            }
        });
        primaryStage.setScene(mainScene);
//        primaryStage.setFullScreen(true);
        primaryStage.setMaximized(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.show();

        propRw.angle_thread.start();
    }

    public static void main(String[] args) {
        launch(args);
        System.exit(1);
    }
}
