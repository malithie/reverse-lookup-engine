package lk.uom.cse.msc.rle.xacml3.core.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AttributeType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AttributeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}AttributeValue" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AttributeId" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="Issuer" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="IncludeInResult" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttributeType", propOrder = {
        "attributeValue"
})
public class AttributeType {

    @XmlAttribute(name = "AttributeId", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String attributeId;
    @XmlElement(name = "AttributeValue", required = true)
    protected List<AttributeValueType> attributeValue;
    @XmlAttribute(name = "IncludeInResult", required = true)
    protected boolean includeInResult;
    @XmlAttribute(name = "Issuer")
    protected String issuer;

    /**
     * Gets the value of the attributeId property.
     *
     * @return possible object is {@link String }
     */
    public String getAttributeId() {
        return attributeId;
    }

    /**
     * Gets the value of the attributeValue property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the attributeValue property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeValue().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list {@link AttributeValueType }
     */
    public List<AttributeValueType> getAttributeValue() {
        if (attributeValue == null) {
            attributeValue = new ArrayList<AttributeValueType>();
        }
        return this.attributeValue;
    }

    /**
     * Gets the value of the issuer property.
     *
     * @return possible object is {@link String }
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * Gets the value of the includeInResult property.
     */
    public boolean isIncludeInResult() {
        return includeInResult;
    }

    /**
     * Sets the value of the attributeId property.
     *
     * @param value allowed object is {@link String }
     */
    public void setAttributeId(String value) {
        this.attributeId = value;
    }

    /**
     * Sets the value of the includeInResult property.
     */
    public void setIncludeInResult(boolean value) {
        this.includeInResult = value;
    }

    /**
     * Sets the value of the issuer property.
     *
     * @param value allowed object is {@link String }
     */
    public void setIssuer(String value) {
        this.issuer = value;
    }

}
