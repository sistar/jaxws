
package de.numiga.doppler.datenmodell;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.numiga.doppler.datenmodell package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Verdopple_QNAME = new QName("http://numiga.de/doppler/datenmodell", "verdopple");
    private final static QName _VerdoppleResponse_QNAME = new QName("http://numiga.de/doppler/datenmodell", "verdoppleResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.numiga.doppler.datenmodell
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Verdopple }
     * 
     */
    public Verdopple createVerdopple() {
        return new Verdopple();
    }

    /**
     * Create an instance of {@link VerdoppleResponse }
     * 
     */
    public VerdoppleResponse createVerdoppleResponse() {
        return new VerdoppleResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Verdopple }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://numiga.de/doppler/datenmodell", name = "verdopple")
    public JAXBElement<Verdopple> createVerdopple(Verdopple value) {
        return new JAXBElement<Verdopple>(_Verdopple_QNAME, Verdopple.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerdoppleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://numiga.de/doppler/datenmodell", name = "verdoppleResponse")
    public JAXBElement<VerdoppleResponse> createVerdoppleResponse(VerdoppleResponse value) {
        return new JAXBElement<VerdoppleResponse>(_VerdoppleResponse_QNAME, VerdoppleResponse.class, null, value);
    }

}
