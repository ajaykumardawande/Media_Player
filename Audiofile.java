/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amedia;

import java.io.File;

/**
 *
 * @author Ajya
 */
public class Audiofile {
    public static void main(String[] args) {
        File Video;
         Video = new File("C:\\Users\\Ajya\\Downloads\\Hawayein4.mp4");
        VideoToAudio.ConvertToAudio(Video);
    }
    
    
}
