package de.oc.ws.simple.ws.client;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHi(Person text);
}

