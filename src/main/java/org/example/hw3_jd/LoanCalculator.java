package org.example.hw3_jd;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoanCalculator extends Application {

    public void start(Stage primaryStage)
    {
        Scene scene = new Scene(new LoanPane(), 300, 150);
        primaryStage.setTitle("LoanCalculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
