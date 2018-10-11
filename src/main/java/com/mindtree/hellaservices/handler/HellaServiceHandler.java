package com.mindtree.hellaservices.handler;

import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;
import com.mindtree.hellaservices.services.HellaService;

public class HellaServiceHandler extends SpeechletRequestStreamHandler{
	private static final Set<String> supportedApplicationIds = new HashSet<String>();
	static {
        supportedApplicationIds.add("amzn1.ask.skill.5aecd6d6-a5df-4be6-b6d9-d1654bfe9ad3");
    }
	public HellaServiceHandler() {
		super(new HellaService(), supportedApplicationIds);
	}

}
