/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsontest;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author thejuandesire
 */
public class Movie {
    
    private String description;
    private BufferedImage poster;
            
    public Movie(BufferedImage picture, String content){
        poster = picture;
        description = content;
    }
    
    /**
     *
     * @return
     */
    public String getDescription(){
        return description;
    }
    
    /**
     *
     * @return
     */
    public BufferedImage getImage(){
        return poster;
    }
    
}

