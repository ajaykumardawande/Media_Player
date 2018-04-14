
package amedia;
import java.io.File;
import it.sauronsoftware.jave.*;



public class VideoToAudio {
    
    public  static  void ConvertToAudio(File video) {
        File Audio = new File("C:\\Users\\Ajya\\Downloads\\convert.wav");
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(new Integer(128000));
        audio.setChannels(new Integer(2));
        audio.setSamplingRate(new Integer(44100));
        
        EncodingAttributes attr = new EncodingAttributes();
        attr.setFormat("wav");
        attr.setAudioAttributes(audio);
        
        Encoder encode = new Encoder();
        try {
               encode.encode(video, Audio, attr);
               System.err.println("convert");
        }
        catch(Exception e) {
                System.err.println(e.toString());
        }
        }
    }
    
