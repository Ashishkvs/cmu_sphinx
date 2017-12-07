package com.nt.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

public class Audio {
	public  String audioToText()throws IOException {

		Configuration configuration = new Configuration();

		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
		configuration.setSampleRate(8000);
		StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
		InputStream stream = new FileInputStream(new File("newone.wav"));

		recognizer.startRecognition(stream);
		SpeechResult result;
		System.out.println("Audio conversion from recorded file started...");
		//to store all
		String summary="";
		
		while ((result = recognizer.getResult()) != null) {
			System.out.format("Hypothesis: %s\n", result.getHypothesis());
			//collect all speech at one place
			summary = summary + result.getHypothesis();
			 
		}
		recognizer.stopRecognition();
		System.out.println("Done...");
		return summary;

}
}
