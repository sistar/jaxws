package de.opitzconsulting.demo;

import javax.jws.WebService;

@WebService(name="DiscountCalculator", endpointInterface="de.opitzconsulting.demo.CustDiscountCalculation", targetNamespace="http://demo.opitzconsulting.de/", portName="DiscountCalculatorPort", serviceName="DiscountCalculatorService")
public class DiscountCalculator implements CustDiscountCalculation {
	public double calcFinalPrice(String custId, double basePrice) {
		return 3.0d;
	}
}
