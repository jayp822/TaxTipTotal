// Create a JavaFX application that lets the user 
// enter the food charge for a meal at a restaurant. 
// When a button is clicked, the application should 
// calculate and display the amount of an 18 percent tip 
// on the total food charge, 7 percent sales tax, and the 
// total of all three amounts.

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.geometry.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class TaxTipTotal extends Application{

   private Label foodLabel;
   private TextField foodTextField;
   private Button calculate;
   private Label resultLabel;
   
   public static void main(String[] args)
   {
      launch(args);
   }


   public void start(Stage s)
   {
      foodLabel = new Label("Enter  your  food  charge  for  the  meal:  ");
      foodTextField = new TextField();
      calculate = new Button("Calculate");
      
      calculate.setOnAction(
         event -> {
         
         
         //Get tip
            double tip = Double.parseDouble(foodTextField.getText()) * .18 ; 
         
         //Get salesTax
            double salesTax = Double.parseDouble(foodTextField.getText()) * .07;
         
         //Get total
            double total = Double.parseDouble(foodTextField.getText()) + salesTax + tip;
            
            resultLabel.setText(String.format("Your total is %.2f dollars including an 18 percent tip and 7 percent tax", total));
         
         }
         );
      
      resultLabel = new Label();
      
      
      HBox hb = new HBox(10,foodLabel, foodTextField, calculate);
      VBox vb = new VBox(10, hb, calculate, resultLabel);
      
      hb.setPadding(new Insets(10));
      vb.setPadding(new Insets(10));
      hb.setAlignment(Pos.CENTER);
      vb.setAlignment(Pos.CENTER);
      
   
   
      Scene scene = new Scene(vb, 500, 300);
      
      s.setScene(scene);
      s.setTitle("Tax Tip Total");
      s.show();
   }
   
   
   
   

}