package com.mindtree.hellaservices.services;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

public class SpeechBuilder {

	public SpeechBuilder() {
		// venusSilkAlexaServicesIntegration = new
		// VenusSilkAlexaServicesIntegration();
	}

	public SpeechletResponse getResponse(Intent intent, Session session) {
		String intentName = (intent != null) ? intent.getName() : null;
		System.out.println("Intent Found:" + intentName);
		switch (intentName) {
		case "HelloIntent":
			return getHelloIntent(intent, session);
		case "IntroIntent":
			return getIntroIntent(intent, session);
		default:
			return getDefaultResponse();
		}
	}

	private SpeechletResponse getHelloIntent(Intent intent, Session session) {
		String helloMessage = "Hello";
		return createTellResponse("Hello", helloMessage);
	}

	private SpeechletResponse getIntroIntent(Intent intent, Session session) {
		String employeeName = intent.getSlot("EmployeeName").getValue();
		if (employeeName.equalsIgnoreCase("Gagan")) {
			String helloMessage = "Are you talking about Gagan Vasudev , the swagger of Open Platform Centre of Excellence. He is a senior software engineer with experience on plethora of technologies like Blockchain, Spring Boot, NodeJS, Docker, React JS, Angular J S and devops. If you want to know about the latest stuff going in C.T.O , then he is the right person to get in touch with.";
			return createTellResponse("Intro", helloMessage);
		} else if(employeeName.equalsIgnoreCase("Puneet")){
			String helloMessage = "Are you talking about Puneet Joshi ,the proper full stack engineer of Open Platform Centre of Excellence. He is an experienced professional with domain knowledge of various client side MVCs and various blockchain flavours.";
			return createTellResponse("Intro", helloMessage);
		}
		else if(employeeName.equalsIgnoreCase("Ajit")|| employeeName.equalsIgnoreCase("Ajith")){
			String helloMessage = "Are you talking about Ajit Singh, the automation geek of open platform centre of excellence. He is very well versed with automation techniques and has experience in various technologies like NodeJS, Git CI, Jenkins, Data Visualization and Analysis using ELK Stack. He is currently the GitLAB admin of OPCOE.";
			return createTellResponse("Intro", helloMessage);
		}
		else{
			String helloMessage = "sample message";
			return createTellResponse("Intro", helloMessage);
		}
	}

	

	private SpeechletResponse getDefaultResponse() {
		SpeechletResponse speechletResponse = createTellResponse("Default",
				"Sorry I am not able to answer you that please ask me something else");
		return speechletResponse;
	}

	private SpeechletResponse createTellResponse(String title, String message) {
		// Create the Simple card content.
		SimpleCard card = new SimpleCard();
		card.setTitle(title);
		card.setContent(message);
		// Create the plain text output.
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(message);
		return SpeechletResponse.newTellResponse(speech, card);
	}

	public SpeechletResponse createAskResponse(String title, String message, String repromptMessage) {
		// Create the Simple card content.
		SimpleCard card = new SimpleCard();
		card.setTitle(title);
		card.setContent(message);

		// Create the plain text output.
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(message);

		// Create re-prompt
		PlainTextOutputSpeech repromptSpeech = new PlainTextOutputSpeech();
		repromptSpeech.setText(repromptMessage);
		Reprompt reprompt = new Reprompt();
		reprompt.setOutputSpeech(repromptSpeech);

		return SpeechletResponse.newAskResponse(speech, reprompt, card);
	}
}
