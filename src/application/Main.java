package application;
	
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage){
		try {
			
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/FinalProjectView.fxml"));
			Scene scene = new Scene(root,800,600);
			FinalProjectController.applicationStage = primaryStage;

			primaryStage.setScene(scene);
			primaryStage.setTitle("Inventory Management System");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		boolean loadInventory = true;
		while (loadInventory) {
			try {
				Path inventoryFile = Paths.get("inventory");
				BufferedReader reader = Files.newBufferedReader(inventoryFile);
				String line = reader.readLine();
				while (line != null) {
					String[] attributes = line.split(",");
					if (Inventory.checkItemValidity(attributes[0], attributes[1], attributes[2], attributes[3], attributes[4])) {
	    				Inventory.addToInventory(attributes[0], attributes[1], attributes[2], attributes[3], attributes[4]);
					}
					line = reader.readLine();
				}
				loadInventory = false;
			} catch(IOException ioe) {
				System.out.println("Not loaded properly");
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
