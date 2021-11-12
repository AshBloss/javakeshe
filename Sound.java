import javax.sound.sampled.*;
import java.io.*;
public class Sound {
	String musicPath;
	volatile boolean run = true;
	Thread mainThread;
	AudioInputStream audioStream;
	AudioFormat audioFormat;
	SourceDataLine sourceDataLine;
	public Sound(String musicPath) {
		this.musicPath = musicPath;
		prefetch();
	}
	public void prefetch(){
		try{
	    audioStream = AudioSystem.getAudioInputStream(new File(musicPath));
		audioFormat = audioStream.getFormat();
		DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class,audioFormat,AudioSystem.NOT_SPECIFIED);
		sourceDataLine = (SourceDataLine)AudioSystem.getLine(dataLineInfo);
		sourceDataLine.open(audioFormat);
		sourceDataLine.start();
		}catch(UnsupportedAudioFileException ex){
			ex.printStackTrace();
		}catch(LineUnavailableException ex){
			ex.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}	
	}
	public void playMusic(boolean loop)throws InterruptedException {
		try{
				if(loop){
					while(true){
						playMusic();
					}
				}else{
					playMusic();
					sourceDataLine.drain();
					sourceDataLine.close();
					audioStream.close();
				}
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		
	}
	public void playMusic(){
		try{
			synchronized(this){
				run = true;
			}
			audioStream = AudioSystem.getAudioInputStream(new File(musicPath));
			int count;
			byte tempBuff[] = new byte[1024];
			
				while((count = audioStream.read(tempBuff,0,tempBuff.length)) != -1){
					synchronized(this){
					while(!run)
						wait();
					}
					sourceDataLine.write(tempBuff,0,count);
							
			}
 
		}catch(UnsupportedAudioFileException ex){
			ex.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		
	}
	public void start(boolean loop){
		mainThread = new Thread(new Runnable(){
			public void run(){
				try {
					playMusic(loop);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		mainThread.start();
	} 
 }