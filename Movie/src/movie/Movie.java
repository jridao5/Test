/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import java.awt.Image;
//import javafx.scene.image.Image;

/**
 *
 * @author thejuandesire
 */
public class Movie {
    private String description;
    private Image poster;
            
    public Movie(Image picture, String content){
        poster = picture;
        description = content;
    }
    
    private void printDescription(){
        System.out.println(description);
    }
    
}
