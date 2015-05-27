/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsontest;

//JSON Imports
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

//downloadImage() imports
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
        File folder = new File("/Users/thejuandesire/Documents/Rafael/Test/Movies"); //makes a path to the specified folder
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
            downloadImage(title, poster);
            
        }
        
    }
    
    public void printStuff(String title, String released, String runtime, 
                            String genre, String actors, String plot, String imdbRating, String poster)
    {
        System.out.println("Title: " + title + "\nReleased: " + released + 
                            "\nRuntime: " + runtime + "\nGenre: "+ genre + "\nActors: " + actors +
                            "\nPlot: " + plot + "\nimdbRating: " + imdbRating + "\n");
    }

    public void downloadImage(String name, String link) throws MalformedURLException, IOException 
    {
        URL url = new URL(link);
        ByteArrayOutputStream out;
        try (BufferedInputStream in = new BufferedInputStream(url.openStream())) {
            out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1!=(n=in.read(buf)))
            {
                out.write(buf, 0, n);
            }
            out.close();
        }
        byte[] response = out.toByteArray();

        String location = "/Users/thejuandesire/Documents/Rafael/Posters/" + name + ".jpg";
        File image = new File(location);
        
        try (FileOutputStream fos = new FileOutputStream(image))
        {
            fos.write(response);
            fos.flush();
            fos.close();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
