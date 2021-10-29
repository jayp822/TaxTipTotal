// I used JavaFX to create a Tip + Total + Tax calculator for a resturant meal
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
   private Label tipLabel;
   private TextField tipTextField;
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
      tipLabel = new Label("Enter the percentage of tip you want to give (18 percent = .18): ");
      tipTextField = new TextField();
      calculate = new Button("Calculate");
      
      calculate.setOnAction(
         event -> {
         
         
         //Get tip
            double tip = Double.parseDouble(foodTextField.getText()) * Double.parseDouble(tipTextField.getText()) ; 
         
         //Get salesTax
            double salesTax = Double.parseDouble(foodTextField.getText()) * .07;
         
         //Get total
            double total = Double.parseDouble(foodTextField.getText()) + salesTax + tip;
            
            resultLabel.setText(String.format("Your total is %.2f dollars including a %.2f percent tip and 7 percent tax", total,tip));
         
         }
         );
      
      resultLabel = new Label();
      
      
      HBox hb = new HBox(20,foodLabel, foodTextField, tipLabel, tipTextField, calculate);
      VBox vb = new VBox(10, hb, calculate, resultLabel);
      
      hb.setPadding(new Insets(10));
      vb.setPadding(new Insets(10));
      hb.setAlignment(Pos.CENTER);
      vb.setAlignment(Pos.CENTER);
      
   
   
      Scene scene = new Scene(vb, 1000, 300);
      
      s.setScene(scene);
      s.setTitle("Tax Tip Total");
      s.show();
   }
   
   
   
   

}
