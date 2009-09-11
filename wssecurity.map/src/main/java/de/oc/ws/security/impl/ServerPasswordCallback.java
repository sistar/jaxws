package de.oc.ws.security.impl;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServerPasswordCallback implements CallbackHandler {

	
	private Map<String, String> clientIds;

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {

		WSPasswordCallback wsPasswordCallback = (WSPasswordCallback) callbacks[0];

		if (wsPasswordCallback.getIdentifier().equals("hans")) {
			wsPasswordCallback.setPassword("geheim");
		}

		clientIds.put(wsPasswordCallback.getIdentifier(), "hansIdFromDb");

	}

	public void setClientIds(Map<String, String> clientIds) {
		this.clientIds = clientIds;
	}


}
