package lk.uom.cse.msc.rle.xacml3.core.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AttributeAssignmentExpressionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AttributeAssignmentExpressionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}Expression"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AttributeId" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="Category" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="Issuer" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttributeAssignmentExpressionType", propOrder = {
        "expression"
})
public class AttributeAssignmentExpressionType {

    @XmlAttribute(name = "AttributeId", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String attributeId;
    @XmlAttribute(name = "Category")
    @XmlSchemaType(name = "anyURI")
    protected String category;
    @XmlElementRef(name = "Expression", namespace = "urn:oasis:names:tc:xacml:3.0:core:schema:wd-17", type = JAXBElement.class)
    protected JAXBElement<?> expression;
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
     * Gets the value of the category property.
     *
     * @return possible object is {@link String }
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the value of the expression property.
     *
     * @return possible object is {@link JAXBElement }{@code <}{@link FunctionType }{@code >} {@link JAXBElement }{@code
     * <}{@link VariableReferenceType }{@code >} {@link JAXBElement }{@code <}{@link AttributeDesignatorType }{@code >}
     * {@link JAXBElement }{@code <}{@link AttributeSelectorType }{@code >} {@link JAXBElement }{@code <}{@link
     * ApplyType }{@code >} {@link JAXBElement }{@code <}{@link ExpressionType }{@code >} {@link JAXBElement }{@code
     * <}{@link AttributeValueType }{@code >}
     */
    public JAXBElement<?> getExpression() {
        return expression;
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
     * Sets the value of the attributeId property.
     *
     * @param value allowed object is {@link String }
     */
    public void setAttributeId(String value) {
        this.attributeId = value;
    }

    /**
     * Sets the value of the category property.
     *
     * @param value allowed object is {@link String }
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Sets the value of the expression property.
     *
     * @param value allowed object is {@link JAXBElement }{@code <}{@link FunctionType }{@code >} {@link JAXBElement
     *              }{@code <}{@link VariableReferenceType }{@code >} {@link JAXBElement }{@code <}{@link
     *              AttributeDesignatorType }{@code >} {@link JAXBElement }{@code <}{@link AttributeSelectorType }{@code
     *              >} {@link JAXBElement }{@code <}{@link ApplyType }{@code >} {@link JAXBElement }{@code <}{@link
     *              ExpressionType }{@code >} {@link JAXBElement }{@code <}{@link AttributeValueType }{@code >}
     */
    public void setExpression(JAXBElement<?> value) {
        this.expression = value;
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
