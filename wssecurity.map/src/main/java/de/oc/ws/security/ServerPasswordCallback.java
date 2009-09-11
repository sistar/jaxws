package de.oc.ws.security;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class ServerPasswordCallback implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		WSPasswordCallback wsPasswordCallback = (WSPasswordCallback) callbacks[0];
		if (wsPasswordCallback.getIdentifier().equals("hans")) {
			wsPasswordCallback.setIdentifier("geheim");
		}
	}
}
