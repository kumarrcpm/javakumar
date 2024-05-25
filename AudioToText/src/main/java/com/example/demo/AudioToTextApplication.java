package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.assemblyai.api.AssemblyAI;
import com.assemblyai.api.resources.transcripts.types.Transcript;
import com.assemblyai.api.resources.transcripts.types.TranscriptOptionalParams;
@SpringBootApplication
public class AudioToTextApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudioToTextApplication.class, args);
		 audioToText();
	}

	private static String audioToText() {
		// TODO Auto-generated method stub
		AssemblyAI assemblyAI = AssemblyAI.builder()
								.apiKey("da591b952dc049bd89349718e13721db")
								.build();
String url="https://drive.google.com/uc?export=download&id=1Z3cSnPLO05t9jc7Hp-rQhK4PeeBXATYy";
var  config = TranscriptOptionalParams.builder()
									  .speakerLabels(true)
									  .build();	
Transcript transcript = assemblyAI.transcripts().transcribe(url,config);
		System.out.println("Without Speaker  "+transcript.getText());
		
transcript.getUtterances().ifPresent(utterances ->
							utterances.forEach(utterance ->
							System.out.println("Speaker "+ utterance.getSpeaker()+":"+utterance.getText())
									)); 		
		return null;
	}

}
