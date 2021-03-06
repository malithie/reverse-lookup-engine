package lk.uom.cse.msc.rle.xacml3.core.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatusType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="StatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}StatusCode"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}StatusMessage" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}StatusDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusType", propOrder = {
        "statusCode",
        "statusMessage",
        "statusDetail"
})
public class StatusType {

    @XmlElement(name = "StatusCode", required = true)
    protected StatusCodeType statusCode;
    @XmlElement(name = "StatusDetail")
    protected StatusDetailType statusDetail;
    @XmlElement(name = "StatusMessage")
    protected String statusMessage;

    /**
     * Gets the value of the statusCode property.
     *
     * @return possible object is {@link StatusCodeType }
     */
    public StatusCodeType getStatusCode() {
        return statusCode;
    }

    /**
     * Gets the value of the statusDetail property.
     *
     * @return possible object is {@link StatusDetailType }
     */
    public StatusDetailType getStatusDetail() {
        return statusDetail;
    }

    /**
     * Gets the value of the statusMessage property.
     *
     * @return possible object is {@link String }
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * Sets the value of the statusCode property.
     *
     * @param value allowed object is {@link StatusCodeType }
     */
    public void setStatusCode(StatusCodeType value) {
        this.statusCode = value;
    }

    /**
     * Sets the value of the statusDetail property.
     *
     * @param value allowed object is {@link StatusDetailType }
     */
    public void setStatusDetail(StatusDetailType value) {
        this.statusDetail = value;
    }

    /**
     * Sets the value of the statusMessage property.
     *
     * @param value allowed object is {@link String }
     */
    public void setStatusMessage(String value) {
        this.statusMessage = value;
    }

}
