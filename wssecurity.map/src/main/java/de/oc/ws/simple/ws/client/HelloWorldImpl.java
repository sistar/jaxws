package de.oc.ws.simple.ws.client;

import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@WebService(endpointInterface = "de.oc.ws.simple.ws.client.HelloWorld")
@Service
public class HelloWorldImpl implements HelloWorld {
	@Resource
	WebServiceContext webServiceContext;

	
	private Map<String, String> clientIds;

	public String sayHi(Person person) {
		if (person != null)
			return "Hello "
					+ person.getFirst()
					+ " "
					+ person.getLast()
					+ " with clientId "
					+ clientIds.get(webServiceContext.getUserPrincipal()
							.getName());
		else
			return "person null";

	}
	@Autowired(required=true)
	public void setClientIds(Map<String, String> clientIds) {
		this.clientIds = clientIds;
	}

	
}
