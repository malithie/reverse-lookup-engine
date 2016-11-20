package lk.uom.cse.msc.rle.xacml3.core.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PolicyIdentifierListType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PolicyIdentifierListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}PolicyIdReference"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}PolicySetIdReference"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PolicyIdentifierListType", propOrder = {
        "policyIdReferenceOrPolicySetIdReference"
})
public class PolicyIdentifierListType {

    @XmlElementRefs({
            @XmlElementRef(name = "PolicySetIdReference", namespace = "urn:oasis:names:tc:xacml:3.0:core:schema:wd-17", type = JAXBElement.class),
            @XmlElementRef(name = "PolicyIdReference", namespace = "urn:oasis:names:tc:xacml:3.0:core:schema:wd-17", type = JAXBElement.class)
    })
    protected List<JAXBElement<IdReferenceType>> policyIdReferenceOrPolicySetIdReference;

    /**
     * Gets the value of the policyIdReferenceOrPolicySetIdReference property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the policyIdReferenceOrPolicySetIdReference property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPolicyIdReferenceOrPolicySetIdReference().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list {@link JAXBElement }{@code <}{@link IdReferenceType
     * }{@code >} {@link JAXBElement }{@code <}{@link IdReferenceType }{@code >}
     */
    public List<JAXBElement<IdReferenceType>> getPolicyIdReferenceOrPolicySetIdReference() {
        if (policyIdReferenceOrPolicySetIdReference == null) {
            policyIdReferenceOrPolicySetIdReference = new ArrayList<JAXBElement<IdReferenceType>>();
        }
        return this.policyIdReferenceOrPolicySetIdReference;
    }

}
