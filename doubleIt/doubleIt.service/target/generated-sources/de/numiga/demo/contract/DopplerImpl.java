package de.numiga.demo.contract;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.3
 * Mon Aug 17 16:18:42 CEST 2009
 * Generated source version: 2.2.3
 * 
 */
 
@WebService(targetNamespace = "http://demo.numiga.de/contract", name = "DopplerImpl")
@XmlSeeAlso({de.numiga.doppler.datenmodell.ObjectFactory.class})
public interface DopplerImpl {

    @WebResult(name = "return", targetNamespace = "http://numiga.de/doppler/datenmodell")
    @RequestWrapper(localName = "verdopple", targetNamespace = "http://numiga.de/doppler/datenmodell", className = "de.numiga.doppler.datenmodell.Verdopple")
    @ResponseWrapper(localName = "verdoppleResponse", targetNamespace = "http://numiga.de/doppler/datenmodell", className = "de.numiga.doppler.datenmodell.VerdoppleResponse")
    @WebMethod
    public int verdopple(
        @WebParam(name = "eingabe", targetNamespace = "http://numiga.de/doppler/datenmodell")
        int eingabe
    );
}