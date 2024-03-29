package org.doubleit.service;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import org.example.contract.doubleit.DoubleItPortType;

@WebService(targetNamespace = "http://www.example.org/contract/DoubleIt", endpointInterface = "org.example.contract.doubleit.DoubleItPortType", portName = "DoubleItSOAP", serviceName = "DoubleIt")
public class DoubleItServiceImpl implements DoubleItPortType {
	//zugriff auf den WebserviceContext
	@Resource
	WebServiceContext wsContext;

	@Override
	public int doubleIt(int numberToDouble) {
		System.out.println(wsContext.getMessageContext().keySet());
		return numberToDouble * 2;
	}

}
