package uo.cpm.p8.player;


import java.io.File;
import java.util.Random;

import javazoom.jlgui.basicplayer.*;

public class MusicPlayer {
	
	private BasicPlayer basicPlayer = null;
	
	public MusicPlayer(){
		basicPlayer = new BasicPlayer();
	}
	
	public void play (File file){
		try {
			basicPlayer.open(file);
			basicPlayer.play();
		}
		catch (Exception e){	
			
		}
	}
	
	public void stop(){
		try {
			basicPlayer.stop();
		}
		catch (BasicPlayerException e){
		}
	}
	
	public void setVolume(double vol, double volMax){
		try{
			
			basicPlayer.setGain(vol/volMax);
		}
		catch (BasicPlayerException e){
		}
	}
	
	public int random(int size) {
		Random rd = new Random();
		int value = rd.nextInt();
		return value;
	}
}
