package lk.uom.cse.msc.rle.xacml3.core.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MatchType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="MatchType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}AttributeValue"/>
 *         &lt;choice>
 *           &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}AttributeDesignator"/>
 *           &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}AttributeSelector"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="MatchId" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatchType", propOrder = {
        "attributeValue",
        "attributeDesignator",
        "attributeSelector"
})
public class MatchType {

    @XmlElement(name = "AttributeDesignator")
    protected AttributeDesignatorType attributeDesignator;
    @XmlElement(name = "AttributeSelector")
    protected AttributeSelectorType attributeSelector;
    @XmlElement(name = "AttributeValue", required = true)
    protected AttributeValueType attributeValue;
    @XmlAttribute(name = "MatchId", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String matchId;

    /**
     * Gets the value of the attributeDesignator property.
     *
     * @return possible object is {@link AttributeDesignatorType }
     */
    public AttributeDesignatorType getAttributeDesignator() {
        return attributeDesignator;
    }

    /**
     * Gets the value of the attributeSelector property.
     *
     * @return possible object is {@link AttributeSelectorType }
     */
    public AttributeSelectorType getAttributeSelector() {
        return attributeSelector;
    }

    /**
     * Gets the value of the attributeValue property.
     *
     * @return possible object is {@link AttributeValueType }
     */
    public AttributeValueType getAttributeValue() {
        return attributeValue;
    }

    /**
     * Gets the value of the matchId property.
     *
     * @return possible object is {@link String }
     */
    public String getMatchId() {
        return matchId;
    }

    /**
     * Sets the value of the attributeDesignator property.
     *
     * @param value allowed object is {@link AttributeDesignatorType }
     */
    public void setAttributeDesignator(AttributeDesignatorType value) {
        this.attributeDesignator = value;
    }

    /**
     * Sets the value of the attributeSelector property.
     *
     * @param value allowed object is {@link AttributeSelectorType }
     */
    public void setAttributeSelector(AttributeSelectorType value) {
        this.attributeSelector = value;
    }

    /**
     * Sets the value of the attributeValue property.
     *
     * @param value allowed object is {@link AttributeValueType }
     */
    public void setAttributeValue(AttributeValueType value) {
        this.attributeValue = value;
    }

    /**
     * Sets the value of the matchId property.
     *
     * @param value allowed object is {@link String }
     */
    public void setMatchId(String value) {
        this.matchId = value;
    }

}
