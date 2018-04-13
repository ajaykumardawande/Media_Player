/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amedia;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import static javax.swing.Spring.height;

/**
 *
 * @author Ajya
 */
public class FXMLDocumentController implements Initializable {
    public String filePath;
    
    private MediaPlayer mediaPlayer;
    @FXML
    private MediaView mediaView;
    
    @FXML
    private Slider slider;
    @FXML
    private Slider seekSlider;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file(*.mp4)", "*mp4");
            fileChooser.getExtensionFilters().add(filter);
            File file = fileChooser.showOpenDialog(null);
            filePath  = file.toURI().toString();
            System.out.println(filePath);
            if(filePath != null) {
                Media media = new Media(filePath);
                mediaPlayer = new MediaPlayer(media);
                mediaView.setMediaPlayer(mediaPlayer);
               //DoubleProperty width = mediaView.fitWidthProperty();
                //DoubleProperty hight = mediaView.fitHeightProperty();
                //width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
                //hight.bind(Bindings.selectDouble(mediaView.sceneProperty(), "hight"));
                
                
                DoubleProperty width  =  mediaView.fitWidthProperty();
                DoubleProperty height  =  mediaView.fitHeightProperty();
                
                width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
                height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
                
                        
                        
                        
                        
                        
                        
                        
                
                        
                slider.setValue(mediaPlayer.getVolume() * 100);
                slider .valueProperty().addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {
                        mediaPlayer.setVolume(slider.getValue()/100);
                        
                    }
                });
                
                mediaPlayer.currentTimeProperty().addListener(new ChangeListener() {
                public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                    seekSlider.setValue(newValue.toSeconds());
                }

                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
          
                   
                });
                
                seekSlider.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        mediaPlayer.seek(Duration.seconds(seekSlider.getValue()));
                    }
                });
                mediaPlayer.play();
             
            }
            
        
        
    }
    @FXML
    private  void pauseVideo(ActionEvent event) {
        mediaPlayer.pause();
        
    }
    
    @FXML
    private  void playVideo(ActionEvent event) {
        mediaPlayer.play();
        mediaPlayer.setRate(1);
    }
    @FXML
    private  void stopVideo(ActionEvent event) {
        mediaPlayer.stop();
    }
    @FXML
    private  void fastVideo(ActionEvent event) {
        mediaPlayer.setRate(1.5);
        
    }
    @FXML
    private  void fasterVideo(ActionEvent event) {
        mediaPlayer.setRate(2);
        
    }
    @FXML
    private  void slowVideo(ActionEvent event) {
        mediaPlayer.setRate(.75);
    }
    @FXML
    private  void slowerVideo(ActionEvent event) {
        mediaPlayer.setRate(.5);
    }
    @FXML
    private  void reloadVideo(ActionEvent event) {
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.play();
        
    }
    @FXML
    private  void exitVideo(ActionEvent event) {
        System.exit(0);
        
    }
     public  void sfile() {
         System.out.println("ajay");
        File Video;
         Video = new File(filePath);
         System.out.println("filePath");
        VideoToAudio.ConvertToAudio(Video);
         }
    @FXML
    private void soundfile(ActionEvent event) {
        System.out.println("HEllo");
        System.out.println(filePath);
        String result = filePath.replace("/", "\\\\");
    String res = result.replace("file:\\\\", "");
    System.out.println(res);
       File Video;
         Video = new File(res);
        VideoToAudio.ConvertToAudio(Video);
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void play(String filePath) {
        
    }
    
}
