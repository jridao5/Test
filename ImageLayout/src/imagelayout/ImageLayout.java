/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagelayout;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 *z
 * @author jvravic5
 */
public class ImageLayout extends Application {
    private ImageView image1,image2;
    private Object context;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("RAFLIX");
       ScrollPane scrollPane = new ScrollPane();
        GridPane gridpane = new GridPane();
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setPrefSize(500, 500);
        scrollPane.setContent(gridpane);
        Scene scene = new Scene(scrollPane);
  

      image1= new ImageView(new Image(ImageLayout.class.getResourceAsStream("images/Batman_&_robin_poster.jpg"),200,100,true, false));
      image2= new ImageView(new Image(ImageLayout.class.getResourceAsStream("images/Batman_Begins_poster.jpg"),200,100,true, false));
     

                    Pane root = new Pane();
                   root.getChildren().add(image1);
                    root.getChildren().add(image2);
                    gridpane.setAlignment(Pos.CENTER);
        gridpane.setPadding(new Insets(50, 50, 50, 50));

        gridpane.setHgap(50);
        gridpane.setVgap(50);
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
