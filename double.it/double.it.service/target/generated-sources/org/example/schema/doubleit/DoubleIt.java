
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
 *         &lt;element name="numberToDouble" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "numberToDouble"
})
@XmlRootElement(name = "DoubleIt")
public class DoubleIt {

    protected int numberToDouble;

    /**
     * Gets the value of the numberToDouble property.
     * 
     */
    public int getNumberToDouble() {
        return numberToDouble;
    }

    /**
     * Sets the value of the numberToDouble property.
     * 
     */
    public void setNumberToDouble(int value) {
        this.numberToDouble = value;
    }

}
