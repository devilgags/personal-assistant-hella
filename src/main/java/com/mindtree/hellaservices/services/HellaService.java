package com.mindtree.hellaservices.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletResponse;

public class HellaService implements Speechlet {
	private static final Logger logger = LoggerFactory.getLogger(HellaService.class);
	SpeechBuilder speechBuilder = null;

	public HellaService() {
		speechBuilder = new SpeechBuilder();
	}

	public void onSessionStarted(SessionStartedRequest request, Session session) {
		logger.info("Session started requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());
	}

	public SpeechletResponse onLaunch(LaunchRequest request, Session session) {
		logger.info("Launch started requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());
		return null;
	}

	public SpeechletResponse onIntent(IntentRequest intentRequest, Session session) {
		logger.info("Intent recieved requestId={}, sessionId={}", intentRequest.getRequestId(), session.getSessionId());
		return speechBuilder.getResponse(intentRequest.getIntent(), session);
	}

	public void onSessionEnded(SessionEndedRequest request, Session session) {
		logger.info("onSessionEnded requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());
	}
}
