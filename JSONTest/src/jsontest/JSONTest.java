/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsontest;

//JSON Imports
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

//downloadImage() imports
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//other imports
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
/**
 *
 * @author thejuandesire
 */
public class JSONTest extends Application {
    
    @Override
<<<<<<< HEAD
    public void start(Stage primaryStage) throws MalformedURLException, UnsupportedEncodingException, IOException 
    {
        File folder = new File("/Users/jvravic5/Test/Movies"); //makes a path to the specified folder
        File[] listOfFiles = folder.listFiles(); //makes an arrayList of file objects
=======
    public void start(Stage primaryStage) throws UnsupportedEncodingException, IOException  {
>>>>>>> ea41f4fdac7a89503a9f56e759cda3628a84185d
        
        ArrayList<Movie> movieList = new ArrayList<>();
        
        File folder = new File("/Users/thejuandesire/Documents/Rafael/Test/Movies"); //makes a path to the specified folder
        File[] listOfFiles = folder.listFiles(); //makes an array of File objects
        
        for (File movie:listOfFiles) {
            Map<String, String> database = queryDatabase(movie);
            String title = database.get("Title");
            String released = database.get("Released");
            String runtime = database.get("Runtime");
            String genre = database.get("Genre");
            String actors = database.get("Actors");
            String plot = database.get("Plot");
            String imdbRating = database.get("imdbRating");
            String poster = database.get("Poster");
            
            String content = createString(title, released, runtime, genre, actors, plot, imdbRating, poster); //createTextFile(title, content);
            BufferedImage picture = downloadImage(title, poster);
            
            movieList.add(new Movie(picture, content));
        }
        System.out.println(movieList.get(4).getDescription());
    }

    /**
     *
     * @param movie
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    public Map<String, String> queryDatabase(File movie) throws MalformedURLException, IOException {
        String movieTitle = movie.getName().substring(0,movie.getName().indexOf("(")); //Change this to a title of a movie to test
        InputStream input = new URL("http://www.omdbapi.com/?t=" + URLEncoder.encode(movieTitle, "UTF-8")).openStream();
        Map<String, String> map = new Gson().fromJson(new InputStreamReader(input, "UTF-8"), new TypeToken<Map<String, String>>(){}.getType());
        return map;
    }
    
    /**
     *
     * @param name
     * @param link
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    public BufferedImage downloadImage(String name, String link) throws MalformedURLException, IOException 
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

<<<<<<< HEAD
        String location = "/Users/jvravic5/Test/ImageLayout/src/imagelayout/images/" + name + ".jpg";
=======
        String location = "/Users/thejuandesire/Documents/Rafael/Posters/" + name + ".jpg";
>>>>>>> ea41f4fdac7a89503a9f56e759cda3628a84185d
        File image = new File(location);
        
        try (FileOutputStream fos = new FileOutputStream(image))
        {
            fos.write(response);
            fos.flush();
            fos.close();
        }
        
        return ImageIO.read(new File(location));
    }
    
    public String createString(String title, String released, String runtime, 
                            String genre, String actors, String plot, String imdbRating, String poster)
    {
        String content = "Title: " + title + "\nReleased: " + released + 
                            "\nRuntime: " + runtime + "\nGenre: "+ genre + "\nActors: " + actors +
                            "\nPlot: " + plot + "\nimdbRating: " + imdbRating + "\n";
        return content;
    }
    
    
    
    /*public void createTextFile(String name, String message)
    {
        try 
        {
            String location = "/Users/thejuandesire/Documents/Rafael/Descriptions/" + name;
            File file = new File(location);

            // if file doesnt exists, then create it
            if (!file.exists()) 
            {
                file.createNewFile();
            }
 
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            
            try (BufferedWriter bw = new BufferedWriter(fw)) 
            {
                bw.write(message);
            }
 
            System.out.println("Done");
 
        } 
        catch (IOException e) {}
    }*/
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
