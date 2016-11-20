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
 * <p>Java class for ObligationExpressionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ObligationExpressionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}AttributeAssignmentExpression"
 * maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ObligationId" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="FulfillOn" use="required" type="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}EffectType"
 * />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObligationExpressionType", propOrder = {
        "attributeAssignmentExpression"
})
public class ObligationExpressionType {

    @XmlElement(name = "AttributeAssignmentExpression")
    protected List<AttributeAssignmentExpressionType> attributeAssignmentExpression;
    @XmlAttribute(name = "FulfillOn", required = true)
    protected EffectType fulfillOn;
    @XmlAttribute(name = "ObligationId", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String obligationId;

    /**
     * Gets the value of the attributeAssignmentExpression property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the attributeAssignmentExpression property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeAssignmentExpression().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list {@link AttributeAssignmentExpressionType }
     */
    public List<AttributeAssignmentExpressionType> getAttributeAssignmentExpression() {
        if (attributeAssignmentExpression == null) {
            attributeAssignmentExpression = new ArrayList<AttributeAssignmentExpressionType>();
        }
        return this.attributeAssignmentExpression;
    }

    /**
     * Gets the value of the fulfillOn property.
     *
     * @return possible object is {@link EffectType }
     */
    public EffectType getFulfillOn() {
        return fulfillOn;
    }

    /**
     * Gets the value of the obligationId property.
     *
     * @return possible object is {@link String }
     */
    public String getObligationId() {
        return obligationId;
    }

    /**
     * Sets the value of the fulfillOn property.
     *
     * @param value allowed object is {@link EffectType }
     */
    public void setFulfillOn(EffectType value) {
        this.fulfillOn = value;
    }

    /**
     * Sets the value of the obligationId property.
     *
     * @param value allowed object is {@link String }
     */
    public void setObligationId(String value) {
        this.obligationId = value;
    }

}
