
package de.oc.ws.simple.ws.client;

import javax.jws.WebService;

@WebService(endpointInterface = "de.oc.ws.simple.ws.client.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(Person person) {
    	if(person != null)
        return "Hello " + person.getFirst() + " " + person.getLast();
    	else 
    		return "person null";
    	
    }
}

