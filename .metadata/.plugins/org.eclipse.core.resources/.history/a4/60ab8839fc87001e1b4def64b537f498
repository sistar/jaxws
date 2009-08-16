package de.opitz_consulting.demo;

import static org.junit.Assert.*;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.junit.Test;

public class SimpleWSClientTest {

	QName serviceName = new QName("http://demo.opitzconsulting.de/",
			"DiscountCalculatorService");
	QName portName = new QName("http://demo.opitzconsulting.de/",
			"DiscountCalculatorPort");
	Service service = Service.create(serviceName);

	@Test
	public void testServiceAv() throws Exception {
		assertNotNull(service);
		service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING,
				"http://localhost:8080/SimpleWS/services/discountcalculator");
		de.opitz_consulting.demo.CustDiscountCalculation dynamicProxy = service
				.getPort(portName,
						de.opitz_consulting.demo.CustDiscountCalculation.class);
		double actual = dynamicProxy.calcFinalPrice("abc", 1);
		assertEquals(3.01d, actual,0.01);
	}

}
