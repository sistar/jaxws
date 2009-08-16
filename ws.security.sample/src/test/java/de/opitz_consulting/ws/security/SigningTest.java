package de.opitz_consulting.ws.security;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import static org.junit.Assert.*;
import static org.junit.matchers.StringContains.*;

import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.junit.Test;

import de.oc.ws.simple.ws.client.HelloWorld;
import de.oc.ws.simple.ws.client.Person;

public class SigningTest {
	@Test
	public void testSigning() throws Exception {
		String endpointAddress = "http://localhost:8081/simple.ws.client/HelloWorld";
		QName serviceName = new QName("http://client.ws.simple.ws.oc.de/",
				"HelloWorldImplService");
		QName portName = new QName("http://client.ws.simple.ws.oc.de/",
				"HelloWorldImplPort");

		Service service = Service.create(serviceName);
		service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING,
				endpointAddress);
		HelloWorld dynamicProxy = service.getPort(portName, HelloWorld.class);

		org.apache.cxf.endpoint.Client client = org.apache.cxf.frontend.ClientProxy
				.getClient(dynamicProxy);
		org.apache.cxf.endpoint.Endpoint cxfEndpoint = client.getEndpoint();

		Map<String, Object> outProps = new HashMap<String, Object>();
		outProps.put(WSHandlerConstants.ACTION, "Signature");
		outProps.put(WSHandlerConstants.USER, "numiga");
		outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,
				ClientCallbackHandler.class.getName());
		outProps
				.put(WSHandlerConstants.SIG_PROP_FILE, "client_sign.properties");

		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
		cxfEndpoint.getOutInterceptors().add(wssOut);

		Person x = new Person("steve", "x");
		String res = dynamicProxy.sayHi(x);
		assertThat(res, containsString("steve"));
	}
}
