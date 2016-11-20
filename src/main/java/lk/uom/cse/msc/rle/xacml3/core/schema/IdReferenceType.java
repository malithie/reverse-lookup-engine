package lk.uom.cse.msc.rle.xacml3.core.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for IdReferenceType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="IdReferenceType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>anyURI">
 *       &lt;attribute name="Version" type="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}VersionMatchType" />
 *       &lt;attribute name="EarliestVersion" type="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}VersionMatchType"
 * />
 *       &lt;attribute name="LatestVersion" type="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}VersionMatchType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdReferenceType", propOrder = {
        "value"
})
public class IdReferenceType {

    @XmlAttribute(name = "EarliestVersion")
    protected String earliestVersion;
    @XmlAttribute(name = "LatestVersion")
    protected String latestVersion;
    @XmlValue
    @XmlSchemaType(name = "anyURI")
    protected String value;
    @XmlAttribute(name = "Version")
    protected String version;

    /**
     * Gets the value of the earliestVersion property.
     *
     * @return possible object is {@link String }
     */
    public String getEarliestVersion() {
        return earliestVersion;
    }

    /**
     * Gets the value of the latestVersion property.
     *
     * @return possible object is {@link String }
     */
    public String getLatestVersion() {
        return latestVersion;
    }

    /**
     * Gets the value of the value property.
     *
     * @return possible object is {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible object is {@link String }
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the earliestVersion property.
     *
     * @param value allowed object is {@link String }
     */
    public void setEarliestVersion(String value) {
        this.earliestVersion = value;
    }

    /**
     * Sets the value of the latestVersion property.
     *
     * @param value allowed object is {@link String }
     */
    public void setLatestVersion(String value) {
        this.latestVersion = value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value allowed object is {@link String }
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
