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
 * <p>Java class for AdviceType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AdviceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}AttributeAssignment" maxOccurs="unbounded"
 * minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AdviceId" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdviceType", propOrder = {
        "attributeAssignment"
})
public class AdviceType {

    @XmlAttribute(name = "AdviceId", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String adviceId;
    @XmlElement(name = "AttributeAssignment")
    protected List<AttributeAssignmentType> attributeAssignment;

    /**
     * Gets the value of the adviceId property.
     *
     * @return possible object is {@link String }
     */
    public String getAdviceId() {
        return adviceId;
    }

    /**
     * Gets the value of the attributeAssignment property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the attributeAssignment property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeAssignment().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list {@link AttributeAssignmentType }
     */
    public List<AttributeAssignmentType> getAttributeAssignment() {
        if (attributeAssignment == null) {
            attributeAssignment = new ArrayList<AttributeAssignmentType>();
        }
        return this.attributeAssignment;
    }

    /**
     * Sets the value of the adviceId property.
     *
     * @param value allowed object is {@link String }
     */
    public void setAdviceId(String value) {
        this.adviceId = value;
    }

}
