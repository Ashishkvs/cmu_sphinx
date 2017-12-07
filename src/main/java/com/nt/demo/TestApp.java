package com.nt.demo;

import java.io.IOException;

public class TestApp {
	/**
	 * Both are using same resource better to use one by one
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		/**
		 *  for live Conversion speech to text
		 */
		
		Microphone microphone=new Microphone();
		System.out.println(microphone.liveConversion());
		
		/**
		 * for Recorded File Conversion audio to text
		 */
		/*Audio audio=new Audio();
		System.out.println(audio.audioToText());*/
	}

}
