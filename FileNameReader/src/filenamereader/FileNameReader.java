/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filenamereader;

import java.io.File;
import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;
import static java.lang.Math.random;
import java.nio.file.Files;
import javax.swing.JFileChooser;


/**
 *
 * @author Willy
 */
public class FileNameReader extends Application 
{
 
    /*public static void main(String[] args) 
    {
        launch(args);
    }*/
    
    @Override
    public void start(Stage primaryStage) throws IOException 
    {  

        
        
        
        
        
        File folder = new File("/Users/jridao5/Documents/Test/Movies"); //makes a path to the specified folder
        File[] listOfFiles = folder.listFiles(); //makes an arrayList of file objects
        
        for (File movie : listOfFiles)
        {
                String title = movie.getName().substring(0,movie.getName().indexOf("."));
                System.out.println("Title: " + title); //title.getName() gets the title of the file
        }
    }
}