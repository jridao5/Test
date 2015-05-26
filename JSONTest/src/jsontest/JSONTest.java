/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsontest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author thejuandesire
 */
public class JSONTest extends Application {
    
    @Override
    public void start(Stage primaryStage) throws MalformedURLException, UnsupportedEncodingException, IOException 
    {
        File folder = new File("/Users/jridao5/Documents/Test/Movies"); //makes a path to the specified folder
        File[] listOfFiles = folder.listFiles(); //makes an arrayList of file objects
        
        for (File movie:listOfFiles)
        {
            String movieTitle = movie.getName().substring(0,movie.getName().indexOf("(")); //Change this to a title of a movie to test
          
            InputStream input = new URL("http://www.omdbapi.com/?t=" + URLEncoder.encode(movieTitle, "UTF-8")).openStream();
            //String site = new URL("http://www.omdbapi.com/?t=" + URLEncoder.encode(movieTitle, "UTF-8")).toString();
            //System.out.println(site);
            
            Map<String, String> map = new Gson().fromJson(new InputStreamReader(input, "UTF-8"), new TypeToken<Map<String, String>>(){}.getType());

            String title = map.get("Title");
            String released = map.get("Released");
            String runtime = map.get("Runtime");
            String genre = map.get("Genre");
            String actors = map.get("Actors");
            String plot = map.get("Plot");
            String imdbRating = map.get("imdbRating");
            String poster = map.get("Poster");
            printStuff(title, released, runtime, genre, actors, plot, imdbRating, poster);  
        }
        
    }
    
    public void printStuff(String title, String released, String runtime, 
                            String genre, String actors, String plot, String imdbRating, String poster){
        System.out.println("Title: " + title + "\nReleased: " + released + 
                            "\nRuntime: " + runtime + "\nGenre: "+ genre + "\nActors: " + actors +
                            "\nPlot: " + plot + "\nimdbRating: " + imdbRating + "\nPoster: " + poster + "\n");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
