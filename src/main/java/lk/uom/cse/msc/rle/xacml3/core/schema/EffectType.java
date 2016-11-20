package lk.uom.cse.msc.rle.xacml3.core.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EffectType.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="EffectType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Permit"/>
 *     &lt;enumeration value="Deny"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "EffectType")
@XmlEnum
public enum EffectType {

    @XmlEnumValue("Deny")
    DENY("Deny"),
    @XmlEnumValue("Permit")
    PERMIT("Permit");

    public static EffectType fromValue(String v) {
        for (EffectType c : EffectType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    private final String value;

    EffectType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

}
