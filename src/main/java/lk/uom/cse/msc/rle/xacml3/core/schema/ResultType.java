package lk.uom.cse.msc.rle.xacml3.core.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}Decision"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}Status" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}Obligations" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}AssociatedAdvice" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}Attributes" maxOccurs="unbounded"
 * minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}PolicyIdentifierList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultType", propOrder = {
        "decision",
        "status",
        "obligations",
        "associatedAdvice",
        "attributes",
        "policyIdentifierList"
})
public class ResultType {

    @XmlElement(name = "AssociatedAdvice")
    protected AssociatedAdviceType associatedAdvice;
    @XmlElement(name = "Attributes")
    protected List<AttributesType> attributes;
    @XmlElement(name = "Decision", required = true)
    protected DecisionType decision;
    @XmlElement(name = "Obligations")
    protected ObligationsType obligations;
    @XmlElement(name = "PolicyIdentifierList")
    protected PolicyIdentifierListType policyIdentifierList;
    @XmlElement(name = "Status")
    protected StatusType status;

    /**
     * Gets the value of the associatedAdvice property.
     *
     * @return possible object is {@link AssociatedAdviceType }
     */
    public AssociatedAdviceType getAssociatedAdvice() {
        return associatedAdvice;
    }

    /**
     * Gets the value of the attributes property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the attributes property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributes().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list {@link AttributesType }
     */
    public List<AttributesType> getAttributes() {
        if (attributes == null) {
            attributes = new ArrayList<AttributesType>();
        }
        return this.attributes;
    }

    /**
     * Gets the value of the decision property.
     *
     * @return possible object is {@link DecisionType }
     */
    public DecisionType getDecision() {
        return decision;
    }

    /**
     * Gets the value of the obligations property.
     *
     * @return possible object is {@link ObligationsType }
     */
    public ObligationsType getObligations() {
        return obligations;
    }

    /**
     * Gets the value of the policyIdentifierList property.
     *
     * @return possible object is {@link PolicyIdentifierListType }
     */
    public PolicyIdentifierListType getPolicyIdentifierList() {
        return policyIdentifierList;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is {@link StatusType }
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the associatedAdvice property.
     *
     * @param value allowed object is {@link AssociatedAdviceType }
     */
    public void setAssociatedAdvice(AssociatedAdviceType value) {
        this.associatedAdvice = value;
    }

    /**
     * Sets the value of the decision property.
     *
     * @param value allowed object is {@link DecisionType }
     */
    public void setDecision(DecisionType value) {
        this.decision = value;
    }

    /**
     * Sets the value of the obligations property.
     *
     * @param value allowed object is {@link ObligationsType }
     */
    public void setObligations(ObligationsType value) {
        this.obligations = value;
    }

    /**
     * Sets the value of the policyIdentifierList property.
     *
     * @param value allowed object is {@link PolicyIdentifierListType }
     */
    public void setPolicyIdentifierList(PolicyIdentifierListType value) {
        this.policyIdentifierList = value;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is {@link StatusType }
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }

}
