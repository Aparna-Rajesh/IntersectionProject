package IntersectionRedone;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * the purpose of this class is to handle the user input for the calculations for the intersection model
 * @author aparna
 * @version 1.0
 */

public class UserInputPretty extends Application {
    private double greenTime = 0.0;
    private double yellowTime = 0.0;
    private double redTime = 0.0;
    private double bufferTime = 0.0;
    Button myButton1;


    /**
     * sets the stage
     * @param myStage the stage in which the parameter values are entered
     */
    public void start(Stage myStage) {
        Calculations calc = new Calculations();


        myStage.setTitle("Intersection Project");
        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets((30)));
        rootNode.setHgap(5);
        rootNode.setVgap(5);

        Scene myScene = new Scene(rootNode, 500, 500);
        rootNode.setAlignment(Pos.CENTER);


        //SPEED LIMIT
        TextField speedLimit = new TextField();
        rootNode.add(new Label("Speed Limit (m/s): "), 0, 0);
        speedLimit.setPromptText("45");
        rootNode.add(speedLimit, 1, 0);


        //REACTION TIME
        rootNode.add(new Label("Reaction Time (s): "), 0, 1);
        TextField reactionTime = new TextField();
        reactionTime.setPromptText("0.25");
        //middleInitial.setPrefColumnCount(1);
        rootNode.add(reactionTime, 1, 1);


        //SPEEDING ACCEL
        TextField speedAccel = new TextField();
        rootNode.add(new Label("Speeding Acceleration (m/s^2): "), 0, 2);
        rootNode.add(speedAccel, 1, 2);

        //BRAKING ACCEL
        TextField brakeAccel = new TextField();
        rootNode.add(new Label("Braking Acceleration (m/s^2): "), 0, 3);
        rootNode.add(brakeAccel, 1, 3);


        //CAR LENGTH
        TextField carLength = new TextField();
        rootNode.add(new Label("Car Length (m): "), 0, 4);
        carLength.setPromptText("4.55");
        rootNode.add(carLength, 1, 4);


        //GAP
        TextField gap = new TextField();
        rootNode.add(new Label("Gap Distance Between the Cars (m): "), 0, 5);
        rootNode.add(gap, 1, 5);


        //NUMBER OF CARS
        TextField noCar = new TextField();
        rootNode.add(new Label("Number of Cars Stopped at Red: "), 0, 6);
        rootNode.add(noCar, 1, 6);


        //INT LENGTH
        TextField intLength = new TextField();
        rootNode.add(new Label("Length of the Intersection (m): "), 0, 7);
        rootNode.add(intLength, 1, 7);


        myButton1 = new Button("Calculate");
        rootNode.add(myButton1, 1, 8);

        //GREEN
        rootNode.add(new Label("Green Time (seconds): "), 0, 9);

        //YELLOW
        rootNode.add(new Label("Yellow Time (seconds): "), 0, 10);

        //RED
        rootNode.add(new Label("Red Time (seconds): "), 0, 11);

        //BUFFER
        rootNode.add(new Label("Buffer Time (seconds): "), 0, 12);

        myStage.setScene(myScene);
        myStage.show();


        myButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                //set the speed limit
                double speedL = Double.parseDouble(speedLimit.getText());
                calc.setTheSpeedLimit(speedL);

                //set the reaction time
                double react = Double.parseDouble(reactionTime.getText()); //reaction time, as it is entered, is a String
                calc.setUserReactionTime(react);

                //set the accel speed
                double spAc = Double.parseDouble(speedAccel.getText());
                calc.setAccelToSpeed(spAc);

                //set the brake speed
                double brakeSp = Double.parseDouble(brakeAccel.getText());
                calc.setAccelToBrake(brakeSp);

                //set the car length
                double carL = Double.parseDouble(carLength.getText());
                calc.setAvgLengthCar(carL);

                //set the gap
                double gapppp = Double.parseDouble(gap.getText());
                calc.setGapBetweenCars(gapppp);

                //set no of cars
                int noOfCars = Integer.parseInt(noCar.getText());
                calc.setNumberCarsWhileStopped(noOfCars);

                double intL = Double.parseDouble(intLength.getText());
                calc.setLengthIntersec(intL);


                //Add Green time
                greenTime = calc.calculateGreen();
                String greenTimeString = Double.toString(greenTime);
                rootNode.add(new Label(greenTimeString), 1, 9); //add the label of green time

                //Add yellow time
                yellowTime = calc.calculateYellow();
                String yellowTimeString = Double.toString(yellowTime);
                rootNode.add(new Label(yellowTimeString), 1, 10); //add the label of yellow time

                //Add red time
                redTime = calc.calculateRed();
                String redTimeString = Double.toString(redTime);
                rootNode.add(new Label(redTimeString), 1, 11); //add the label of red time

                //Add buffer time
                bufferTime = calc.calculateBuffer();
                String bufferString = Double.toString(bufferTime);
                rootNode.add(new Label(bufferString), 1, 12); //add the label of red time

                myStage.setScene(myScene);
                myStage.show();


            }
        });

    }
}
