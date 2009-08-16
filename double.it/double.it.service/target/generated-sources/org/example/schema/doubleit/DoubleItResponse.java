
package org.example.schema.doubleit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="doubledNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "doubledNumber"
})
@XmlRootElement(name = "DoubleItResponse")
public class DoubleItResponse {

    protected int doubledNumber;

    /**
     * Gets the value of the doubledNumber property.
     * 
     */
    public int getDoubledNumber() {
        return doubledNumber;
    }

    /**
     * Sets the value of the doubledNumber property.
     * 
     */
    public void setDoubledNumber(int value) {
        this.doubledNumber = value;
    }

}
