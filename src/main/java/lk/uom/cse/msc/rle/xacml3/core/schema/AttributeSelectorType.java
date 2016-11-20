package lk.uom.cse.msc.rle.xacml3.core.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AttributeSelectorType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AttributeSelectorType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}ExpressionType">
 *       &lt;attribute name="Category" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="ContextSelectorId" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="Path" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DataType" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="MustBePresent" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttributeSelectorType")
public class AttributeSelectorType
        extends ExpressionType {

    @XmlAttribute(name = "Category", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String category;
    @XmlAttribute(name = "ContextSelectorId")
    @XmlSchemaType(name = "anyURI")
    protected String contextSelectorId;
    @XmlAttribute(name = "DataType", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String dataType;
    @XmlAttribute(name = "MustBePresent", required = true)
    protected boolean mustBePresent;
    @XmlAttribute(name = "Path", required = true)
    protected String path;

    /**
     * Gets the value of the category property.
     *
     * @return possible object is {@link String }
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the value of the contextSelectorId property.
     *
     * @return possible object is {@link String }
     */
    public String getContextSelectorId() {
        return contextSelectorId;
    }

    /**
     * Gets the value of the dataType property.
     *
     * @return possible object is {@link String }
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * Gets the value of the path property.
     *
     * @return possible object is {@link String }
     */
    public String getPath() {
        return path;
    }

    /**
     * Gets the value of the mustBePresent property.
     */
    public boolean isMustBePresent() {
        return mustBePresent;
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
     * Sets the value of the contextSelectorId property.
     *
     * @param value allowed object is {@link String }
     */
    public void setContextSelectorId(String value) {
        this.contextSelectorId = value;
    }

    /**
     * Sets the value of the dataType property.
     *
     * @param value allowed object is {@link String }
     */
    public void setDataType(String value) {
        this.dataType = value;
    }

    /**
     * Sets the value of the mustBePresent property.
     */
    public void setMustBePresent(boolean value) {
        this.mustBePresent = value;
    }

    /**
     * Sets the value of the path property.
     *
     * @param value allowed object is {@link String }
     */
    public void setPath(String value) {
        this.path = value;
    }

}
