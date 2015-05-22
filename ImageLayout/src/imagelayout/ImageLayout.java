/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagelayout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author jvravic5
 */
public class ImageLayout extends Application {
    private ImageView image1;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        
       image1= new ImageView(new Image(ImageLayout.class.getResourceAsStream("images/Batman_&_robin_poster.jpg")));
       image1.resize(20, 10);
       
                    Pane root = new Pane();
                    root.getChildren().add(image1);
                    primaryStage.setScene(new Scene(root, 300, 250));
                    primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
