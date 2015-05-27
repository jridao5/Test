/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloadimages;

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
 * @author jridao5
 */
public class DownloadImages extends Application {
    
    @Override
    public void start(Stage primaryStage) throws MalformedURLException, IOException 
    {
        URL url = new URL("http://ia.media-imdb.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg");
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
        
        File image = new File("/Users/thejuandesire/Documents/Rafael/Posters/Batman Begins.jpg");
        
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
