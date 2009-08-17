
package de.numiga.doppler.datenmodell;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for verdopple complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="verdopple">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="eingabe" type="{http://numiga.de/doppler/datenmodell}eingabeTyp"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verdopple", propOrder = {
    "eingabe"
})
public class Verdopple {

    protected int eingabe;

    /**
     * Gets the value of the eingabe property.
     * 
     */
    public int getEingabe() {
        return eingabe;
    }

    /**
     * Sets the value of the eingabe property.
     * 
     */
    public void setEingabe(int value) {
        this.eingabe = value;
    }

}
