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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
/**
 *z
 * @author jvravic5
 */
public class ImageLayout extends Application {
    private ImageView image1,image2,image3,image4,image5,image6,image7,image8;
    private Object context;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JAFLIX");
       ScrollPane scrollPane = new ScrollPane();
        GridPane gridpane = new GridPane();
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setPrefSize(500, 500);
        scrollPane.setContent(gridpane);
        Scene scene = new Scene(scrollPane);

      image1= new ImageView(new Image(ImageLayout.class.getResourceAsStream("images/The Dark Knight copy.jpg"),400,200,true, false));
      image2= new ImageView(new Image(ImageLayout.class.getResourceAsStream("images/The Dark Knight Rises copy.jpg"),400,200,true, false));
      image3= new ImageView(new Image(ImageLayout.class.getResourceAsStream("images/The Fault in Our Stars copy.jpg"),400,200,true, false));
      image4= new ImageView(new Image(ImageLayout.class.getResourceAsStream("images/The LEGO Movie Videogame copy.jpg"),400,200,true, false));
      image5= new ImageView(new Image(ImageLayout.class.getResourceAsStream("images/The Lion King copy.jpg"),400,200,true, false));
      image6= new ImageView(new Image(ImageLayout.class.getResourceAsStream("images/Toy Story 2 copy.jpg"),400,200,true, false));
      image7= new ImageView(new Image(ImageLayout.class.getResourceAsStream("images/Toy Story 3 copy.jpg"),400,200,true, false));
      image8= new ImageView(new Image(ImageLayout.class.getResourceAsStream("images/Toy Story copy.jpg"),400,200,true, false));
      
      gridpane.setPrefSize(100, 100);
   gridpane.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                    Pane root = new Pane();
                    gridpane.add(image1,1,1);
                    gridpane.add(image2,2,1);
                    gridpane.add(image3,3,1);
                    gridpane.add(image4,4,1);
                    gridpane.add(image5,1,2);
                    gridpane.add(image6,2,2);
                    gridpane.add(image7,3,2);
                    gridpane.add(image8,4,2);
                    //gridpane.setAlignment(Pos.CENTER);
        gridpane.setPadding(new Insets(50, 50, 50, 50));

        gridpane.setHgap(50);
        gridpane.setVgap(50);
       
      

                    primaryStage.setScene(new Scene(gridpane, 300, 250));
                    primaryStage.setResizable(true);
                    primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
