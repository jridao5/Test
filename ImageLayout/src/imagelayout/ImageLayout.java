/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagelayout;

import java.io.IOException;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * z
 *
 * @author jvravic5
 */
public class ImageLayout extends Application {

    private ImageView image1, image2;
    private Object context;

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("JAFLIX");
        ScrollPane scrollPane = new ScrollPane();
        GridPane gridpane = new GridPane();
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setPrefSize(500, 500);
        scrollPane.setContent(gridpane);
        Scene scene = new Scene(scrollPane);
        
        ArrayList<Movie> movieList = Movie.createArrayList();
        
        int index = 0;
        for (int col = 1; col <= movieList.size(); col++){
                String title = movieList.get(index).getTitle(index);
                String location = "images/" + title + ".jpg";
                //System.out.println(location);
                ImageView poster = new ImageView(new Image(ImageLayout.class.getResourceAsStream(location), 400, 200, true, false));
                //ImageView poster = new ImageView(new Image(ImageLayout.class.getResourceAsStream("images/Batman Begins.jpg"), 400, 200, true, false));
                poster.addEventFilter(MouseEvent.MOUSE_PRESSED, new PosterClickHandler());
                gridpane.add(poster, col, 1);
                index++;
        }
       
        //image1 = new ImageView(new Image(ImageLayout.class.getResourceAsStream("images/Batman Begins.jpg"), 400, 200, true, false));
        //image2 = new ImageView(new Image(ImageLayout.class.getResourceAsStream("images/Batman_Begins_Poster.jpg"), 400, 200, true, false));

        //image2.addEventFilter(MouseEvent.MOUSE_PRESSED, new PosterClickHandler());
        //image1.addEventFilter(MouseEvent.MOUSE_PRESSED, new PosterClickHandler());
        Pane root = new Pane();
        //gridpane.add(image1, 1, 1);
        //gridpane.add(image2, 2, 1);
        //gridpane.setAlignment(Pos.CENTER);
        gridpane.setPadding(new Insets(50, 50, 50, 50));

        gridpane.setHgap(200);
        gridpane.setVgap(50);

        primaryStage.setScene(new Scene(gridpane, 300, 250));
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    private class PosterClickHandler implements EventHandler {

        @Override
        public void handle(Event e) {
            Stage stage = new Stage();
            Scene scene = new Scene(new Group(new Text(250, 100, e.getSource().toString())));
            stage.setScene(scene);
            stage.sizeToScene();
            stage.show();

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
