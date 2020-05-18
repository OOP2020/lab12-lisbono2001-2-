package converter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Application distance converter with graphical interface using JavaFX.
 * @author theetouchkasemarnontana  
 *
 */
public class ConverterApp extends javafx.application.Application {
	@Override
	public void start(Stage stage) {
		Pane root = initComponents();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.sizeToScene(); // optional, doesn't always work 
		stage.setTitle("Converter App");
		stage.show();
	}

/** initialize components for the scene graph to display. */ 
	private Pane initComponents() {
		FlowPane pane = new FlowPane(); 
		pane.setPadding(new Insets(16));
		pane.setVgap(10);
		pane.setHgap(10);
		// create and add components
		TextField numberField1 = new TextField();
		TextField numberField2 = new TextField();
		numberField2.setEditable(false);
		
		ComboBox<Length> unitbox1 = new ComboBox<Length>(); 
		unitbox1.getItems().addAll(Length.values());
		unitbox1.setValue(Length.Kilometer);
		Length unit1 = unitbox1.getValue();
		
		ComboBox<Length> unitbox2 = new ComboBox<Length>(); 
		unitbox2.getItems().addAll(Length.values());
		unitbox2.setValue(Length.Mile);
		Length unit2 = unitbox2.getValue();

		Button convertButton = new Button("Convert!");
		//use annonymous class for convert-button events
		convertButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent evt) {
				try {
					String input = numberField1.getText().trim();
					double amount = Double.parseDouble(input); 
					Length fromUnit = unitbox1.getValue();
					double result = fromUnit.convert(amount,fromUnit);
					
					Length toUnit = unitbox2.getValue();
					numberField2.setText(String.format("%.3f",toUnit.convertTo(result,toUnit)));
					numberField2.setStyle("-fx-text-inner-color: green;");
				}
				catch (Exception e) {
					numberField2.setText("Error, please input number!");
					numberField2.setStyle("-fx-text-inner-color: red;");
				}
			}
		});
		
		Button clearButton = new Button("Clear");
		//use annonymous class for clear-button events
		clearButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				numberField1.clear();
				numberField2.clear();
			}
		});

		pane.getChildren().addAll(numberField1, unitbox1, numberField2, unitbox2, convertButton, clearButton); 
		return pane;
	}

	/**
	 * run the application
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}