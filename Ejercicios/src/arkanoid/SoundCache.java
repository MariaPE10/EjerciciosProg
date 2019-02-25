package arkanoid;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class SoundCache extends ResourceCache{
	protected Object loadResource(URL url) {
		return Applet.newAudioClip(url);
		
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public AudioClip getAudioClip(String name) {
	  return (AudioClip)getResource(name);	
	}
	
	/**
	 * 
	 * @param name
	 */
	public void playSound(final String name) {
		 new Thread(
       new Runnable() {
       	public void run() {
			    getAudioClip(name).play();
       	}
       }
		 ).start();
	}
	
	/**
	 * 
	 * @param name
	 */
	public void loopSound(final String name) {
		new Thread(
	  new Runnable() {
	   public void run() {
			   getAudioClip(name).loop();
	   }
	  }
		).start();	}
	
	/**
	 * 
	 * @param name
	 */
	public void stop(final String name) {
		new Thread(
	  new Runnable() {
	   public void run() {
			   getAudioClip(name).stop();
	   }
	  }
		).start();	}

}
