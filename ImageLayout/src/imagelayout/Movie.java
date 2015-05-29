/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagelayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author thejuandesire
 */
public class Movie {

    private String description;
    private BufferedImage poster;
    
    public Movie(BufferedImage picture, String content) {
        poster = picture;
        description = content;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return
     */
    public BufferedImage getImage() {
        return poster;
    }

    public static ArrayList<Movie> createArrayList() throws IOException {
        ArrayList<Movie> list = new ArrayList<>();

        File folder = new File("/Users/thejuandesire/Desktop/Test/Movies"); //makes a path to the specified folder
        File[] listOfFiles = folder.listFiles(); //makes an array of File objects

        for (File movie : listOfFiles) {
            Map<String, String> database = queryDatabase(movie);
            String title = database.get("Title");
            String released = database.get("Released");
            String runtime = database.get("Runtime");
            String genre = database.get("Genre");
            String actors = database.get("Actors");
            String plot = database.get("Plot");
            String imdbRating = database.get("imdbRating");
            String poster = database.get("Poster");

            String content = createString(title, released, runtime, genre, actors, plot, imdbRating, poster);
            BufferedImage picture = downloadImage(title, poster);

            list.add(new Movie(picture, content));
        }
        
        return list;
    }

    public static String getTitle(int index) throws IOException{
        File folder = new File("/Users/thejuandesire/Desktop/Test/Movies"); //makes a path to the specified folder
        File[] listOfFiles = folder.listFiles(); //makes an array of File objects
        Map<String, String> database = queryDatabase(listOfFiles[index]);
        return database.get("Title");
    }
    
    public static Map<String, String> queryDatabase(File movie) throws MalformedURLException, IOException {
        String movieTitle = movie.getName().substring(0, movie.getName().indexOf("(")); //Change this to a title of a movie to test
        InputStream input = new URL("http://www.omdbapi.com/?t=" + URLEncoder.encode(movieTitle, "UTF-8")).openStream();
        Map<String, String> map = new Gson().fromJson(new InputStreamReader(input, "UTF-8"), new TypeToken<Map<String, String>>() {
        }.getType());
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
    public static BufferedImage downloadImage(String name, String link) throws MalformedURLException, IOException {
        URL url = new URL(link);
        ByteArrayOutputStream out;
        try (BufferedInputStream in = new BufferedInputStream(url.openStream())) {
            out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1 != (n = in.read(buf))) {
                out.write(buf, 0, n);
            }
            out.close();
        }
        byte[] response = out.toByteArray();

        String location = "/Users/thejuandesire/Desktop/Test/ImageLayout/src/imagelayout/images/" + name + ".jpg";
        File image = new File(location);

        try (FileOutputStream fos = new FileOutputStream(image)) {
            fos.write(response);
            fos.flush();
            fos.close();
        }

        return ImageIO.read(new File(location));
    }

    public static String createString(String title, String released, String runtime,
            String genre, String actors, String plot, String imdbRating, String poster) {
        String content = "Title: " + title + "\nReleased: " + released
                + "\nRuntime: " + runtime + "\nGenre: " + genre + "\nActors: " + actors
                + "\nPlot: " + plot + "\nimdbRating: " + imdbRating + "\n";
        return content;
    }

}
