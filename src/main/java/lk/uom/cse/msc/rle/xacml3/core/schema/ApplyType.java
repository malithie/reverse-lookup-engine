package lk.uom.cse.msc.rle.xacml3.core.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApplyType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ApplyType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}ExpressionType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}Description" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}Expression" maxOccurs="unbounded"
 * minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="FunctionId" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplyType", propOrder = {
        "description",
        "expression"
})
public class ApplyType
        extends ExpressionType {

    @XmlElement(name = "Description")
    protected String description;
    @XmlElementRef(name = "Expression", namespace = "urn:oasis:names:tc:xacml:3.0:core:schema:wd-17", type = JAXBElement.class)
    protected List<JAXBElement<?>> expression;
    @XmlAttribute(name = "FunctionId", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String functionId;

    /**
     * Gets the value of the description property.
     *
     * @return possible object is {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the value of the expression property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the expression property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExpression().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list {@link JAXBElement }{@code <}{@link FunctionType }{@code
     * >} {@link JAXBElement }{@code <}{@link VariableReferenceType }{@code >} {@link JAXBElement }{@code <}{@link
     * AttributeDesignatorType }{@code >} {@link JAXBElement }{@code <}{@link AttributeSelectorType }{@code >} {@link
     * JAXBElement }{@code <}{@link ApplyType }{@code >} {@link JAXBElement }{@code <}{@link ExpressionType }{@code >}
     * {@link JAXBElement }{@code <}{@link AttributeValueType }{@code >}
     */
    public List<JAXBElement<?>> getExpression() {
        if (expression == null) {
            expression = new ArrayList<JAXBElement<?>>();
        }
        return this.expression;
    }

    /**
     * Gets the value of the functionId property.
     *
     * @return possible object is {@link String }
     */
    public String getFunctionId() {
        return functionId;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Sets the value of the functionId property.
     *
     * @param value allowed object is {@link String }
     */
    public void setFunctionId(String value) {
        this.functionId = value;
    }

}
