package lk.uom.cse.msc.rle.xacml3.core.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VariableDefinitionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="VariableDefinitionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}Expression"/>
 *       &lt;/sequence>
 *       &lt;attribute name="VariableId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VariableDefinitionType", propOrder = {
        "expression"
})
public class VariableDefinitionType {

    @XmlElementRef(name = "Expression", namespace = "urn:oasis:names:tc:xacml:3.0:core:schema:wd-17", type = JAXBElement.class)
    protected JAXBElement<?> expression;
    @XmlAttribute(name = "VariableId", required = true)
    protected String variableId;

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
     * Gets the value of the variableId property.
     *
     * @return possible object is {@link String }
     */
    public String getVariableId() {
        return variableId;
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
     * Sets the value of the variableId property.
     *
     * @param value allowed object is {@link String }
     */
    public void setVariableId(String value) {
        this.variableId = value;
    }

}
