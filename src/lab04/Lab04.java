/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Github link: https://github.com/Merrick-Vanier/Programming3-Lab04/tree/master/src/lab04
 * @author 6237800
 */
public class Lab04 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start (Stage stage) {
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(25, 25, 25, 25));
        gp.setVgap(10);
        gp.setHgap(10);
        bp.setCenter(gp);
        
        //Labels and TextFields
        Label tripDays = new Label("Enter the number of days on the trip");
        gp.add(tripDays, 0, 0);
        
        TextField userTripDays = new TextField("0.00");
        gp.add(userTripDays, 1, 0);

        Label airfare = new Label("Enter the amount paid for flight");
        gp.add(airfare, 0, 1);
        
        TextField userAirfare = new TextField();
        gp.add(userAirfare, 1, 1);
        
        Label carRental = new Label("Enter the amount paid for rental car");
        gp.add(carRental, 0, 2);
        
        TextField userCarRental = new TextField();
        gp.add(userCarRental, 1, 2);
        
        Label miles = new Label("Enter the number of miles driven");
        gp.add(miles, 0, 3);
        
        TextField userMiles = new TextField();
        gp.add(userMiles, 1, 3);
        
        Label parkingFees = new Label("Enter the amount paid for parking");
        gp.add(parkingFees, 0, 4);
        
        TextField userParkingFees = new TextField();
        gp.add(userParkingFees, 1, 4);
        
        Label taxiCharges = new Label("Enter the amount paid for taxis");
        gp.add(taxiCharges, 0, 5);
        
        TextField userTaxiCharges = new TextField();
        gp.add(userTaxiCharges, 1, 5);
        
        Label registration = new Label("Enter the amount paid for registration fees");
        gp.add(registration, 0, 6);
        
        TextField userRegistration = new TextField();
        gp.add(userRegistration, 1, 6);
        
        Label lodging = new Label("Enter the amount paid for lodging each day");
        gp.add(lodging, 0, 7);
        
        TextField userLodging = new TextField();
        gp.add(userLodging, 1, 7);
        
        userTripDays.setOnKeyTyped(e -> {
            userTripDays.setText(checkText(userTripDays.getText()));
            userTripDays.positionCaret(userTripDays.getText().length());
//            if(!Character.isDigit(userTripDays.getText().charAt(userTripDays.getText().length() - 1)) && '.' != userTripDays.getText().charAt(userTripDays.getText().length() - 1)) {
//                userTripDays.setText(userTripDays.getText().substring(0, userTripDays.getText().length() - 1));
//                userTripDays.positionCaret(userTripDays.getText().length());
//            }
        });
        
        Button b1 = new Button("Calculate");
        
        
        Scene s = new Scene(bp);
        stage.setScene(s);
        stage.show();
    }
    
    public String checkText(String tf) {
        for (int i = 0; i < tf.length(); i++) {
            if(!Character.isDigit(tf.charAt(i))) {
                tf = tf.substring(0, i) + tf.substring(i + 1, tf.length());
            }
        }
        
        boolean leadingZero = true;
        while (leadingZero == true) {
            if (tf.isEmpty()) {
                leadingZero = false;
            }
            else if(tf.charAt(0) == '0') {
                tf = tf.substring(1, tf.length());
            }
            else {
                leadingZero = false;
            }
        }
        
        if (tf.isEmpty()) {
            tf = "0.00";
        }
        else if(tf.length() < 2) {
            tf = "0.0" + tf;
        }
        else if(tf.length() < 3) {
            tf = "0." + tf;
        }
        else {
            tf = tf.substring(0, tf.length() - 2) + "." + tf.substring(tf.length() - 2);
        }
        
        return(tf);
    }
    
}
