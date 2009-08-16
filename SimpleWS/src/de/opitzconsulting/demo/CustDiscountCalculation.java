package de.opitzconsulting.demo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name="CustDiscountCalculation", targetNamespace="http://demo.opitzconsulting.de/")
public interface CustDiscountCalculation {

	@WebMethod(operationName="calcFinalPrice", action="urn:CalcFinalPrice")
	@RequestWrapper(className="de.opitzconsulting.demo.CalcFinalPrice", localName="calcFinalPrice", targetNamespace="http://demo.opitzconsulting.de/")
	@ResponseWrapper(className="de.opitzconsulting.demo.CalcFinalPriceResponse", localName="calcFinalPriceResponse", targetNamespace="http://demo.opitzconsulting.de/")
	public double calcFinalPrice(@WebParam(name="custId") String custId, @WebParam(name="basePrice") double basePrice);

}